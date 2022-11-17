package com.app.android.techassessment.api

import com.app.android.techassessment.model.Articles
import com.app.android.techassessment.utils.Constant.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleApi {
    @GET("mostpopular/v2/viewed/1.json?")
    suspend fun getArticles(@Query("api-key") key: String = API_KEY): Response<Articles>
}