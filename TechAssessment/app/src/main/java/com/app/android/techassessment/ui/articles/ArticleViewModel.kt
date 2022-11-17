package com.app.android.techassessment.ui.articles

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.android.techassessment.model.Articles
import com.app.android.techassessment.repository.ArticleRepository
import com.app.android.techassessment.utils.NetworkResult
import kotlinx.coroutines.launch
import javax.inject.Inject


class ArticleViewModel @Inject constructor(private val articleRepository: ArticleRepository) :
    ViewModel() {

    val articleResponseData: LiveData<NetworkResult<Articles>>
        get() = articleRepository.responseLiveData

    var data = MutableLiveData<String>()

    fun getAllArticles() {
        viewModelScope.launch {
            articleRepository.getArticles()
        }
    }

}