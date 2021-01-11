package com.example.architecturebase.repository

import com.example.architecturebase.network.IPostApi

interface IPostRepository {
    fun loadData(): IPostApi
}