package com.app.android.techassessment.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.android.techassessment.api.ArticleApi
import com.app.android.techassessment.model.Articles
import com.app.android.techassessment.utils.NetworkResult
import com.app.android.techassessment.utils.Utilities.isNotNull
import org.json.JSONObject
import retrofit2.Response
import javax.inject.Inject

class ArticleRepository @Inject constructor(private val articleApi: ArticleApi) {

    private val _responseLiveData = MutableLiveData<NetworkResult<Articles>>()
    val responseLiveData: LiveData<NetworkResult<Articles>>
        get() = _responseLiveData

    suspend fun getArticles() {
        _responseLiveData.postValue(NetworkResult.Loading())
        handleResponse(articleApi.getArticles())
    }

    private fun handleResponse(response: Response<Articles>) {
        if (response.isSuccessful && isNotNull(response.body())) {
            _responseLiveData.postValue(NetworkResult.Success(response.body()!!))
        } else if (isNotNull(response.errorBody())) {
            val errorData = JSONObject(response.errorBody()!!.charStream().toString())
            _responseLiveData.postValue(NetworkResult.Error(errorData.getString("message")))
        } else {
            _responseLiveData.postValue(NetworkResult.Error("Something went wrong"))
        }

    }
}