package com.learn.spacexrocketlaunch.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.learn.spacexrocketlaunch.data.model.RocketLaunchDataModel
import com.learn.spacexrocketlaunch.data.repository.RocketLaunchDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class RocketLaunchDataViewModel @Inject constructor(private val repository: RocketLaunchDataRepository) :
    ViewModel() {

    val rocketLaunchDataList = MutableLiveData<List<RocketLaunchDataModel>>()
    val error = MutableLiveData<String>()

    private lateinit var disposable: Disposable

    fun init() {
        disposable = repository.getRocketLaunchData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::onGetLaunchDataSuccess, this::onGetLaunchDataError)
    }

    private fun onGetLaunchDataSuccess(response: List<RocketLaunchDataModel>) =
        if (response.isNotEmpty()) {
            rocketLaunchDataList.value = response
            repository.saveLaunchDataToLocalDb(response)
        } else {
            error.value = NO_DATA_AVAILABLE
        }

    private fun onGetLaunchDataError(t: Throwable) {
        error.value = t.message
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }

    companion object {
        const val NO_DATA_AVAILABLE = "No data available"
    }
}