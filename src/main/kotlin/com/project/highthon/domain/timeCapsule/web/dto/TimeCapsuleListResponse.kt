package com.project.highthon.domain.timeCapsule.web.dto

import java.time.LocalDateTime

data class TimeCapsuleListResponse(
    val id: Long,
    val title: String,
    val thumbnailImage: String,
    val createdAt: LocalDateTime,
    val closeAt: LocalDateTime,
)
