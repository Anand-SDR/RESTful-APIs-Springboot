package com.anand.restapi.service;
import com.anand.restapi.dto.*;
import com.anand.restapi.model.Post;
import com.anand.restapi.repository.PostRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class PostService {
 private final PostRepository postRepository;
 public PostService(PostRepository postRepository){ this.postRepository=postRepository; }
 public List<PostResponse> getAllPosts(){ return postRepository.findAll().stream().map(PostResponse::from).toList(); }
 public PostResponse createPost(CreatePostRequest request){ return PostResponse.from(postRepository.save(new Post(request.title().trim(),request.content().trim()))); }
}
