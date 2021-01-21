package com.example.architecturebase.presenter

import com.example.architecturebase.MvpContract
import com.example.architecturebase.service.IPostService
import com.example.architecturebase.service.PostService

class Presenter(private val view: MvpContract.IView) : MvpContract.IPresenter {

    private val postService: IPostService = PostService()

    override fun loadAllPosts() {
        postService.getPosts(view::showPosts, view::showFailDialog)
    }
}