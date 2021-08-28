package com.gulsahozaltun.moseapp.repos

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.gulsahozaltun.moseapp.model.CRUDAnswer
import com.gulsahozaltun.moseapp.model.Moses
import com.gulsahozaltun.moseapp.model.MosesAnswer
import com.gulsahozaltun.moseapp.retrofit.ApiUtils
import com.gulsahozaltun.moseapp.retrofit.MosesDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MosesRepository {
    private val mosedao:MosesDaoInterface
    private val moseList:MutableLiveData<List<Moses>>
    private val favList:MutableLiveData<List<Moses>>
    private val newItemsList : MutableLiveData<List<Moses>>
    private val serieslist : MutableLiveData<List<Moses>>

    init {
        mosedao=ApiUtils.getMosesDaoInterface()
        moseList= MutableLiveData()
        newItemsList = MutableLiveData()
        favList= MutableLiveData()
        serieslist=MutableLiveData()
        //newsList= MutableLiveData()

    }

    fun bringMoses(): MutableLiveData<List<Moses>> {
        return moseList
    }

    fun bringNews():MutableLiveData<List<Moses>>{
        return newItemsList
    }

    fun bringFacs():MutableLiveData<List<Moses>>{
        return favList
    }

    fun bringSeries():MutableLiveData<List<Moses>>{
        return serieslist
    }

    fun getAllMoses(){
        mosedao.allMoses().enqueue(object :retrofit2.Callback<MosesAnswer>{
            override fun onResponse(call: Call<MosesAnswer>?, response: Response<MosesAnswer>?) {
                val movies= response!!.body().moses
                val liste= mutableListOf<Moses>()

                for (i in movies){
                    if (i.mosetur == "film"){
                        liste.add(i)
                    }
                }
                moseList.value=liste
            }

            override fun onFailure(call: Call<MosesAnswer>?, t: Throwable?) {
                      Log.e("Error", t.toString())
            }

        })
    }

    fun addMoses(mosetur:String,adi:String,turu:String,sure:String,imdb_puan:String,gorsel_url:String,yonetmen:String, ulke:String,hakkinda:String, fragman_url:String,yeni_mi:String){
        mosedao.moseEkle(mosetur, adi, turu, sure, imdb_puan, gorsel_url, yonetmen, ulke, hakkinda, fragman_url, yeni_mi).enqueue(object :retrofit2.Callback<CRUDAnswer>{
            override fun onResponse(call: Call<CRUDAnswer>?, response: Response<CRUDAnswer>?) {
                Log.e("success", response!!.body().toString())
                Log.e("basarili","mission complete")
            }

            override fun onFailure(call: Call<CRUDAnswer>?, t: Throwable?) {
                Log.e("faiill",t.toString()!!)
            }

        })

    }

    fun getNewMovies(){
        mosedao.allMoses().enqueue(object :Callback<MosesAnswer>{
            override fun onResponse(call: Call<MosesAnswer>?, response: Response<MosesAnswer>?) {
                val newslist= response!!.body().moses
                val liste= mutableListOf<Moses>()
                for(item in newslist){
                    if(item.yeni_mi=="1"){
                        liste.add(item)
                    }
                }
                newItemsList.value=liste


            }

            override fun onFailure(call: Call<MosesAnswer>?, t: Throwable?) {
                TODO("Not yet implemented")
            }

        })

    }

    fun getFavMovies(){
        mosedao.allMoses().enqueue(object :Callback<MosesAnswer>{
            override fun onResponse(call: Call<MosesAnswer>?, response: Response<MosesAnswer>?) {
                val favListesi= response!!.body().moses
                val liste= mutableListOf<Moses>()
                for (i in favListesi){
                    if (i.fav == "1"){
                        liste.add(i)
                    }
                }
                favList.value=liste
            }

            override fun onFailure(call: Call<MosesAnswer>?, t: Throwable?) {
                TODO("Not yet implemented")
            }

        })
    }


    fun favEkle(id:Int,fav:String){
        mosedao.favDurum(id,fav).enqueue(object: Callback<MosesAnswer>{
            override fun onResponse(call: Call<MosesAnswer>?, response: Response<MosesAnswer>?) {
                Log.e("fav durum:",fav.toString())
            }

            override fun onFailure(call: Call<MosesAnswer>?, t: Throwable?) {
                Log.e("hata sesebi:", t.toString())
            }

        })

    }

    fun favCikart(id:Int,fav:String){
        mosedao.favDurum(id, fav).enqueue(object :Callback<MosesAnswer>{
            override fun onResponse(call: Call<MosesAnswer>?, response: Response<MosesAnswer>?) {
                Log.e("fav durum:",fav.toString())
            }

            override fun onFailure(call: Call<MosesAnswer>?, t: Throwable?) {
                Log.e("hata sesebi favdan cikarma:", t.toString())
            }

        })
    }

    fun getSeries(){
        mosedao.allMoses().enqueue(object :Callback<MosesAnswer>{
            override fun onResponse(call: Call<MosesAnswer>?, response: Response<MosesAnswer>?) {
                val seriesList= response!!.body().moses
                val liste= mutableListOf<Moses>()
                for(item in seriesList){
                    if(item.mosetur=="dizi"){
                        liste.add(item)
                    }
                }
                serieslist.value=liste


            }

            override fun onFailure(call: Call<MosesAnswer>?, t: Throwable?) {
                TODO("Not yet implemented")
            }

        })

    }



}