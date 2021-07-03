package com.learn.spacexrocketlaunch.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.learn.spacexrocketlaunch.R
import com.learn.spacexrocketlaunch.data.model.RocketLaunchDataModel
import com.learn.spacexrocketlaunch.databinding.ListItemLaunchDateBinding

class RocketLaunchDataAdapter : RecyclerView.Adapter<DataViewHolder>() {

    private lateinit var launchDataList: List<RocketLaunchDataModel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val binding: ListItemLaunchDateBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_item_launch_date, parent,
            false
        )
        return DataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(launchDataList[position])
    }

    override fun getItemCount(): Int {
        return if (::launchDataList.isInitialized) launchDataList.size else 0
    }

    fun setLaunchDataListItems(launchDataList: List<RocketLaunchDataModel>) {
        this.launchDataList = launchDataList
        notifyDataSetChanged()
    }
}