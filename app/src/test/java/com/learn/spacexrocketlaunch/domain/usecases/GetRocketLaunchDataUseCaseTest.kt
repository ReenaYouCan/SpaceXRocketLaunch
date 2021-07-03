package com.learn.spacexrocketlaunch.domain.usecases

import com.learn.spacexrocketlaunch.data.network.RocketLaunchDataApi
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Observable
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class GetRocketLaunchDataUseCaseTest {

    private val api: RocketLaunchDataApi = mock()
    lateinit var useCase: GetRocketLaunchDataUseCase

    @Before
    fun setUp() {
        useCase = GetRocketLaunchDataUseCase(api)
    }

    @Test
    fun `should call getRocketLaunchDataFromApi and filter result `() {
        //Given
        whenever(api.getRockets()).thenReturn(Observable.just(listOf()))

        //When
        useCase.getRocketLaunchDataFromApi()

        //Then
        assertNotNull(useCase.getRocketLaunchDataFromApi())
        verify(api, times(2)).getRockets()
    }

}