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
import com.gulsahozaltun.moseapp.databinding.FragmentSignInBinding
import com.gulsahozaltun.moseapp.viewmodel.SignInFragmentViewModel
import com.gulsahozaltun.moseapp.viewmodel.SignUpFragmentViewModel

class SignInFragment : Fragment() {
    private lateinit var tasarim:FragmentSignInBinding
    private lateinit var viewModel:SignInFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim=DataBindingUtil.inflate(inflater,R.layout.fragment_sign_in, container, false)

        viewModel.user.observe(viewLifecycleOwner, {

        })


        tasarim.registerSign.setOnClickListener {
                Navigation.findNavController(tasarim.registerSign).navigate(R.id.signUpFragment)
        }
        return tasarim.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            val temp: SignInFragmentViewModel by viewModels()
        viewModel=temp
    }

}