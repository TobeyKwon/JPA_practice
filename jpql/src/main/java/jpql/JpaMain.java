package jpql;

import javax.persistence.*;
import java.util.List;

public class JpaMain {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Member member1 = new Member();
            member1.setName("member1");
            member1.setAge(20);
            em.persist(member1);

            Member member2 = new Member();
            member2.setName("member2");
            member2.setAge(20);
            em.persist(member2);

            int resultCount = em.createQuery("update Member m set m.age = 10").executeUpdate();
            em.clear();

            System.out.println("resultCount = " + resultCount);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
