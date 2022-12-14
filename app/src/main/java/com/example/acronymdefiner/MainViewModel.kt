package com.example.acronymdefiner

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.acronymdefiner.model.Definitions
import com.example.acronymdefiner.model.Variation
import com.example.acronymdefiner.network.NetworkApi
import com.example.acronymdefiner.network.NetworkService
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val mutableDefinitionList = MutableLiveData<List<String>>()
    val definitionList: LiveData<List<String>> = mutableDefinitionList

    private var serviceApi: NetworkApi = NetworkService().api

    fun fetchDefinitions(sf: String) {
        viewModelScope.launch {
            // handle networks errors
            val definitions = try {
                serviceApi.fetchDefinitions(sf)
            } catch (e: Exception) {
                // log exception
                Definitions()
            }
            if (!definitions.isEmpty()) {
                val variations = definitions.first().lfs.map { it.lf }
                mutableDefinitionList.postValue(variations)
            } else {
                mutableDefinitionList.postValue(listOf())
            }
        }
    }
}