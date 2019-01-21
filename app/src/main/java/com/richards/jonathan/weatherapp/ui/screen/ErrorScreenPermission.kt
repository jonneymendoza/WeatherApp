package com.richards.jonathan.weatherapp.ui.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.richards.jonathan.weatherapp.R
import com.richards.jonathan.weatherapp.ui.BaseFragment

class ErrorScreenPermission : BaseFragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.error_screen, container,false)
    }
}