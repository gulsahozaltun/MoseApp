package com.gulsahozaltun.moseapp.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.gulsahozaltun.moseapp.databinding.FavoritesCardBinding
import com.gulsahozaltun.moseapp.fragment.FavoritesFragmentDirections
import com.gulsahozaltun.moseapp.fragment.MainPageFragmentDirections
import com.gulsahozaltun.moseapp.model.Moses
import com.gulsahozaltun.moseapp.viewmodel.FavoritesViewModel
import com.squareup.picasso.Picasso


class FavoritesAdapter(var mContext: Context,
                       var favList: List<Moses>,
                       var clickListener: ButtonSetOnClickListener
):RecyclerView.Adapter<FavoritesAdapter.CardDesignHolder>()

{
        inner class CardDesignHolder(cardFavoritesCardBinding: FavoritesCardBinding):RecyclerView.ViewHolder(cardFavoritesCardBinding.root){
            var cardFavoritesBinding:FavoritesCardBinding

            init {
                this.cardFavoritesBinding=cardFavoritesCardBinding
            }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater= LayoutInflater.from(mContext)
        val tasarim=FavoritesCardBinding.inflate(layoutInflater,parent,false)
        return CardDesignHolder(tasarim)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val movie=favList.get(position)
        val view=holder.cardFavoritesBinding
        view.movieObj=movie
        val url=movie.gorsel_url
        Picasso.get().load(url).into(view.imageView)

        view.cardView.setOnClickListener {
            val gecis= FavoritesFragmentDirections.favoritetoDetail(movie)
            Navigation.findNavController(it).navigate(gecis)
        }

        view.button.setOnClickListener {
            if (movie.fav == "1"){
                clickListener.favCikart(movie.id,"0")
                val message= "Removed from favorites!"
                Toast.makeText(mContext,message, Toast.LENGTH_SHORT).show()
                Log.e("fav durum new",movie.fav)

            }
        }

    }

    override fun getItemCount(): Int {
       return favList.size
    }

}