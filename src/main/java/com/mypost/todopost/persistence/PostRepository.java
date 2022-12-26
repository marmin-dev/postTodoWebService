package com.mypost.todopost.persistence;

import com.mypost.todopost.entity.Post;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    List<Post> findByAuthor(String author, Sort sort);

//    List<Post> findAllDesc();
}
