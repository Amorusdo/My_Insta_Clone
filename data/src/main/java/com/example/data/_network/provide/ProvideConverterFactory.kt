package com.example.data._network.provide

import retrofit2.Converter

interface ProvideConverterFactory {
    fun converterFactory(): Converter.Factory
}