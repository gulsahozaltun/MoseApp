package com.gulsahozaltun.moseapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.gulsahozaltun.moseapp.R
import com.gulsahozaltun.moseapp.adapter.ButtonSetOnClickListener
import com.gulsahozaltun.moseapp.adapter.FavoritesAdapter
import com.gulsahozaltun.moseapp.adapter.MoviesAdapter
import com.gulsahozaltun.moseapp.databinding.FragmentFavoritesBinding
import com.gulsahozaltun.moseapp.databinding.FragmentMainPageBinding
import com.gulsahozaltun.moseapp.viewmodel.FavoritesViewModel
import com.gulsahozaltun.moseapp.viewmodel.MosesViewModel
import com.gulsahozaltun.moseapp.viewmodel.NewsViewModel

class FavoritesFragment : Fragment() {
    private lateinit var tasarim: FragmentFavoritesBinding
    private lateinit var viewModel: FavoritesViewModel
    private lateinit var adapter: FavoritesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim=DataBindingUtil.inflate(inflater,R.layout.fragment_favorites, container, false)
        return tasarim.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val temp: FavoritesViewModel by viewModels()
        viewModel=temp
        viewModel.favList.observe(viewLifecycleOwner,{
                list ->
            val clickListener = object : ButtonSetOnClickListener {
                override fun favEkle(id: Int, fav: String) {
                    TODO("Not yet implemented")
                }

                override fun favCikart(id: Int, fav: String) {
                    viewModel.favCikart(id,"0")
                }
            }
            adapter= FavoritesAdapter(requireContext(),list,clickListener )
            tasarim.adapter=adapter

        })

    }

}