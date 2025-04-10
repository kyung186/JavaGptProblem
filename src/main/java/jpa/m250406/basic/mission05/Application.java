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

            Post post = em.find(Post.class, 1L);

            Comment[] comments = new Comment[10];
            for (int i = 0; i < comments.length; i++) {
                comments[i] = new Comment("댓글" + i, post);
                post.addComment(comments[i]);
            }
            post.getComments().remove(comments[0]);
            em.persist(post);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }

    }
}
