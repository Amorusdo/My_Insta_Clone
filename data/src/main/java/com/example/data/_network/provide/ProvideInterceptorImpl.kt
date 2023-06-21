package com.example.data._network.provide

import com.example.data._network.Utils.API_KEY
import com.example.data._network.Utils.APP_ID
import com.example.data._network.Utils.CONTENT_TYPE
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

abstract class ProvideInterceptorImpl(
    private val loggingLevel: HttpLoggingInterceptor.Level ,
) : ProvideInterceptor {
    override fun loggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = loggingLevel
    }

    override fun requestInterceptor(): Interceptor = Interceptor { chain ->
        val request = chain.request()
            .newBuilder()
            .addHeader("X-Parse-Application-Id" , APP_ID)
            .addHeader("X-Parse-REST-API-Key" , API_KEY)
            .addHeader("Content-Type" , CONTENT_TYPE)
            .cacheControl(CacheControl.Builder().maxAge(0 , TimeUnit.SECONDS).build())
            .build()
        return@Interceptor chain.proceed(request)
    }

    class Debug : ProvideInterceptorImpl(loggingLevel = HttpLoggingInterceptor.Level.BODY)

    class Release : ProvideInterceptorImpl(loggingLevel = HttpLoggingInterceptor.Level.NONE)
}

