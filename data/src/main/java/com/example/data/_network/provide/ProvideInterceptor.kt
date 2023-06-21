package com.example.data._network.provide

import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

interface ProvideInterceptor {

    fun loggingInterceptor(): HttpLoggingInterceptor

    fun requestInterceptor(): Interceptor

}