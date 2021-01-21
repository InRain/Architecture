package com.example.architecturebase.service

import com.example.architecturebase.network.model.Post
import kotlin.reflect.KFunction1

interface IPostService {
    fun getPosts(functionGetPosts: (List<Post>) -> Unit, onFailed: (String) -> Unit)
}