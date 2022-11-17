package com.app.android.techassessment.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Articles(
    @SerializedName("copyright") val copyright: String,
    @SerializedName("num_results") val num_results: Int,
    @SerializedName("results") val results: List<Result>,
    @SerializedName("status") val status: String
) : Serializable