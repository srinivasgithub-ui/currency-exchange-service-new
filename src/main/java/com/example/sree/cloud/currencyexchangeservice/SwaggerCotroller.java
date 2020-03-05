package com.example.sree.cloud.currencyexchangeservice;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Controller
@EnableSwagger2
public class SwaggerCotroller {
	
	public static final Contact DEFAULT_CONTACT = new Contact("", "", "");
	  public static final ApiInfo default_api_info = new ApiInfo("Api Documentation", "Api Documentation", "1.0", "urn:tos",
	          DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");


	@Bean
	public Docket Api(){
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(default_api_info);
	}

}
