package com.aimicor.tvmaze

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiServiceFactory {

    fun create(): ApiService {

        val interceptor = Interceptor { chain ->
            val oldRequest = chain.request()

            val newRequest = oldRequest.newBuilder() // key value pair: variable and its value ie name / heather
                .header("X-RapidAPI-Key", "your-key") //adding a header and its value which is key value pair
                .method(oldRequest.method(), oldRequest.body())
                .build()

            chain.proceed(newRequest)
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()


        return Retrofit.Builder() // retrofit is the library that you use to request information from the internet
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // design patterns: builder and factory methods
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://tvjan-tvmaze-v1.p.rapidapi.com/") //creating the instance that will later make calls to the internet
            .client(client)
            .build()
            .create(ApiService::class.java)
    }
}

