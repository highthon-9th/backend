package com.project.highthon.configuration

import io.swagger.v3.oas.models.info.Info
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringDocConfiguration {
    @Bean
    fun userOpenApi(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("user")
            .packagesToScan("com.project.highthon.domain.user.web")
            .pathsToMatch("/api/v1/user/**")
            .displayName("User")
            .addOpenApiCustomizer { openApi ->
                openApi.info(
                    Info()
                        .title("User API")
                        .version("v1.0.0")
                        .description(
                            """
                            User API Reference for Developers
                            """.trimIndent(),
                        ),
                )
            }
            .build()
    }

    @Bean
    fun postOpenApi(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("post")
            .packagesToScan("com.project.highthon.domain.post.web")
            .pathsToMatch("/api/v1/post/**")
            .displayName("Post")
            .addOpenApiCustomizer { openApi ->
                openApi.info(
                    Info()
                        .title("Post API")
                        .version("v1.0.0")
                        .description(
                            """
                            Post API Reference for Developers
                            """.trimIndent(),
                        ),
                )
            }
            .build()
    }

    @Bean
    fun imageOpenApi(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("image")
            .packagesToScan("com.project.highthon.domain.image.web")
            .pathsToMatch("/api/v1/image/**")
            .displayName("Image")
            .addOpenApiCustomizer { openApi ->
                openApi.info(
                    Info()
                        .title("Image API")
                        .version("v1.0.0")
                        .description(
                            """
                            Image API Reference for Developers
                            """.trimIndent(),
                        ),
                )
            }
            .build()
    }

    @Bean
    fun timeCapsuleOpenApi(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("timeCapsule")
            .packagesToScan("com.project.highthon.domain.timeCapsule.web")
            .pathsToMatch("/api/v1/time-capsule/**")
            .displayName("TimeCapsule")
            .addOpenApiCustomizer { openApi ->
                openApi.info(
                    Info()
                        .title("Image API")
                        .version("v1.0.0")
                        .description(
                            """
                            Image API Reference for Developers
                            """.trimIndent(),
                        ),
                )
            }
            .build()
    }
}
