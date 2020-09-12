package com.temanrendy.architecture.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.temanrendy.architecture.R
import com.temanrendy.architecture.adapter.PostAdapter
import com.temanrendy.architecture.api.RetrofitClient
import com.temanrendy.architecture.model.PostResponse
import kotlinx.android.synthetic.main.activity_post.*
import kotlinx.android.synthetic.main.activity_user.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlinx.android.synthetic.main.activity_user.tvResponseCode as tvResponseCode1

class PostActivity : AppCompatActivity() {
    private val list = ArrayList<PostResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        showPost()
    }

    private fun showPost() {
        rvPost.setHasFixedSize(true)
        rvPost.layoutManager = LinearLayoutManager(this)
        RetrofitClient.instance.getPosts().enqueue(object : Callback<ArrayList<PostResponse>>{
            override fun onResponse(
                call: Call<ArrayList<PostResponse>>,
                response: Response<ArrayList<PostResponse>>
            ) {
                tvResponseCode.text = response.code().toString()
                val listResponse = response.body()
                listResponse?.let { list.addAll(it) }
                val adapter = PostAdapter(list)
                rvPost.adapter = adapter
            }

            override fun onFailure(call: Call<ArrayList<PostResponse>>, t: Throwable) {
                tvResponseCode.text = t.message
            }

        })
    }
}