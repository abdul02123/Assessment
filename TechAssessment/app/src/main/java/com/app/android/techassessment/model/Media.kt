package com.app.android.techassessment.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Media(
    @SerializedName("approved_for_syndication") val approved_for_syndication: Int,
    @SerializedName("caption") val caption: String,
    @SerializedName("copyright") val copyright: String,
    @SerializedName("subtype") val subtype: String,
    @SerializedName("type") val type: String
) : Serializable