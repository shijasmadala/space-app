package com.shijas.spaceapp.presentation.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.shijas.spaceapp.databinding.ItemNasaDataBinding
import com.shijas.spaceapp.domain.model.NasaData


class NasaItemAdapter(private val listener: ClickListener): ListAdapter<NasaData,RecyclerView.ViewHolder>(DiffCallback) {
    interface ClickListener {
        fun onClick(position: Int)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemNasaDataBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NasaDataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as NasaDataViewHolder).bind(getItem(position),position)
    }

    inner class NasaDataViewHolder(private val binding: ItemNasaDataBinding):
    RecyclerView.ViewHolder(binding.root){
        fun bind(nasaData: NasaData,position: Int){
            with(binding){
                thumbnail.load(nasaData.url)
                title.text = nasaData.title
                date.text = nasaData.date

                root.setOnClickListener{listener.onClick(position)}
            }
        }
    }
}

object DiffCallback : DiffUtil.ItemCallback<NasaData>() {
    override fun areItemsTheSame(oldItem: NasaData, newItem: NasaData): Boolean {
        return oldItem.url == newItem.url
    }

    override fun areContentsTheSame(oldItem: NasaData, newItem: NasaData): Boolean {
        return oldItem == newItem
    }
}