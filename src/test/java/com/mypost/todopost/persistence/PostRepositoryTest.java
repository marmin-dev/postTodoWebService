package com.mypost.todopost.persistence;

import com.mypost.todopost.entity.Post;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    void findByAuthorTest(){
        Post post1 = new Post();
        Post post2 = new Post();
        Post post3 = new Post();
        post1.setTitle("김치삼");
        post1.setAuthor("귀귀");
        post1.setContent("정열멘");
        post2.setTitle("김치광");
        post2.setAuthor("귀귀");
        post2.setContent("열정맨");
        post3.setTitle("장삐쭈");
        post3.setAuthor("귀귀");
        post3.setContent("열정돈까스");
        postRepository.save(post1);
        postRepository.save(post2);
        postRepository.save(post3);
        List<Post> posts = postRepository.findByAuthor("귀귀", Sort.by(Sort.Order.desc("id")));
        for(Post post : posts){
            System.out.println(post.toString());
        }
    }

}
