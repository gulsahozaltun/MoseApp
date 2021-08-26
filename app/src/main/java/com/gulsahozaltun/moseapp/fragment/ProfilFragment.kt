package com.gulsahozaltun.moseapp.fragment

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.gson.Gson
import com.gulsahozaltun.moseapp.R
import com.gulsahozaltun.moseapp.databinding.FragmentProfifBinding
import com.gulsahozaltun.moseapp.model.Users


class ProfilFragment : Fragment() {
    private lateinit var tasarim:FragmentProfifBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim=DataBindingUtil.inflate(inflater,R.layout.fragment_profif, container, false)
        tasarim.userObj=getUser()

        return tasarim.root
    }
    fun getUser() : Users {
        val mPrefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext())

        val gson = Gson()
        val jsonUser : String? = mPrefs.getString("users", "")
        return gson.fromJson(jsonUser, Users::class.java)
    }

}