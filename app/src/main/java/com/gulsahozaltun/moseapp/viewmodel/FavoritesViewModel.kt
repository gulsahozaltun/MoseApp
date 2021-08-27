package com.gulsahozaltun.moseapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gulsahozaltun.moseapp.model.Moses
import com.gulsahozaltun.moseapp.repos.MosesRepository

class FavoritesViewModel:ViewModel() {
    val favList: MutableLiveData<List<Moses>>
    private val repo= MosesRepository()

    init {
       favList=repo.bringFacs()
        loadFavs()
    }

    fun loadFavs(){
        repo.getFavMovies()
    }

    fun favCikart(id:Int,fav: String){
        repo.favCikart(id, fav)
    }

}