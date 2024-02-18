package com.project.highthon.domain.timeCapsule.web

import com.project.highthon.domain.timeCapsule.service.TimeCapsuleService
import com.project.highthon.domain.timeCapsule.web.dto.CreateTimeCapsuleRequest
import com.project.highthon.domain.timeCapsule.web.dto.TimeCapsuleDetailResponse
import com.project.highthon.domain.timeCapsule.web.dto.TimeCapsuleListResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/time-capsule")
class TimeCapsuleController(
    private val timeCapsuleService: TimeCapsuleService
) {
    @PostMapping
    fun create(@RequestBody request: CreateTimeCapsuleRequest) {
        return timeCapsuleService.create(request)
    }

    @GetMapping("/user/{userId}")
    fun getListByUser(@PathVariable userId: Long): List<TimeCapsuleListResponse> {
        return timeCapsuleService.getListByUserById(userId)
    }

    @GetMapping("/{timeCapsuleId}")
    fun getDetail(@PathVariable timeCapsuleId: Long): TimeCapsuleDetailResponse {
        return timeCapsuleService.getDetail(timeCapsuleId)
    }
}