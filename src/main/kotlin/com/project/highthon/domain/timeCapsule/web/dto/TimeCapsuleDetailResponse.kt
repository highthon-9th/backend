package com.project.highthon.domain.timeCapsule.web.dto

import java.time.LocalDateTime

data class TimeCapsuleDetailResponse(
    val title: String,
    val content: String,
    val closeAt: LocalDateTime,
    val imageList: List<String>,
)
