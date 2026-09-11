package com.anand.restapi.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
public record CreatePostRequest(@NotBlank(message="Title is required") @Size(max=100,message="Title must not exceed 100 characters") String title, @NotBlank(message="Content is required") @Size(max=1000,message="Content must not exceed 1000 characters") String content) { }
