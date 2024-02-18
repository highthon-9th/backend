package com.project.highthon.domain.post.web.dto

data class CreatePostRequest(
    val writerId: Long,
    val content: String,
    val imageUrl: String,
    val generation: Long,
)
