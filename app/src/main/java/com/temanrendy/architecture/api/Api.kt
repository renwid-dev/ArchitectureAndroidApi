package com.temanrendy.architecture.api

import com.temanrendy.architecture.model.PostResponse
import com.temanrendy.architecture.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    //get type data json object
    @GET("users")
    fun getUsers(): Call<UserResponse>
    //get type data json array
    @GET("https://jsonplaceholder.typicode.com/posts/")
    fun getPosts(): Call<ArrayList<PostResponse>>
}