package com.example.acronymdefiner

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @MockK
    lateinit var mockApplication: Application
    @MockK


    private lateinit var subject: MainViewModel

    @Before
    fun setup() {
        MockKAnnotations.init(this)

        subject = MainViewModel(mockApplication)
    }

    @Test
    fun emptyList() {

    }
}