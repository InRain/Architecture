package com.example.architecturebase.service

import com.example.architecturebase.network.model.Post
import kotlin.reflect.KFunction1

interface IPostService {
    fun getPosts(functionGetPosts: KFunction1<List<Post>, Unit>, onFailed: (Throwable) -> Unit)
}