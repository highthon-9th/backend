package com.project.highthon.domain.user.web

import com.project.highthon.domain.user.service.UserService
import com.project.highthon.domain.user.web.dto.UserDetailResponse
import com.project.highthon.domain.user.web.dto.UserSignInRequest
import com.project.highthon.domain.user.web.dto.UserSignUpRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/user")
class UserController(
    private val userService: UserService,
) {
    @PostMapping("/signup")
    fun signUp(@RequestBody request: UserSignUpRequest): Long {
        return userService.signUp(request)
    }

    @PostMapping("/signin")
    fun singIn(@RequestBody request: UserSignInRequest) {
        return userService.singIn(request)
    }

    @PostMapping("{userId}")
    fun getUserInfo(@PathVariable userId: Long): UserDetailResponse {
        return userService.getUserInfo(userId = userId)
    }
}