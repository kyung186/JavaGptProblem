package jpa.m250406.basic.mission05;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_mission");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            /* 🟡 문제 1. CascadeType 적용 */
//            Users users = em.find(Users.class, 1L);
//            Post post = em.find(Post.class, 2L);
//            post.setUser(users);
//
//            Comment[] comments = new Comment[10];
//            for (int i = 0; i < comments.length; i++) {
//                comments[i] = new Comment("댓글" + i, post);
//                post.addComment(comments[i]);
//            }

            /* 🟡 문제 2. orphanRemoval 적용 */
//            Post post = em.find(Post.class, 1L);
//
//            Comment[] comments = new Comment[10];
//            for (int i = 0; i < comments.length; i++) {
//                comments[i] = new Comment("댓글" + i, post);
//                post.addComment(comments[i]);
//            }
//            post.getComments().remove(comments[0]);
//            em.persist(post);

            /* 🟡 문제 3. 고아 객체 삭제와 연관관계 관리 */
//            Post post = em.find(Post.class, 1L);
//            em.remove(post);

            /* 🟡 문제 4. Entity 상태 변경 감지 (Dirty Checking) */
//            Post post = em.find(Post.class, 2L);
//            post.setTitle("제목 변경");
//            em.flush();

            /* 🟡 문제 5. 벌크 연산 */
            Users users = em.find(Users.class, 1L);
            Post post = new Post("제목제목", "내용내용", users);

            em.createQuery("UPDATE Post p SET p.title = '제목 없음'", Post.class);


            tx.commit();
//            em.clear();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
