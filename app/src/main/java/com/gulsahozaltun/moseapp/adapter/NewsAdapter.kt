package com.gulsahozaltun.moseapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gulsahozaltun.moseapp.databinding.MovieCardBinding
import com.gulsahozaltun.moseapp.databinding.NewsCardBinding
import com.gulsahozaltun.moseapp.model.Moses
import com.gulsahozaltun.moseapp.viewmodel.MosesViewModel
import com.gulsahozaltun.moseapp.viewmodel.NewsViewModel
import com.squareup.picasso.Picasso

class NewsAdapter (var mContext: Context,
                   var movieList: List<Moses>,
                   var viewModel: NewsViewModel,

                   )
    : RecyclerView.Adapter<NewsAdapter.CardDesignHolder>(){

    inner class CardDesignHolder(cardNewsBinding: NewsCardBinding):
        RecyclerView.ViewHolder(cardNewsBinding.root){
        var cardDesignBinding: NewsCardBinding
        init {
            this.cardDesignBinding=cardNewsBinding
        }

    }



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewsAdapter.CardDesignHolder {
        val layoutInflater= LayoutInflater.from(mContext)
        val tasarim=NewsCardBinding.inflate(layoutInflater,parent,false)
        return CardDesignHolder(tasarim)
    }

    override fun onBindViewHolder(holder: NewsAdapter.CardDesignHolder, position: Int) {
        val newsMovie=movieList.get(position)
        val view=holder.cardDesignBinding
        view.newsObj=newsMovie
        val url=newsMovie.gorsel_url
        Picasso.get().load(url).into(view.categoryImage)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }


}