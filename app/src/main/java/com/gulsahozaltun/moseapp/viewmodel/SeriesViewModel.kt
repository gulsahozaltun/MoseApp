package com.gulsahozaltun.moseapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gulsahozaltun.moseapp.model.Moses
import com.gulsahozaltun.moseapp.repos.MosesRepository

class SeriesViewModel: ViewModel() {
    val series: MutableLiveData<List<Moses>>
    private val repo= MosesRepository()

    init {
        series=repo.bringSeries()
        loadSeries()
    }

    fun loadSeries(){
        repo.getSeries()
    }


    fun favEkle(id:Int,fav:String){
        repo.favEkle(id, fav)
    }


}