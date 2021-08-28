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
import com.gulsahozaltun.moseapp.databinding.FragmentNewsBinding
import com.gulsahozaltun.moseapp.viewmodel.MosesViewModel
import com.gulsahozaltun.moseapp.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.fragment_news.*


class NewsFragment : Fragment() {
    private lateinit var tasarim: FragmentNewsBinding
    private lateinit var viewModelNews: NewsViewModel
    private lateinit var newsAdapter: PagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim=DataBindingUtil.inflate(inflater,R.layout.fragment_news, container, false)

        viewModelNews.news.observe(viewLifecycleOwner,{

                newsl ->
            newsAdapter= PagerAdapter(requireContext(),newsl,viewModelNews)
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

        //tasarim.circleIndicator3.setViewPager(tasarim.viewPagerr)

        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temp: NewsViewModel by viewModels()
        viewModelNews=temp
    }


}