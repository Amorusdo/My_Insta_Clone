package com.example.data._network.provide

import okhttp3.OkHttpClient

interface ProvideOkHttpClientBuilder {
    fun httpClientBuilder(): OkHttpClient

}