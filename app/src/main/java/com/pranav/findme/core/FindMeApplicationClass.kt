package com.pranav.findme.core

import android.app.Application

class FindMeApplicationClass:Application() {
    override fun onCreate() {
        super.onCreate()

     TODO("Dagger Depenency")

    }
    companion object{
        private const val TAG = "FindMeApplicationClass"
       // var findMeComponent: FindMeComponent? = null
    }
}