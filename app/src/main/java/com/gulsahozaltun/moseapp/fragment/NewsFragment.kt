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
import com.gulsahozaltun.moseapp.adapter.PagerAdapter
import com.gulsahozaltun.moseapp.databinding.FragmentNewsBinding
import com.gulsahozaltun.moseapp.viewmodel.NewsViewModel


class NewsFragment : Fragment() {
    private lateinit var tasarim: FragmentNewsBinding
    private lateinit var viewModelNews: NewsViewModel
    private lateinit var newsAdapter: PagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim=DataBindingUtil.inflate(inflater,R.layout.fragment_news, container, false)
        return tasarim.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelNews.news.observe(viewLifecycleOwner,{

                newsl ->
            newsAdapter= PagerAdapter(requireContext(),newsl)
            tasarim.newsAdapter=newsAdapter
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
        val temp: NewsViewModel by viewModels()
        viewModelNews=temp
    }


}