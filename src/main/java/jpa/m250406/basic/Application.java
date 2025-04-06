package jpa.m250406.basic;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-lecture");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
//            /* ✅ 문제 2. EntityManager를 이용해 데이터 저장 */
//            User user = new User("jpaUser", Date.valueOf(LocalDate.now()), "jpa@user.com", "test", "1");
//            em.persist(user);

            /* ✅ 문제 3. JPA 기본 조회 */
            User findUser = em.find(User.class, 1L);
            System.out.println("\nID: " + findUser.getUserId());
            System.out.println("Email: " + findUser.getEmail() + "\n");

            /* ✅ 문제 4. 모든 유저 목록 조회 (JPQL) */
            String jpql = "SELECT u FROM User u";
            List<User> users = em.createQuery(jpql, User.class).getResultList();

            System.out.println("\nList: ");
            for (User user : users) {
                System.out.println(user.getUsername());
            }

            /* ✅ 문제 5. 조건 검색 (JPQL) */
            String jpql2 = "SELECT u FROM User u WHERE YEAR(u.birthDate) >= 1995";
            List<User> users2 = em.createQuery(jpql2, User.class).getResultList();

            System.out.println("\nList: ");
            for (User user : users2) {
                System.out.println(user.getUsername() + ": " + user.getBirthDate());
            }

            /* ✅ 문제 6. 수정 & 삭제 */
            User user = em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                    .setParameter("email", "jpa@user.com")
                    .getSingleResult();

            user.setUsername("updatedUser");
            em.remove(user);

//            String jpql3 = "UPDATE User u SET u.username = :username WHERE u.email = :email";
//            Query query = em.createQuery(jpql3);
//            query.setParameter("username", "updatedUser");
//            query.setParameter("email", "jpa@user.com");
//            query.executeUpdate();
//
//            String jpql4 = "DELETE FROM User u WHERE u.email = :email";
//            query = em.createQuery(jpql4);
//            query.setParameter("email", "jpa@user.com");
//            query.executeUpdate();

            tx.commit();
            em.clear();
        } catch(Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
