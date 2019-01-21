package com.richards.jonathan.weatherapp.ui.screen

import android.content.pm.PackageManager
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.richards.jonathan.weatherapp.R
import com.richards.jonathan.weatherapp.ui.BaseFragment
import com.richards.jonathan.weatherapp.ui.type.Screen
import kotlinx.android.synthetic.main.loading_fragment.*

class LoadingFragment : BaseFragment() {

    companion object {
        private const val MY_PERMISSION_ACCESS_COURSE_LOCATION = 123
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.loading_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        checkPermissions()
    }

    private fun initiateView() {

    }

    override fun onResume() {
        super.onResume()
        weatherIcon.setBackgroundResource(R.drawable.weather_icon_anim)
        val weatherAnim = weatherIcon.background as AnimationDrawable
        weatherAnim.start()
    }

    private fun checkPermissions() {
        if (ContextCompat.checkSelfPermission(
                activity,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {

            ActivityCompat.requestPermissions(
                activity, arrayOf(android.Manifest.permission.ACCESS_COARSE_LOCATION),
                MY_PERMISSION_ACCESS_COURSE_LOCATION
            )
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            MY_PERMISSION_ACCESS_COURSE_LOCATION -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //progress
                    initiateView()
                } else {
                    activity.goTo(Screen.ERROR_LOADING_SCREEN)
                }
            }
        }
    }


}