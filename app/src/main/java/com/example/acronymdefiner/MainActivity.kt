package com.example.acronymdefiner

import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.acronymdefiner.databinding.ActivityMainBinding
import com.example.acronymdefiner.model.DefinitionAdapter

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: DefinitionAdapter
    private lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        bind()

        initObserver()
    }

    private fun initObserver() {
        viewModel.definitionList.observe(this) {
            adapter.update(it)
        }
    }

    private fun bind() {
        recycler = binding.recycler
        recycler.layoutManager = LinearLayoutManager(this)
        adapter = DefinitionAdapter()
        recycler.adapter = adapter

        val key = binding.acronymEntry.text

        binding.submitButton.setOnClickListener {
            viewModel.fetchDefinitions(key.toString())
        }
    }
}