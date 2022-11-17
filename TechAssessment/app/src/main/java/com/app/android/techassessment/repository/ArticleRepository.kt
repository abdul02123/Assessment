package com.app.android.techassessment.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.android.techassessment.api.ArticleApi
import com.app.android.techassessment.model.Articles
import com.app.android.techassessment.utils.NetworkResult
import javax.inject.Inject

class ArticleRepository @Inject constructor(private val articleApi: ArticleApi) {

    private val _responseLiveData = MutableLiveData<NetworkResult<Articles>>()
    val responseLiveData: LiveData<NetworkResult<Articles>>
    get() = _responseLiveData

    suspend fun getArticles(){
        _responseLiveData.postValue(NetworkResult.Loading())
        val response = articleApi.getArticles()
        if (response.isSuccessful){
            _responseLiveData.postValue(NetworkResult.Success(response.body()!!))
        }else{
            _responseLiveData.postValue(NetworkResult.Error(response.body()!!))
        }
    }
}