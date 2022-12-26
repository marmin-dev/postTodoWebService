package com.mypost.todopost.persistence;

import com.mypost.todopost.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {

//    @Query("SELECT p FROM post p ORDER BY p.createdAt DESC LIMIT 1")
//    List<Post> findByCreatedAtDesc1(); //index에 표시할 항목 불러오기 메서드

    List<Post> findByAuthor(String author);
}
