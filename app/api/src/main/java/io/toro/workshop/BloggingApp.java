package io.toro.workshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.toro.workshop.blog.BlogService;
import io.toro.workshop.blog.InMemoryBlogServiceImpl;
import io.toro.workshop.blog.event.BlogEventListener;

@SpringBootApplication
public class BloggingApp {

    public static void main( String[] args ) {
        SpringApplication.run(BloggingApp.class, args );
    }

    @Bean
    BlogService blogService() {
        return new InMemoryBlogServiceImpl();
    }
    
    @Bean
    BlogEventListener blogEventListener(){
        return new BlogEventListener();
    }
}
