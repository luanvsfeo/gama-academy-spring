package com.gama.ecommerce.core.openapi;

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

@Configuration
@EnableSwagger2
public class SpringFoxConfig {
    @Bean
    public Docket apis() {
        return new Docket(DocumentationType.SWAGGER_2).
                select().apis(RequestHandlerSelectors.basePackage("com.gama"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo())
                .useDefaultResponseMessages(false);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Documentação de uma Api Rest")
                .description("\"Aplicação Spring Boot REST com anotações\"")
                .version("1.0.0").license("")
                .licenseUrl("")
                .contact(new Contact("Amne Sampaio",
                        "",
                        "amnesf@gmail.com")).build();
    }
}

