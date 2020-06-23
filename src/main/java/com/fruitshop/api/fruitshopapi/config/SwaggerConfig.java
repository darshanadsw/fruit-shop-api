package com.fruitshop.api.fruitshopapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build()
                .apiInfo(apiInfo())
            .pathMapping("/");
    }

    private ApiInfo apiInfo(){
        Contact contact = new Contact("Darshana Welikala","fruit-shop-api","darshanadsw@gmail.com");
        return new ApiInfoBuilder()
                .description("Innocent attempt to master Swagger2")
                .license("Apache 2")
                .title("Fruit Shop API")
                .contact(contact)
                .build();
    }
}
