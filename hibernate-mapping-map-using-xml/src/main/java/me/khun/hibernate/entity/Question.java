package me.khun.hibernate.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Question {
    private Long id;
    private String username;
    private String questionBody;
    private Map<String,String> answers;
}
