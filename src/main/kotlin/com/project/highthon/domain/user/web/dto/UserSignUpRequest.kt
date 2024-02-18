package com.project.highthon.domain.user.web.dto

data class UserSignUpRequest(
    val name: String,
    val email: String,
    val password: String,
)
