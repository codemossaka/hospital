package com.godsonpeya.hospital.config

import io.swagger.v3.oas.models.ExternalDocumentation
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
internal class SwaggerConfig {
    @Bean
    fun productApi(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("hospital")
            .packagesToScan("com.godsonpeya.hospital")
            .pathsToMatch("/**")
            .build()
    }

    @Bean
    fun springShopOpenAPI(): OpenAPI {
        return OpenAPI()
            .info(
                Info().title("hospital API")
                    .description("hospital app openAPI")
                    .version("v1.0.0")
                    .license(License().name("Amoyah 1.0.0").url("http://godsonpeya.ru"))
            )
            .externalDocs(
                ExternalDocumentation()
                    .description("v Wiki Documentation")
                    .url("http://godsonpeya.ru")
            )
    } //    @Bean
    //    public GroupedOpenApi adminApi() {
    //        return GroupedOpenApi.builder()
    //                .group("hospital Dashboard")
    //                .pathsToMatch("/**")
    //                .addOpenApiMethodFilter(method -> method.isAnnotationPresent(Admin.class))
    //                .build();
    //    }
}