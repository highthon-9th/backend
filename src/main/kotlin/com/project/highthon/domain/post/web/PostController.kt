package com.project.highthon.domain.post.web

import com.project.highthon.domain.post.service.PostService
import com.project.highthon.domain.post.web.dto.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/post")
class PostController(
    private val postService: PostService,
) {
    @PostMapping
    fun create(@RequestBody request: CreatePostRequest) {
        return postService.create(request)
    }

    @GetMapping
    fun getList(@RequestParam generation: Long): List<PostListResponse> {
        return postService.getList(generation = generation)
    }

    @PostMapping("/{postId}/like")
    fun createLike(@PathVariable postId: Long) {
        return postService.createLike(postId = postId)
    }

    @DeleteMapping("/{postId}/like")
    fun deleteLike(@PathVariable postId: Long) {
        return postService.deleteLike(postId = postId)
    }

    @PutMapping("/{id}")
    fun modify(@PathVariable id: String, request: PostUpdateRequest) {
        return postService.modify()
    }
}