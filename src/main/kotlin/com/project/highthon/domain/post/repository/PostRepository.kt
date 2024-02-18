package com.project.highthon.domain.post.repository

import com.project.highthon.domain.post.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository: JpaRepository<Post, Long> {
}