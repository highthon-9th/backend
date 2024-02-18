package com.project.highthon.domain.post.service

import com.project.highthon.domain.post.Post
import com.project.highthon.domain.post.repository.PostRepository
import com.project.highthon.domain.post.web.dto.*
import com.project.highthon.domain.user.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PostService(
    private val postRepository: PostRepository,
    private val userRepository: UserRepository,
) {
    @Transactional
    fun create(request: CreatePostRequest) {
        postRepository.save(
            Post(
                writerId = request.writerId,
                content = request.content,
                generation = request.generation,
                imageUrl = request.imageUrl,
                likeCount = 0,
            )
        )
    }

    @Transactional
    fun createLike(postId: Long) {
        val post = postRepository.findByIdOrNull(postId) ?: error("존재하지 않는 게시글입니다.")
        post.likeCount++
    }

    @Transactional
    fun deleteLike(postId: Long) {
        val post = postRepository.findByIdOrNull(postId) ?: error("존재하지 않는 게시글입니다.")
        post.likeCount--
    }

    fun getList(generation: Long): List<PostListResponse> {
        val targetPostList = postRepository.findAll().filter { it.generation == generation }
        val writerIdList = targetPostList.map { it.writerId }
        val writerList = userRepository.findAllById(writerIdList).associateBy { it.id }
        return targetPostList.map {
            PostListResponse(
                id = it.id!!,
                writerName = writerList[it.writerId]?.name ?: error("존재하지 않는 사용자입니다."),
                content = it.content,
                imageUrl = it.imageUrl,
                likeCount = it.likeCount,
            )
        }
    }

    @Transactional
    fun modify() {

    }
}