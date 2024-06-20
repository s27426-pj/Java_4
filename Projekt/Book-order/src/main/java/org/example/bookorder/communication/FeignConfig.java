package org.example.bookorder.communication;
import feign.Logger;
import feign.codec.ErrorDecoder;
import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

    @Configuration
    public class FeignConfig {

        @Bean
        public OkHttpClient client() {
            return new OkHttpClient();
        }

        @Bean
        public Logger.Level feignLoggerLevel() {
            return Logger.Level.FULL;
        }

        @Bean
        public ErrorDecoder errorDecoder() {
            return new CustomErrorDecoder();
        }

        static class CustomErrorDecoder implements ErrorDecoder {
            @Override
            public Exception decode(String methodKey, feign.Response response) {
                return new RuntimeException("Feign client error: " + response.status());
            }
        }
    }

