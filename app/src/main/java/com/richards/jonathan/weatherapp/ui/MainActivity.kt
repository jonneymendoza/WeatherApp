package com.richards.jonathan.weatherapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.richards.jonathan.weatherapp.R
import com.richards.jonathan.weatherapp.ui.screen.CurrentWeatherFragment
import com.richards.jonathan.weatherapp.ui.screen.ErrorScreenPermission
import com.richards.jonathan.weatherapp.ui.screen.LoadingFragment
import com.richards.jonathan.weatherapp.ui.type.Screen
import com.richards.jonathan.weatherapp.ui.viewmodel.WeatherViewModel
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val viewModel: WeatherViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        goTo(Screen.LOADING_SPLASH_SCREEN)
    }

    fun goTo(page: Screen, bundle: Bundle? = null) {
        when (page) {
            Screen.ERROR_LOADING_SCREEN -> {
                navigateToFragment(ErrorScreenPermission())
            }
            Screen.CURRENT_WEATHER_SCREEN -> {
                navigateToFragment(CurrentWeatherFragment())
            }

            Screen.LOADING_SPLASH_SCREEN -> {
                navigateToFragment(LoadingFragment())
            }
        }
    }

    private fun navigateToFragment(fragment: BaseFragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_content, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onBackPressed() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_content)

        if (currentFragment is LoadingFragment) {
            finish()
        } else {
            supportFragmentManager.popBackStack()
        }

    }
}
