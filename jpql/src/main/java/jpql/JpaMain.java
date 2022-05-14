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

            for(int i = 0; i < 100; i++) {
                Member member = new Member();
                member.setName("member1");
                member.setAge(i);
                em.persist(member);
            }
            int page = 1;
            List<Member> resultList = em.createQuery("select m from Member m", Member.class)
                    .setFirstResult((page - 1) * 10)
                    .setMaxResults(10)
                    .getResultList();
            System.out.println("============ page1 ===============");
            for (Member member : resultList) {
                System.out.println("member = " + member);
            }

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
