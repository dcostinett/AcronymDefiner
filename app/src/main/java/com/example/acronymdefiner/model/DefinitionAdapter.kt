package com.example.acronymdefiner.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.acronymdefiner.R
import com.example.acronymdefiner.databinding.DefinitionRowBinding

class DefinitionAdapter : RecyclerView.Adapter<DefinitionAdapter.ViewHolder>() {

    private val definitions = mutableListOf<String>()

    class ViewHolder(private val definitionBinding: DefinitionRowBinding) : RecyclerView.ViewHolder(definitionBinding.root) {

        fun bind(definition: String) {
            definitionBinding.setDefinition(definition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: DefinitionRowBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.definition_row, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(definitions[position])
    }

    override fun getItemCount(): Int {
        return definitions.size
    }

    fun update(newDefinitions: List<String>) {
        definitions.clear()
        definitions.addAll(newDefinitions)
        notifyDataSetChanged()
    }
}