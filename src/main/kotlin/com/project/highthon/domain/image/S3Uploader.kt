package com.project.highthon.domain.image

import io.awspring.cloud.s3.ObjectMetadata
import io.awspring.cloud.s3.S3Template
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import org.springframework.util.StringUtils
import java.time.LocalDateTime
import java.util.*

@Service
class S3Uploader(
    private val s3Template: S3Template
) {
    fun upload(file: MultipartFile): String {
        val originFileName = file.originalFilename
        val fileExtension = StringUtils.getFilenameExtension(originFileName)!!
        val fileName = createFileName(fileExtension)
        s3Template.upload(
            "snapvibe-s3",
            fileName,
            file.inputStream,
            ObjectMetadata.builder().contentType(fileExtension).build()
        )
        return "https://snapvibe-s3.s3.ap-northeast-2.amazonaws.com/$fileName"
    }

    private fun createFileName(fileExtension: String): String {
        return UUID.randomUUID().toString() + LocalDateTime.now() + "." + fileExtension
    }
}