package com.example.data._network.provide

import com.example.data._network.Utils
import com.example.data._network.provide.ProvideRetrofitBuilder

class MakeServiceImpl(
    private val retrofitBuilder: ProvideRetrofitBuilder ,
) : MakeService {

    private val retrofit by lazy(LazyThreadSafetyMode.NONE) {
        retrofitBuilder
            .provideRetrofitBuilder()
            .baseUrl(Utils.BASE_URL)
            .build()
    }

    override fun <T> service(clasz: Class<T>): T = retrofit.create(clasz)
}