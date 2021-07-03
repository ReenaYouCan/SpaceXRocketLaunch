package com.learn.spacexrocketlaunch.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.learn.spacexrocketlaunch.data.model.RocketLaunchDataModel
import com.learn.spacexrocketlaunch.data.repository.RocketLaunchDataRepository
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import junit.framework.Assert.assertNotNull
import junit.framework.Assert.assertNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.concurrent.Callable


class RocketLaunchDataViewModelTest {

    private val repository: RocketLaunchDataRepository = mock()

    private lateinit var viewModel: RocketLaunchDataViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { scheduler: Callable<Scheduler?>? -> Schedulers.trampoline() }

        viewModel = RocketLaunchDataViewModel(repository)
    }

    @Test
    fun `should get data from repository after calling  init and display data`() {
        //Given
        viewModel.rocketLaunchDataList.observeForever { }
        viewModel.error.observeForever { }
        val mockResponse = RocketLaunchDataModel(
            name = "name",
            country = "country",
            enginesCount = 1,
            flickerImage = "someurl"
        )
        whenever(repository.getRocketLaunchData()).thenReturn(Observable.just(listOf(mockResponse)))

        //When
        viewModel.init()

        //Then
        verify(repository, times(1)).getRocketLaunchData()
        assertNotNull(viewModel.rocketLaunchDataList)
    }

    @Test
    fun `should return error after calling  getRocketLaunchData`() {
        //Given
        viewModel.rocketLaunchDataList.observeForever { }
        viewModel.error.observeForever { }

        whenever(repository.getRocketLaunchData()).thenReturn(Observable.error(Throwable()))

        //When
        viewModel.init()

        //Then
        verify(repository, times(1)).getRocketLaunchData()
        assertNull(viewModel.rocketLaunchDataList.value)
        assertNotNull(viewModel.error)
    }
}
