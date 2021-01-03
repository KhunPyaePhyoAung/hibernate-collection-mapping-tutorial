package me.khun.hibernate;

import me.khun.hibernate.entity.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.HashSet;
import java.util.Set;

public class StoreData {
    public static void main(String[] args) {
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(standardServiceRegistry).buildMetadata();
        SessionFactory sessionFactory = metadata.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Set<String> answerSet1 = new HashSet<>();
        answerSet1.add("Java is a programming language.");
        answerSet1.add("Java is a platform.");

        Question question1 = new Question();
        question1.setQuestionBody("What is java?");
        question1.setAnswers(answerSet1);

        Set<String> answerSet2 = new HashSet<>();
        answerSet2.add("Servlet is an API.");
        answerSet2.add("Servlet is an interface.");

        Question question2 = new Question();
        question2.setQuestionBody("What is servlet?");
        question2.setAnswers(answerSet2);

        session.persist(question1);
        session.persist(question2);

        transaction.commit();
        session.close();
        System.out.println("Success");
    }
}
