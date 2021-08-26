package com.gulsahozaltun.moseapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gulsahozaltun.moseapp.databinding.MovieCardBinding
import com.gulsahozaltun.moseapp.model.Moses
import com.gulsahozaltun.moseapp.viewmodel.MosesViewModel
import com.squareup.picasso.Picasso

class MoviesAdapter(var mContext: Context,
                    var movieList: List<Moses>,
                    var viewModel: MosesViewModel,

                    )
    : RecyclerView.Adapter<MoviesAdapter.CardDesignHolder>() {

        inner class CardDesignHolder(cardMoviesBinding:MovieCardBinding):
        RecyclerView.ViewHolder(cardMoviesBinding.root){
            var cardDesignBinding:MovieCardBinding
            init {
                this.cardDesignBinding=cardMoviesBinding
            }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater= LayoutInflater.from(mContext)
        val tasarim=MovieCardBinding.inflate(layoutInflater,parent,false)
        return CardDesignHolder(tasarim)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val movie=movieList.get(position)
        val view=holder.cardDesignBinding
        view.movieObj=movie
        val url=movie.gorsel_url
        Picasso.get().load(url).into(view.imageView)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }


}