package com.example.restservice.h2.embedded.db.rest.crud.config;


import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                //.paths(matchPathRegex("/cars(/\\{id\\}|$)"))
                .paths(PathSelectors.any())
                .build();
    }


    private static Predicate<String> matchPathRegex(final String... pathRegexs) {
        return new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                for (String pathRegex : pathRegexs) {
                    if (input.matches(pathRegex)) {
                        return true;
                    }
                }
                return false;
            }
        };
    }

    @Bean
	WebMvcConfigurer configurer () {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addResourceHandlers (ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/apidocs/swagger.yaml").
                        addResourceLocations("classpath:/apidocs");
            }
        };
    }
}