package jpa.m250406.basic.mission05;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpa.m250406.basic.mission05.model.Post;
import jpa.m250406.basic.mission05.model.Users;

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
            Users user = em.find(Users.class, 1L);
            Post post1 = new Post("제목제목", "내용내용", user);
            Post post2 = new Post("제목이다", "내용이다", user);
            em.persist(post1);
            em.persist(post2);

            int updatedCount = em.createQuery("UPDATE Post p SET p.content = '내용 없음'").executeUpdate();
            System.out.println("업데이트된 행 수 : " + updatedCount);

            System.out.println("post1: " + post1.getContent());
            System.out.println("post2: " + post2.getContent());

            em.clear();

            Post reloadedPost1 = em.find(Post.class, post1.getId());
            Post reloadedPost2 = em.find(Post.class, post2.getId());
            System.out.println("reloadedPost1: " + reloadedPost1.getContent());
            System.out.println("reloadedPost2: " + reloadedPost2.getContent());

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
