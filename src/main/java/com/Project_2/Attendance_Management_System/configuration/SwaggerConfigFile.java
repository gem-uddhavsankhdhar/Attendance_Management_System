package com.Project_2.Attendance_Management_System.configuration;


        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;

        import springfox.documentation.builders.PathSelectors;
        import springfox.documentation.builders.RequestHandlerSelectors;
        import springfox.documentation.spi.DocumentationType;
        import springfox.documentation.spring.web.plugins.Docket;
        import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfigFile {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.Project_2.Attendance_Management_System.controller"))
                .paths(PathSelectors.any())
                .build();
    }

}