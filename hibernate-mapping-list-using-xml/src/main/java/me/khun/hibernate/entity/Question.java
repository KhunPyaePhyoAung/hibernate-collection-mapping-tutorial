package me.khun.hibernate.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Question {
    private Long id;
    private String questionText;
    private List<String> answers;
}
