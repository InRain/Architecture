package com.example.architecturebase

import com.example.architecturebase.network.model.Post

interface MvpContract {

    interface IView {
        fun getPosts(postList: List<Post>)
        fun showFailDialog(throwable: Throwable)
    }

    interface IPresenter {
        fun loadAllPosts()
    }
}