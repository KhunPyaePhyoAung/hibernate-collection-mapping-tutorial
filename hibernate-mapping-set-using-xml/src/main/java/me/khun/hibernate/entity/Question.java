package me.khun.hibernate.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Question {
    private Long id;
    private String questionBody;
    private Set<String> answers;
}
