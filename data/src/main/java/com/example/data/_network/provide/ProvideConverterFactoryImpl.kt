package com.example.data._network.provide

import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory

class ProvideConverterFactoryImpl : ProvideConverterFactory {
    override fun converterFactory(): Converter.Factory = GsonConverterFactory.create()
}