package com.example.data._network.provide

interface MakeService {
    fun <T> service(clasz: Class<T>): T
}