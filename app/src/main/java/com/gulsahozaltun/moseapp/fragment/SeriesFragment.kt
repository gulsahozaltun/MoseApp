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
import com.gulsahozaltun.moseapp.adapter.SeriesAdapter
import com.gulsahozaltun.moseapp.databinding.FragmentSeriesBinding
import com.gulsahozaltun.moseapp.viewmodel.MosesViewModel
import com.gulsahozaltun.moseapp.viewmodel.NewsViewModel
import com.gulsahozaltun.moseapp.viewmodel.SeriesViewModel


class SeriesFragment : Fragment() {
    private lateinit var tasarim:FragmentSeriesBinding
    private lateinit var viewModel: SeriesViewModel
    private lateinit var adapterSeries: SeriesAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim=DataBindingUtil.inflate(inflater,R.layout.fragment_series, container, false)
        return tasarim.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.series.observe(viewLifecycleOwner,{
                list ->
            val clickListener = object : ButtonSetOnClickListener {
                override fun favEkle(id: Int, fav: String) {
                    viewModel.favEkle(id,"1")
                }

                override fun favCikart(id: Int, fav: String) {
                    TODO("Not yet implemented")
                }
            }
            adapterSeries= SeriesAdapter(requireContext(),list,clickListener)
            tasarim.seriesAdapter=adapterSeries

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
        val temp: SeriesViewModel by viewModels()
        viewModel=temp

    }

}