package com.lti.Hib_ex2.Hibernate_Project2.Hibernate_project2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
      Configuration configuration=new Configuration().configure();
      StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
      SessionFactory factory=configuration.buildSessionFactory(builder.build());
      Session session=factory.openSession();
      Student stud=new Student();
      stud.setStudName("Divyanjalin");
      stud.setBranch("Manglore");
      session.beginTransaction();
      Object o = session.load(Student.class, 1);
      Student stud1=(Student)o;
      stud1.setStudName("Johnson");
      session.update(stud1);
      session.save(stud1);
      session.getTransaction().commit();
    }
}
