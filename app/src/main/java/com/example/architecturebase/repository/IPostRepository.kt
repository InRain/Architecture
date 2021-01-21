package com.example.architecturebase.repository

import com.example.architecturebase.network.model.Post
import retrofit2.Call

interface IPostRepository {
    fun loadData(): Call<List<Post>>
}