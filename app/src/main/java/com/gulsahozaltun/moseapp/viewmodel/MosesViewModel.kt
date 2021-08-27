package com.gulsahozaltun.moseapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gulsahozaltun.moseapp.model.Moses
import com.gulsahozaltun.moseapp.repos.MosesRepository

class MosesViewModel:ViewModel() {
    val mosesList:MutableLiveData<List<Moses>>
    private val repo=MosesRepository()


    init {
        mosesList= repo.bringMoses()
        loadMoses()
    }

    fun loadMoses(){
        repo.getAllMoses()
    }

    fun filmdiziEkle(mosetur:String,adi:String,turu:String,sure:String,imdb_puan:String,gorsel_url:String,yonetmen:String, ulke:String,hakkinda:String, fragman_url:String,yeni_mi:String){
        repo.addMoses(mosetur, adi, turu, sure, imdb_puan, gorsel_url, yonetmen, ulke, hakkinda, fragman_url, yeni_mi)
        Log.e("eklenenler",mosetur+adi+turu+sure)
    }

    fun favEkle(id:Int,fav:String){
        repo.favEkle(id, fav)
    }

    fun favCikart(id:Int,fav: String){
        repo.favCikart(id, fav)
    }




}