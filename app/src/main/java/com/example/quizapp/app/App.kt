package com.example.quizapp.app

import android.app.Application
import com.example.quizapp.data.serviceLocator.dataModule
import com.example.quizapp.ui.serviceLocator.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            modules(dataModule, uiModule)
        }
    }
}