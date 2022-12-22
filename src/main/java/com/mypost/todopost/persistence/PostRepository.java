package com.mypost.todopost.persistence;

import com.mypost.todopost.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
