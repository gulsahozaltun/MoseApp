package com.gulsahozaltun.moseapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gulsahozaltun.moseapp.databinding.NewsCardBinding
import com.gulsahozaltun.moseapp.model.Moses
import com.gulsahozaltun.moseapp.viewmodel.NewsViewModel
import com.squareup.picasso.Picasso


class PagerAdapter(
    var mContext: Context,
    var newsList: List<Moses>,
    var viewModel: NewsViewModel,

    ): RecyclerView.Adapter<PagerAdapter.Pager2ViewHolder>() {
    inner class Pager2ViewHolder(pagerBinding:NewsCardBinding): RecyclerView.ViewHolder(pagerBinding.root){
        var cardDesign:NewsCardBinding
        init {
            this.cardDesign=pagerBinding
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Pager2ViewHolder{
        var layoutInflater = LayoutInflater.from(parent.context)
        val design = NewsCardBinding.inflate(layoutInflater,parent,false)
        return Pager2ViewHolder(design)
    }

    override fun onBindViewHolder(holder: PagerAdapter.Pager2ViewHolder, position: Int) {
        val newsMovie = newsList.get(position)
        val view = holder.cardDesign
        view.newsObj = newsMovie
        val url = newsMovie.gorsel_url
        Picasso.get().load(url).into(view.categoryImage)

    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}