package com.mypost.todopost.persistence;

import com.mypost.todopost.entity.postEntity.Post;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findByAuthor(String author, Sort sort);
    @Query(value = "SELECT * FROM post ORDER BY id DESC LIMIT 1", nativeQuery = true)
    List<Post> findByRecent();

    @Query(value = "SELECT * FROM post ORDER BY id DESC", nativeQuery = true)
    List<Post> findAllByDesc();

}
