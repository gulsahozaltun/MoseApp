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

        viewModel.series.observe(viewLifecycleOwner,{
                list ->
            adapterSeries= SeriesAdapter(requireContext(),list,viewModel)
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


        return tasarim.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temp: SeriesViewModel by viewModels()
        viewModel=temp

    }

}