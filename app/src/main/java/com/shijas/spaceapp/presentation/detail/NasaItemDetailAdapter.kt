package com.shijas.spaceapp.presentation.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.shijas.spaceapp.databinding.ItemNasaDetailBinding
import com.shijas.spaceapp.domain.model.NasaData


class NasaItemDetailAdapter(): ListAdapter<NasaData,RecyclerView.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ItemNasaDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NasaItemDetailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as NasaItemDetailViewHolder).bind(getItem(position))
    }

    inner class NasaItemDetailViewHolder(private val binding:ItemNasaDetailBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(nasaData: NasaData){
            with(binding){
                nasaDetailImage.load(nasaData.url)
                title.text = nasaData.title
                explanation.text =nasaData.explanation
                date.text = nasaData.date
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