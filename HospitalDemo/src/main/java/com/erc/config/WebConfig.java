package com.erc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;  // Bu satır eklendi
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(@NonNull CorsRegistry registry) {
        registry.addMapping("/**")  // Tüm endpointleri kapsar
                .allowedOriginPatterns("http://localhost:4200")  // Sadece belirtilen kaynağa izin verir
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // İzin verilen HTTP metodları
                .allowedHeaders("*")  // Tüm başlıklara izin verir
                .allowCredentials(true);  // Kimlik doğrulama bilgilerine izin verir
    }
}