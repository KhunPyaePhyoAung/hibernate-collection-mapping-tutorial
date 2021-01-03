package me.khun.hibernate;

import me.khun.hibernate.entity.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.TypedQuery;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FetchData {
    public static void main(String[] args) {
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(standardServiceRegistry).buildMetadata();
        SessionFactory sessionFactory = metadata.buildSessionFactory();
        Session session = sessionFactory.openSession();

        TypedQuery<Question> typedQuery = session.createQuery("from Question");
        List<Question> questions = typedQuery.getResultList();
        for(Question question : questions){
            String questionBody = question.getQuestionBody();
            System.out.println("Question : "+questionBody);
            System.out.println("Answer : ");
            Set<String> answers = question.getAnswers();
            Iterator<String> answerIterator = answers.iterator();
            int i = 0;
            while (answerIterator.hasNext()){
                i++;
                String answer = answerIterator.next();
                System.out.printf("%d) %s%n", i,answer);
            }
        }

    }
}
