package com.example.architecturebase

import com.example.architecturebase.network.model.Post

interface MvpContract {

    interface IView {
        fun showPosts(postList: List<Post>)
        fun showFailDialog(errorMessage: String)
    }

    interface IPresenter {
        fun loadAllPosts()
    }
}