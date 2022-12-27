package com.mypost.todopost.entity.todoEntity;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public boolean done =false;
    @Column(nullable = false)
    public String author;
    @Column(nullable = false)
    public String content;



}
