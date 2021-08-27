package com.gulsahozaltun.moseapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.gulsahozaltun.moseapp.R
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

        viewModel.favList.observe(viewLifecycleOwner,{
                list ->
            adapter= FavoritesAdapter(requireContext(),list,viewModel)
            tasarim.adapter=adapter

        })


        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temp: FavoritesViewModel by viewModels()
        viewModel=temp
    }


}