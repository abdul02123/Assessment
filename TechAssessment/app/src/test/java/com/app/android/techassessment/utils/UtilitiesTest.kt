package com.app.android.techassessment.utils

import org.junit.Assert.*

import org.junit.Test

class UtilitiesTest {

    @Test
    fun isNotNull() {
       val result = Utilities.isNotNull(null)
        assertEquals(false, result)
    }
}