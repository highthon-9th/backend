package com.project.highthon.domain.post.web.dto

data class PostDetailResponse(
    val title: String,
    val content: String,
    val likeCount: Long,
)
