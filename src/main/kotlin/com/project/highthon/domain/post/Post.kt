package com.project.highthon.domain.post

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Post(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val writerId: Long,

    val content: String,

    val imageUrl: String,

    val generation: Long,

    var likeCount: Long,
)
