package com.mypost.todopost.controller;

import com.mypost.todopost.dtos.postDto.PostCreateDto;
import com.mypost.todopost.entity.postEntity.Post;
import com.mypost.todopost.persistence.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostApiControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private PostRepository postRepository;

    @Test
    void post_저장된다() throws Exception{
        //given
        String title = "제목";
        String author = "저자";
        String content = "테스트";

        PostCreateDto dto = PostCreateDto.builder()
                .title(title)
                .author(author)
                .content(content).build();
        String url = "http://localhost:"+port+"/api/v1/post-post";
        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url,
                dto,Long.class);
        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Post> saved = postRepository.findAll();
        assertThat(saved.get(0).getTitle()).isEqualTo(title);
        assertThat(saved.get(0).getAuthor()).isEqualTo(author);
        assertThat(saved.get(0).getContent()).isEqualTo(content);

    }

}
