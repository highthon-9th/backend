package com.project.highthon.domain.image.web

import com.project.highthon.domain.image.S3Uploader
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api/v1/image")
class ImageController(
    private val s3Uploader: S3Uploader
) {
    @PostMapping
    fun upload(@RequestPart file: MultipartFile): String {
        return s3Uploader.upload(file = file)
    }
}