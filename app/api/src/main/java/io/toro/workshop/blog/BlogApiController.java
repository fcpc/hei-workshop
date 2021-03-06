package io.toro.workshop.blog;

import io.toro.workshop.blog.event.BlogUpdatedEvent;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;

@CrossOrigin
@RestController
@RequestMapping( value = "api/blogs" )
public class BlogApiController {

    private final BlogService blogService;
    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    BlogApiController( BlogService blogService, ApplicationEventPublisher publisher ) {
        this.blogService = blogService;
        this.eventPublisher = publisher;
    }

    @RequestMapping( method = RequestMethod.GET )
    ResponseEntity<List<Blog>> getBlogs() {
        List<Blog> blogs = blogService.findBlogs();

        return ResponseEntity.ok( blogs );
    }

    @RequestMapping( value = "{id}", method = RequestMethod.GET )
    ResponseEntity<Blog> getBlog( @PathVariable Long id ) {
        Blog blog = blogService.findBlog( id );

        return ResponseEntity.ok( blog );
    }

    @RequestMapping( method = RequestMethod.POST )
    ResponseEntity<Blog> saveBlog( @RequestBody Blog blog, UriComponentsBuilder ucb ) {
        blog = blogService.saveBlog( blog );
        eventPublisher.publishEvent( new BlogUpdatedEvent( blog ) );

        URI locationURI = ucb.path( "/api/blogs/" ).path( String.valueOf( blog.getId() ) ).build().toUri();
        return ResponseEntity.created( locationURI ).body( blog );
    }

    @RequestMapping( value = "{id}", method = RequestMethod.DELETE )
    ResponseEntity<Void> deleteblog( @PathVariable Long id ) {
        blogService.deleteBlogById( id );

        return ResponseEntity.noContent().build();
    }

}
