package efub.yeefube.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("*", "http://localhost:3000", "https://seondal.github.io/Clone-Youtube-Web/")
                .allowedMethods("*")
                .maxAge(3000);
    }


}
