package com.gulsahozaltun.moseapp.adapter

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.gulsahozaltun.moseapp.R
import com.gulsahozaltun.moseapp.databinding.MovieCardBinding
import com.gulsahozaltun.moseapp.fragment.MainPageFragmentDirections
import com.gulsahozaltun.moseapp.model.Moses
import com.gulsahozaltun.moseapp.viewmodel.MosesViewModel
import com.squareup.picasso.Picasso

class MoviesAdapter(var mContext: Context,
                    var movieList: List<Moses>,
                    var clickListener: ButtonSetOnClickListener)
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
        val movie = movieList.get(position)
        val view = holder.cardDesignBinding
        view.movieObj = movie
        val url = movie.gorsel_url
        Picasso.get().load(url).into(view.imageView)
        view.cardView.setOnClickListener {
            val gecis = MainPageFragmentDirections.maintoDetail(movie)
            Navigation.findNavController(it).navigate(gecis)
        }

        view.button.setOnClickListener {
            if (movie.fav != "1") {
                clickListener.favEkle(movie.id, "1")
                val message = "Added to fav!"
                Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show()
            }
        }
    }


    override fun getItemCount(): Int {
        return movieList.size
    }


}