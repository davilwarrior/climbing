/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.climbing.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.Arrays;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
/**
 *
 * @author David
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {                                    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build()
                .apiInfo(apiInfo())
          .securitySchemes(Arrays.asList(apiKey()));                                           
    }
    
     private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("REST API")
                .description("Rest Api UDOMI.").termsOfServiceUrl("")
                .contact(new Contact("Juan Fernando Borja / David Piedra", "", "david.piedra9330@gmail.com / juanferborja@gmail.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .version("0.0.1")
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("authkey", "Authorization", "header");
      }
    
    
}
