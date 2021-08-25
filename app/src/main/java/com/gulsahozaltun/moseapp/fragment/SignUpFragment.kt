package com.gulsahozaltun.moseapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.gulsahozaltun.moseapp.R
import com.gulsahozaltun.moseapp.databinding.FragmentSignUpBinding
import com.gulsahozaltun.moseapp.viewmodel.SignUpFragmentViewModel


class SignUpFragment : Fragment() {
    private lateinit var tasarim:FragmentSignUpBinding
    private lateinit var viewModel:SignUpFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim=DataBindingUtil.inflate(inflater,R.layout.fragment_sign_up, container, false)
        tasarim.addUserObj=this
        return tasarim.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temp:SignUpFragmentViewModel by viewModels()
        viewModel=temp
    }

    fun buttonAddUser(mail_adres: String, sifre: String, ad_soyad: String, telefon: String){
        viewModel.addUser(mail_adres,sifre, ad_soyad, telefon)
        Navigation.findNavController(tasarim.registeSignUp).navigate(R.id.signInFragment)
        Toast.makeText(requireContext(),"Basarili", Toast.LENGTH_SHORT).show()
    }

}