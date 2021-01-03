package me.khun.hibernate;

import me.khun.hibernate.entity.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

public class FetchData {
    public static void main(String[] args) {
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(standardServiceRegistry).buildMetadata();
        SessionFactory sessionFactory = metadata.buildSessionFactory();
        Session session = sessionFactory.openSession();

        TypedQuery<Question> typedQuery = session.createQuery("from Question");
        List<Question> questionList = typedQuery.getResultList();

        for(Question question : questionList){
            String username = question.getUsername();
            String questionBody = question.getQuestionBody();
            Map<String,String > answerMap = question.getAnswers();
            System.out.printf("Question : %s (by : %s)%n", questionBody, username);
            System.out.println("Answers : ");
            for(Map.Entry<String,String> entry : answerMap.entrySet()){
                System.out.printf("%s : %s%n", entry.getKey(), entry.getValue());
            }
        }
        session.close();
    }
}
