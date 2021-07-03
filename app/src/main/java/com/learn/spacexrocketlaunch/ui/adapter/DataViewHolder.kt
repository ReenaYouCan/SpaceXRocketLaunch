package com.learn.spacexrocketlaunch.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.learn.spacexrocketlaunch.R
import com.learn.spacexrocketlaunch.data.model.RocketLaunchDataModel
import com.learn.spacexrocketlaunch.databinding.ListItemLaunchDateBinding
import kotlinx.android.synthetic.main.list_item_launch_date.view.*

class DataViewHolder(private val binding: ListItemLaunchDateBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: RocketLaunchDataModel) {
        binding.item = item
        setFlickrImage(item.flickerImage)
    }

    private fun setFlickrImage(url: String) {
        Glide.with(itemView)
            .load(url)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_foreground)
            .into(itemView.ivFlickerImg)
    }

}