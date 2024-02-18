package com.project.highthon.domain.timeCapsule

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class TimeCapsule(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val userId: Long,

    val title: String,

    val content: String,

    val closeAt: LocalDateTime,

    @ElementCollection
    @CollectionTable(
        name = "time_capsule_image",
        joinColumns = [JoinColumn(name = "time_capsule_id")
        ]
    )
    val imageList: List<String>,

    val createdAt: LocalDateTime,
)
