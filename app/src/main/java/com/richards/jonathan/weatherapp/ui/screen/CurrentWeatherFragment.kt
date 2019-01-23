package com.richards.jonathan.weatherapp.ui.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.richards.jonathan.weatherapp.R
import com.richards.jonathan.weatherapp.data.network.entity.Status
import com.richards.jonathan.weatherapp.ui.BaseFragment
import kotlinx.android.synthetic.main.current_weather_fragment.*

class CurrentWeatherFragment : BaseFragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.current_weather_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity.viewModel.getCurrentWeatherLiveData().observe(this, Observer { resource ->
            if (resource.status == Status.SUCCESS && resource.data != null) {
                descriptionText.text = resource.data.weather[0].description
                temperatureText.text = String.format("%.2f c", (resource.data.main.temp.toFloat() - 273.15f))

                place.text = "Location: " + resource.data.name
                //just show whether its cloudy raining snow or clear
                when (resource.data.weather[0].main) {
                    "Clouds" -> weatherIcon.setImageResource(R.drawable.icons_partly_cloudy_day)
                    "Rain" -> weatherIcon.setImageResource(R.drawable.icons_rain)
                    "Snow" -> weatherIcon.setImageResource(R.drawable.icons_snow)
                    "Clear" -> weatherIcon.setImageResource(R.drawable.icons_sun)
                    else -> weatherIcon.setImageResource(R.drawable.cloud)
                }
            }
        })
    }
}