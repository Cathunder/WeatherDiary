package zerobase.weather.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("날씨 일기 프로젝트 :)")
                        .description("날씨 일기를 CRUD 할 수 있는 백엔드 API 입니다.")
                        .version("2.0"))
                ;
    }

//    // 특정 controller 보이기 or 숨기기
//    @Bean
//    public GroupedOpenApi groupedOpenApi() {
//        return GroupedOpenApi.builder()
//                .group("날씨 일기 프로젝트 :)")
//                .packagesToScan("zerobase.weather")
//                .pathsToMatch("/read/**")
////                .pathsToExclude("/read/**")
//                .build();
//    }
}


//package zerobase.weather.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
////@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build().apiInfo(apiInfo());
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("title")
//                .description("description")
//                .version("1.0")
//                .build();
//    }
//}


