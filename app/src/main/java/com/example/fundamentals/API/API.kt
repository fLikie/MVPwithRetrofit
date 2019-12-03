package com.example.fundamentals.API

import com.example.fundamentals.BuildConfig
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface API {

    @GET("search.ashx?")
    fun getGamePrices(@Query("query") gameName: String, @Query("pagesize") pageSize: Int, @Query("pagenum") pageNum: Int, @Query("visibleOnly") visibleOnly: Boolean, @Query("response") response: String): Deferred<Game>


    companion object Factory {
        fun create(): API {
            val client = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
                level =
                    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            })
                .readTimeout(5, TimeUnit.SECONDS)
                .build()


            val retrofit = retrofit2.Retrofit.Builder()
                .client(client)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://www.plati.io/api/")
                .build()

            return retrofit.create(API::class.java)
        }
    }
}