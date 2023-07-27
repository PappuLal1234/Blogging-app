package com.blog.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="comments")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,scope=Comment.class,property="commentId")

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer commentId;
    private String commentContent;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="post_id")
    private Post post;
}