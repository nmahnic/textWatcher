package com.example.textwatchertest

import android.text.Editable
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.spy
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.mockito.Mock
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.mockito.Mockito

@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest {

    @Mock
    private lateinit var editable: Editable

    private lateinit var viewModel: MainViewModel

    @BeforeEach
    fun setup(){
        viewModel = spy( MainViewModel() )
        editable = Mockito.mock(Editable::class.java)
    }

    @ParameterizedTest
    @MethodSource("cities")
    fun `call cityTextWatcher should filter city`(
        cityToEvaluate: String,
        validCity: String
    ) = runTest {

        whenever(editable.toString()).doReturn(cityToEvaluate)

        viewModel.cityTextWatcher.afterTextChanged(editable)

        assertEquals( editable.toString(), validCity)
    }

    companion object {
        @JvmStatic
        fun cities() = listOf(
            Arguments.of("@", ""),
            Arguments.of("hola@hola", "holahola"),
            Arguments.of("hola@", "hola"),
        )
    }

}