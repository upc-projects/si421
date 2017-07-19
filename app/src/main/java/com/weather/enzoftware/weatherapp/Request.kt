package com.weather.enzoftware.weatherapp

import android.util.Log
import org.jetbrains.anko.async
import org.jetbrains.anko.uiThread
import java.net.URL

class Request (val url : String){
    fun run(){
        val forecastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName,forecastJsonStr)
        async {
            Request(url).run()
            uiThread { Log.d("toast","Hello world") }
        }
    }


}