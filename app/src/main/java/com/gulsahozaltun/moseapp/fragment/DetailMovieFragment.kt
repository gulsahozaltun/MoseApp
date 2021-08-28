package com.gulsahozaltun.moseapp.fragment

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.annotation.NonNull
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.gulsahozaltun.moseapp.R
import com.gulsahozaltun.moseapp.databinding.FragmentDetailMovieBinding
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail_movie.*


class DetailMovieFragment : Fragment() {
    private lateinit var tasarim:FragmentDetailMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim=DataBindingUtil.inflate(inflater, R.layout.fragment_detail_movie, container, false)


        val bundle:DetailMovieFragmentArgs by navArgs()
        val gelenSonuc=bundle.movieObj
        tasarim.movieObj=gelenSonuc
        val url=gelenSonuc.gorsel_url
        Picasso.get().load(url).into(tasarim.imageView2)

        var imdb=gelenSonuc.imdb_puan.toFloat()
        tasarim.imbd=imdb

        tasarim.button3.setOnClickListener{
            val ad= AlertDialog.Builder(requireContext())
            ad.setMessage(" You are leaving the page !")
            ad.setPositiveButton("Yes"){dialogInterface, i ->
                val urlIntent = Intent(Intent.ACTION_VIEW)
                urlIntent.data = Uri.parse(gelenSonuc.fragman_url)
                requireContext().startActivity(urlIntent)
            }
            ad.setNegativeButton("No"){dialogInterface, i ->

            }
            ad.create().show()

        }



        return tasarim.root
    }


}