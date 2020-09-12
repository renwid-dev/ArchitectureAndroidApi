package com.temanrendy.architecture.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.temanrendy.architecture.R
import com.temanrendy.architecture.adapter.UserAdapter
import com.temanrendy.architecture.api.RetrofitClient
import com.temanrendy.architecture.model.User
import com.temanrendy.architecture.model.UserResponse
import kotlinx.android.synthetic.main.activity_user.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserActivity : AppCompatActivity() {
    private val list = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        showUser()
    }

    private fun showUser() {
        rvUser.setHasFixedSize(true)
        rvUser.layoutManager = LinearLayoutManager(this)
        RetrofitClient.instance.getUsers().enqueue(object : Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                tvResponseCode.text = response.code().toString()
                val listResponse = response.body()?.data
                listResponse?.let { list.addAll(it) }
                val adapter = UserAdapter(list)
                rvUser.adapter = adapter
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                tvResponseCode.text = t.message
            }

        })
    }
}