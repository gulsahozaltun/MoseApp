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
import com.gulsahozaltun.moseapp.adapter.MoviesAdapter
import com.gulsahozaltun.moseapp.adapter.NewsAdapter
import com.gulsahozaltun.moseapp.adapter.PagerAdapter
import com.gulsahozaltun.moseapp.databinding.FragmentMainPageBinding
import com.gulsahozaltun.moseapp.viewmodel.MosesViewModel
import com.gulsahozaltun.moseapp.viewmodel.NewsViewModel


class MainPageFragment : Fragment() {
    private lateinit var tasarim:FragmentMainPageBinding
    private lateinit var viewModel:MosesViewModel
    private lateinit var viewModelNews:NewsViewModel
    private lateinit var adapter:MoviesAdapter
    private lateinit var newsAdapter: NewsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim=DataBindingUtil.inflate(inflater,R.layout.fragment_main_page, container, false)

        viewModel.mosesList.observe(viewLifecycleOwner,{
            list ->
            adapter= MoviesAdapter(requireContext(),list,viewModel)
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




        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temp: MosesViewModel by viewModels()
        viewModel=temp
        val temp2: NewsViewModel by viewModels()
        viewModelNews=temp2
    }




}