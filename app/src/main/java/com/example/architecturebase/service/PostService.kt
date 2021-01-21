package com.example.architecturebase.service

import com.example.architecturebase.network.model.Post
import com.example.architecturebase.repository.PostRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.reflect.KFunction1

class PostService : IPostService {

    private val postRepository = PostRepository()

    override fun getPosts(
        functionGetPosts: (List<Post>) -> Unit,
        onFailed: (String) -> Unit
    ) {
        postRepository.loadData().enqueue(object : Callback<List<Post>> {

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                onFailed(t.localizedMessage ?: "Something goes wrong")
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    response.body()?.let { posts -> functionGetPosts(sortPosts(posts)) }
                } else {
                    onFailed("Response failed with code ${response.code()}")
                }
            }

        })
    }

    private fun sortPosts(posts: List<Post>): List<Post> {
        return posts.filter {
            !it.title.startsWith("H")
        }.map {
            it.copy(title = it.title + "appendix")
        }.sortedBy {
            it.title
        }.subList(0, posts.size - 3)
    }

}