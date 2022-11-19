package com.app.android.techassessment.utils

import org.junit.Assert.*

import org.junit.Test

class UtilitiesTest {

    @Test
    fun isNotNull_expectedCorrect() {
       val result = Utilities.isNotNull(null)
        assertEquals(false, result)
    }

    @Test
    fun isNotNull_expectedWrong() {
        val result = Utilities.isNotNull(null)
        assertEquals(true, result)
    }
}