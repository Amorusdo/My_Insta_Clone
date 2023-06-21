package com.example.data._network.provide

import retrofit2.Retrofit

class ProvideRetrofitBuilderImpl(
    private val provideConverterFactory: ProvideConverterFactory ,
    private val provideOkHttpClientBuilder: ProvideOkHttpClientBuilder ,
) : ProvideRetrofitBuilder {
    override fun provideRetrofitBuilder(): Retrofit.Builder = Retrofit.Builder()
        .addConverterFactory(provideConverterFactory.converterFactory())
        .client(provideOkHttpClientBuilder.httpClientBuilder())
}