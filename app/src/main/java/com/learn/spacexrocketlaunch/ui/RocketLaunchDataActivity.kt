package com.learn.spacexrocketlaunch.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.learn.spacexrocketlaunch.R
import com.learn.spacexrocketlaunch.preferences.PreferenceHelper
import com.learn.spacexrocketlaunch.ui.adapter.RocketLaunchDataAdapter
import com.learn.spacexrocketlaunch.utils.DUMMY_TEXT
import com.learn.spacexrocketlaunch.utils.OnProceedClickListener
import com.learn.spacexrocketlaunch.utils.WELCOME
import com.learn.spacexrocketlaunch.utils.showAlert
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_rocket_launch_data.*
import javax.inject.Inject

@AndroidEntryPoint
class RocketLaunchDataActivity : AppCompatActivity() {

    private val rocketLaunchDataViewModel: RocketLaunchDataViewModel by viewModels()

    @Inject
    lateinit var preferenceHelper: PreferenceHelper

    private val launchDataAdapter: RocketLaunchDataAdapter by lazy {
        RocketLaunchDataAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rocket_launch_data)

        when {
            !preferenceHelper.getPref() -> {
                showAlert(
                    this,
                    DUMMY_TEXT, WELCOME, object : OnProceedClickListener {
                        override fun proceed() {
                            preferenceHelper.savePref(true)
                            rocketLaunchDataViewModel.init()
                        }
                    }
                )
            }
            else -> {
                rocketLaunchDataViewModel.init()
            }
        }

        setLaunchData()
        refreshList()
    }

    private fun setLaunchData() {
        if (refreshLayout.isRefreshing) {
            refreshLayout.isRefreshing = false
        }
        rvLaunchData.adapter = launchDataAdapter
        rvLaunchData.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        observeLiveData()
    }

    private fun observeLiveData() {
        rocketLaunchDataViewModel.rocketLaunchDataList.observe(this, {
            launchDataAdapter.setLaunchDataListItems(it)
            setVisibilityOfProgress()
        })

        rocketLaunchDataViewModel.error.observe(this, {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            setVisibilityOfProgress()
        })
    }

    private fun setVisibilityOfProgress() {
        progressCircular.visibility = View.GONE
        refreshLayout.isRefreshing = false
    }

    private fun refreshList() {
        refreshLayout.setOnRefreshListener {
            rocketLaunchDataViewModel.init()
        }
    }

}