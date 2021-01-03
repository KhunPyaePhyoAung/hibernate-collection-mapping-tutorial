package me.khun.hibernate;

import me.khun.hibernate.entity.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.HashMap;
import java.util.Map;

public class StoreData {
    public static void main(String[] args) {
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(standardServiceRegistry).buildMetadata();
        SessionFactory sessionFactory = metadata.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Map<String,String> answerMap1 = new HashMap<>();
        answerMap1.put("Khun Pyae Phyo Aung","Java is a programming language.");
        answerMap1.put("John","Java is a platform.");
        answerMap1.put("David","Java is a brand.");

        Question question1 = new Question();
        question1.setUsername("Mata");
        question1.setQuestionBody("What is java?");
        question1.setAnswers(answerMap1);

        Map<String,String> answerMap2 = new HashMap<>();
        answerMap2.put("Paul","Servlet is an API.");
        answerMap2.put("Angle","Servler is an interface.");

        Question question2 = new Question();
        question2.setUsername("Martin");
        question2.setQuestionBody("What is servlet?");
        question2.setAnswers(answerMap2);

        session.persist(question1);
        session.persist(question2);

        transaction.commit();
        session.close();
        System.out.println("Success");
    }
}
