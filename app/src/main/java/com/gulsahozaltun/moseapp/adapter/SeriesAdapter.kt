package com.gulsahozaltun.moseapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.gulsahozaltun.moseapp.databinding.NewsCardBinding
import com.gulsahozaltun.moseapp.databinding.SeriesCardBinding
import com.gulsahozaltun.moseapp.fragment.NewsFragmentDirections
import com.gulsahozaltun.moseapp.fragment.SeriesFragmentDirections
import com.gulsahozaltun.moseapp.model.Moses
import com.gulsahozaltun.moseapp.viewmodel.SeriesViewModel
import com.squareup.picasso.Picasso

class SeriesAdapter(var mContext: Context,
                    var seriesList: List<Moses>,
                    var clickListener: ButtonSetOnClickListener): RecyclerView.Adapter<SeriesAdapter.CardDesignHolder>() {


    inner class CardDesignHolder(cardSeriesBinding: SeriesCardBinding):
        RecyclerView.ViewHolder(cardSeriesBinding.root){
        var cardDesignBinding: SeriesCardBinding
        init {
            this.cardDesignBinding=cardSeriesBinding
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater= LayoutInflater.from(mContext)
        val tasarim=SeriesCardBinding.inflate(layoutInflater,parent,false)
        return CardDesignHolder(tasarim)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val series=seriesList.get(position)
        val view=holder.cardDesignBinding
        view.seriesObj=series
        val url=series.gorsel_url
        Picasso.get().load(url).into(view.imageView)

        view.cardView.setOnClickListener {
            val gecis=SeriesFragmentDirections.seriestoDetail(series)
            Navigation.findNavController(it).navigate(gecis)
        }

        view.button.setOnClickListener {
            if(series.fav != "1"){
                clickListener.favEkle(series.id,"1")
                val message= " Added to fav!"
                Toast.makeText(mContext,message, Toast.LENGTH_SHORT).show()


            }
        }
    }

    override fun getItemCount(): Int {
        return seriesList.size
    }


}