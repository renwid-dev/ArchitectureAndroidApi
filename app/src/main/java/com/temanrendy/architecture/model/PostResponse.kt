package com.temanrendy.architecture.model

import com.google.gson.annotations.SerializedName

data class PostResponse(
    val postId: Int,
    val id: Int,
    val title: String?,
    @SerializedName("body")
    val text: String?
)