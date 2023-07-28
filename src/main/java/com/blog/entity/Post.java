package com.blog.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
@Table(name="post")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,scope=Post.class,property="postId")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer postId;
    @Column(name="post_title")
    private String postTitle;
    @Column(name="post_content")
    private String postContent;

    private Date postAddedDate;


    @OneToMany(cascade = CascadeType.ALL)
    private Set<Comment> comments=new HashSet<>();
}

