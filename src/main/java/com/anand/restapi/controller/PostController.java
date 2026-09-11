package com.anand.restapi.controller;
import com.anand.restapi.dto.*;
import com.anand.restapi.service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/posts")
public class PostController {
 private final PostService postService;
 public PostController(PostService postService){ this.postService=postService; }
 @GetMapping public ResponseEntity<ApiResponse<List<PostResponse>>> getAllPosts(){ return ResponseEntity.ok(ApiResponse.success("Posts retrieved successfully",postService.getAllPosts())); }
 @PostMapping public ResponseEntity<ApiResponse<PostResponse>> createPost(@Valid @RequestBody CreatePostRequest request){ return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Post created successfully",postService.createPost(request))); }
}
