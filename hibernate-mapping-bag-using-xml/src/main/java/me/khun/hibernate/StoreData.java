package me.khun.hibernate;

import me.khun.hibernate.entity.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class StoreData {
    public static void main(String[] args) {
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(standardServiceRegistry).buildMetadata();
        SessionFactory sessionFactory = metadata.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<String> answerList1 = new ArrayList<>();
        answerList1.add("Java is a programming language.");
        answerList1.add("Java is a platform.");

        Question question1 = new Question();
        question1.setQuestionBody("What is java?");
        question1.setAnswers(answerList1);

        List<String> answerList2 = new ArrayList<>();
        answerList2.add("Servlet is an API.");
        answerList2.add("Servlet is an interface.");

        Question question2 = new Question();
        question2.setQuestionBody("What is servlet?");
        question2.setAnswers(answerList2);

        session.persist(question1);
        session.persist(question2);

        transaction.commit();
        session.close();
        System.out.println("Success");
    }
}
