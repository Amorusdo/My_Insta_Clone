package com.example.myinstaclone.di

import com.example.data._network.api.DeleteApi
import com.example.data._network.api.GetApi
import com.example.data._network.api.PostApi
import com.example.data._network.api.PutApi
import com.example.data._network.provide.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideMakeService(
        retrofitBuilder: ProvideRetrofitBuilder ,
    ): MakeService = MakeServiceImpl(retrofitBuilder = retrofitBuilder)

    @Provides
    fun provideProductServiceUser(
        makeService: MakeService ,
    ): GetApi = makeService.service(GetApi::class.java)

    @Provides
    fun provideProductServicePost(
        makeService: MakeService ,
    ): PostApi = makeService.service(PostApi::class.java)

    @Provides
    fun provideProductServicePut(
        makeService: MakeService ,
    ): PutApi = makeService.service(PutApi::class.java)

    @Provides
    fun provideProductServiceDelete(
        makeService: MakeService ,
    ): DeleteApi = makeService.service(DeleteApi::class.java)


    @Provides
    fun provideProvideConvectorFactory(): ProvideConverterFactory = ProvideConverterFactoryImpl()

    @Provides
    fun provideProvideInterceptorDebug(): ProvideInterceptor = ProvideInterceptorImpl.Debug()

    @Provides
    fun provideProvideOkHttpClientBuilder(
        provideInterceptor: ProvideInterceptor ,
    ): ProvideOkHttpClientBuilder =
        ProvideOkHttpClientBuilderImpl(provideInterceptor = provideInterceptor)

    @Provides
    fun provideProvideRetroFitBuilder(
        provideConverterFactory: ProvideConverterFactory ,
        provideOkHttpClientBuilder: ProvideOkHttpClientBuilder ,
    ): ProvideRetrofitBuilder = ProvideRetrofitBuilderImpl(
        provideConverterFactory = provideConverterFactory ,
        provideOkHttpClientBuilder = provideOkHttpClientBuilder
    )
}