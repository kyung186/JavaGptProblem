package jpa.m250406.basic.mission01;

import jakarta.persistence.*;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_mission");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            /* ✅ 문제 2. EntityManager를 이용해 데이터 저장 */
            User user = new User("jpaUser", 25, "jpa@user.com");
            em.persist(user);

            /* ✅ 문제 3. JPA 기본 조회 */
            User findUser = em.find(User.class, user.getId());
            System.out.println(findUser.getUsername());
            System.out.println(findUser.getEmail());

            /* ✅ 문제 4. 모든 유저 목록 조회 (JPQL) */
            String jpql = "SELECT u FROM User u";
            List<User> users = em.createQuery(jpql, User.class).getResultList();

            for (User u : users) {
                System.out.println(u.getUsername());
            }

            /* ✅ 문제 5. 조건 검색 (JPQL) */
            String jpql2 = "SELECT u FROM User u WHERE u.age >= :age";
            List<User> result = em.createQuery(jpql2, User.class)
                    .setParameter("age", 20)
                    .getResultList();

            for (User u : result) {
                System.out.println(u.getUsername() + " / " + u.getAge());
            }

            /* ✅ 문제 6. 수정 & 삭제 */
            User user2 = em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                    .setParameter("email", "jpa@user.com")
                    .getSingleResult();

            // 이름 수정
            user2.setUsername("updatedUser");
            // 삭제
            em.remove(user2); // ⭐ 이게 remove 위치

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
