package com.gulsahozaltun.moseapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.gulsahozaltun.moseapp.R
import com.gulsahozaltun.moseapp.databinding.FragmentAddMoseBinding
import com.gulsahozaltun.moseapp.viewmodel.MosesViewModel


class AddMoseFragment : Fragment() {
    private lateinit var tasarim: FragmentAddMoseBinding
    private lateinit var viewModel:MosesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim=DataBindingUtil.inflate(inflater,R.layout.fragment_add_mose, container, false)
        tasarim.satObj=this


        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temp:MosesViewModel by viewModels()
        viewModel=temp
    }

    fun fildiziEkle(mosetur:String,adi:String,turu:String,sure:String,imdb_puan:String,gorsel_url:String,yonetmen:String, ulke:String,hakkinda:String, fragman_url:String,yeni_mi:String){
        viewModel.filmdiziEkle(mosetur, adi, turu, sure, imdb_puan, gorsel_url, yonetmen, ulke, hakkinda, fragman_url, yeni_mi)
    }

}