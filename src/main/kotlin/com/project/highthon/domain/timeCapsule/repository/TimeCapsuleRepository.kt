package com.project.highthon.domain.timeCapsule.repository

import com.project.highthon.domain.timeCapsule.TimeCapsule
import org.springframework.data.jpa.repository.JpaRepository

interface TimeCapsuleRepository : JpaRepository<TimeCapsule, Long> {
    fun findAllByUserId(userId: Long): List<TimeCapsule>
}