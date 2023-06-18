package com.example.myinstaclone

import android.app.Application



 class App : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
//        Parse.initialize(
//            Parse.Configuration.Builder(this@App)
//                .applicationId(getString(R.string.app_id)) // if defined
//                .clientKey(getString(R.string.client_key))
//                .server(getString(R.string.server_url))
//                .build()
//        )
    }
    companion object {
        lateinit var instance: App
            private set
    }
}