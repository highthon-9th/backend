package com.project.highthon.domain.user.service

import com.project.highthon.domain.user.User
import com.project.highthon.domain.user.repository.UserRepository
import com.project.highthon.domain.user.web.dto.UserDetailResponse
import com.project.highthon.domain.user.web.dto.UserSignInRequest
import com.project.highthon.domain.user.web.dto.UserSignUpRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository
) {
    @Transactional
    fun signUp(request: UserSignUpRequest): Long {
        val user = User(
            name = request.name,
            email = request.email,
            password = request.password,
        )
        return userRepository.save(user).id!!
    }

    @Transactional
    fun singIn(request: UserSignInRequest) {
        val user = userRepository.findByEmail(request.email) ?: error("사용자를 찾을 수 없습니다.")
        if (user.password != request.password) {
            error("비밀번호가 일치하지 않습니다.")
        }
    }

    fun getUserInfo(userId: Long): UserDetailResponse {
        val user = userRepository.findByIdOrNull(userId) ?: error("사용자를 찾을 수 없습니다.")
        return UserDetailResponse(
            name = user.name,
            email = user.email
        )
    }
}