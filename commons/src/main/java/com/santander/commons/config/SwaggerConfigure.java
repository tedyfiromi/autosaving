package com.santander.commons.config;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfigure {

    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(infoApi().build());
    }
    
    private ApiInfoBuilder infoApi() {
    	 
		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
 
		apiInfoBuilder.title("Santander Autosavings");
		apiInfoBuilder.description("This is the AutoSavings Middleware");
		apiInfoBuilder.version("1.0");
		apiInfoBuilder.termsOfServiceUrl("All rights reserved to santander");
		apiInfoBuilder.licenseUrl("http://www.santander.com.br");
 
		return apiInfoBuilder;
 
	}


}
