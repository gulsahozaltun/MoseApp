package com.gulsahozaltun.moseapp.fragment

import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.google.gson.Gson
import com.gulsahozaltun.moseapp.R
import com.gulsahozaltun.moseapp.databinding.FragmentSignInBinding
import com.gulsahozaltun.moseapp.model.Users
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
        tasarim.signinObj=this
        viewModel.usersList.observe(viewLifecycleOwner, {
                usersList ->
             if(usersList !=null){
                 saveUser(usersList)
                 Navigation.findNavController(tasarim.loginSign).navigate(R.id. mainPageFragment)
             }
             else{
                 Toast.makeText(requireContext(),"try again", Toast.LENGTH_SHORT).show()            }
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
    fun girisYap(mail_adres:String,sifre:String){
        viewModel.signUser(mail_adres,sifre)

    }

    fun saveUser(users : Users){
        val mPrefs = PreferenceManager.getDefaultSharedPreferences(requireContext())
        val prefsEditor = mPrefs.edit()
        val gson = Gson()
        val jsonUser = gson.toJson(users)
        prefsEditor.putString("users",jsonUser).apply()
    }

}