package com.project.highthon.domain.timeCapsule.service

import com.project.highthon.domain.timeCapsule.TimeCapsule
import com.project.highthon.domain.timeCapsule.repository.TimeCapsuleRepository
import com.project.highthon.domain.timeCapsule.web.dto.CreateTimeCapsuleRequest
import com.project.highthon.domain.timeCapsule.web.dto.TimeCapsuleDetailResponse
import com.project.highthon.domain.timeCapsule.web.dto.TimeCapsuleListResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class TimeCapsuleService(
    private val timeCapsuleRepository: TimeCapsuleRepository,
) {
    @Transactional
    fun create(request: CreateTimeCapsuleRequest) {
        timeCapsuleRepository.save(
            TimeCapsule(
                userId = request.userId,
                title = request.title,
                content = request.content,
                createdAt = LocalDateTime.now(),
                closeAt = request.closeAt,
                imageList = request.imageList,
            )
        )
    }

    fun getListByUserById(userId: Long): List<TimeCapsuleListResponse> {
        return timeCapsuleRepository.findAllByUserId(userId).map {
            TimeCapsuleListResponse(
                id = it.id!!,
                title = it.title,
                thumbnailImage = it.imageList.first(),
                closeAt = it.closeAt,
                createdAt = it.createdAt,
            )
        }
    }

    fun getDetail(timeCapsuleId: Long): TimeCapsuleDetailResponse {
        val timeCapsule = timeCapsuleRepository.findByIdOrNull(timeCapsuleId) ?: error("존재하지 않는 타임캡슐입니다.")
        if (LocalDateTime.now() < timeCapsule.closeAt) {
            error("아직 열리지 않은 타임캡슐입니다.")
        }
        return TimeCapsuleDetailResponse(
            title = timeCapsule.title,
            content = timeCapsule.content,
            closeAt = timeCapsule.closeAt,
            imageList = timeCapsule.imageList,
        )
    }
}