package com.anand.restapi.model;
import jakarta.persistence.*;
@Entity @Table(name="posts")
public class Post {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,length=100) private String title;
 @Column(nullable=false,length=1000) private String content;
 protected Post() { }
 public Post(String title,String content) { this.title=title; this.content=content; }
 public Long getId(){ return id; } public String getTitle(){ return title; } public String getContent(){ return content; }
}
