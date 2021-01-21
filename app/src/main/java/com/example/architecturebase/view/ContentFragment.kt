package com.example.architecturebase.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.architecturebase.MvpContract
import com.example.architecturebase.R
import com.example.architecturebase.adapter.MainAdapter
import com.example.architecturebase.databinding.ContentBinding
import com.example.architecturebase.network.model.Post
import com.example.architecturebase.presenter.Presenter

class ContentFragment : Fragment(R.layout.content), MvpContract.IView {

    private val presenter = Presenter(this)
    private val mainAdapter = MainAdapter()
    private lateinit var binding: ContentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = ContentBinding.bind(view)

        binding.mainRV.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = mainAdapter
        }
        binding.listSRL.isRefreshing = true

        presenter.loadAllPosts()

        binding.listSRL.setOnRefreshListener {
            mainAdapter.items = emptyList()
            presenter.loadAllPosts()
        }
    }

    override fun showPosts(postList: List<Post>) {
        mainAdapter.items = postList
        binding.listSRL.isRefreshing = false
    }

    override fun showFailDialog(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
        binding.listSRL.isRefreshing = false
    }
}