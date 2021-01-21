package com.example.architecturebase.repository

import com.example.architecturebase.network.IPostApi
import com.example.architecturebase.network.model.Post
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class PostRepository : IPostRepository {

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .callTimeout(REQUEST_TIMEOUT_SECONDS, TimeUnit.SECONDS)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    override fun loadData(): Call<List<Post>> {
        return retrofit.create(IPostApi::class.java).getPosts()
    }

    companion object {
        private const val REQUEST_TIMEOUT_SECONDS = 5L
    }

}