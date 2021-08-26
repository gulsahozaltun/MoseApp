package com.gulsahozaltun.moseapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gulsahozaltun.moseapp.model.Moses
import com.gulsahozaltun.moseapp.repos.MosesRepository

class NewsViewModel():ViewModel() {
    val news: MutableLiveData<List<Moses>>
    private val repo= MosesRepository()

    init {
        news=repo.bringSales()
        loadNews()
    }

    fun loadNews(){
        repo.getNewMovies()
    }

}