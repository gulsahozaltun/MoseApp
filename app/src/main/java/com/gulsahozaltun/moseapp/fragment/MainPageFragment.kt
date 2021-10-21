package com.gulsahozaltun.moseapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.gulsahozaltun.moseapp.R
import com.gulsahozaltun.moseapp.adapter.ButtonSetOnClickListener
import com.gulsahozaltun.moseapp.adapter.MoviesAdapter
import com.gulsahozaltun.moseapp.databinding.FragmentMainPageBinding
import com.gulsahozaltun.moseapp.viewmodel.MosesViewModel
import com.gulsahozaltun.moseapp.viewmodel.NewsViewModel


class MainPageFragment : Fragment() {
    private lateinit var tasarim:FragmentMainPageBinding
    private lateinit var viewModel:MosesViewModel
    private lateinit var viewModelNews:NewsViewModel
    private lateinit var adapter:MoviesAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim=DataBindingUtil.inflate(inflater,R.layout.fragment_main_page, container, false)

        return tasarim.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.mosesList.observe(viewLifecycleOwner,{
                list ->
            val clickListener = object : ButtonSetOnClickListener {
                override fun favEkle(id: Int, fav: String) {
                    viewModel.favEkle(id,"1")
                }

                override fun favCikart(id: Int, fav: String) {
                    TODO("Not yet implemented")
                }
            }
            adapter= MoviesAdapter(requireContext(),list,clickListener)
            tasarim.adapter=adapter

        })

        tasarim.chipGroup.setOnCheckedChangeListener { group, checkedId ->
            if (tasarim.chip1.isChecked) {

                Navigation.findNavController(tasarim.chip1).navigate(R.id.mainPageFragment)
            }
            else if(tasarim.chip2.isChecked){
                Navigation.findNavController(tasarim.chip1).navigate(R.id.seriesFragment)

            }

            else if(tasarim.chip3.isChecked){
                Navigation.findNavController(tasarim.chip1).navigate(R.id.newsFragment)

            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temp: MosesViewModel by viewModels()
        viewModel=temp
        val temp2: NewsViewModel by viewModels()
        viewModelNews=temp2
    }




}