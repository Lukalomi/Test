package com.example.playground

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class TestProject : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}