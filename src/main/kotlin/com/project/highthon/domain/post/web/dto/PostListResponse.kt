package com.project.highthon.domain.post.web.dto

data class PostListResponse(
    val id: Long,
    val writerName: String,
    val content: String,
    val imageUrl: String,
    val likeCount: Long,
)
