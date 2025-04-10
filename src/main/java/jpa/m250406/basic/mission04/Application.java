package jpa.m250406.basic.mission04;

import jakarta.persistence.*;
import jpa.m250406.basic.mission04.dto.NameDTO;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_mission");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            /* 🟡 문제 1. JPQL 기본 조회 */
//            String jpql1 = "SELECT m FROM mission04_Member m WHERE m.age >= :age ORDER BY m.name";
//            TypedQuery<Member> query = em.createQuery(jpql1, Member.class);
//            query.setParameter("age", 30);
//            List<Member> members = query.getResultList();
//            for (Member member : members) {
//                System.out.println(member);
//            }

            /* 🟡 문제 2. DTO로 직접 조회 (JPQL) */
//            String jpql2 = "SELECT NEW jpa.m250406.basic.mission04.dto.NameDTO(m.name, t.name) FROM mission04_Member m JOIN m.team t";
//            TypedQuery<NameDTO> query2 = em.createQuery(jpql2, NameDTO.class);
//            List<NameDTO> names = query2.getResultList();
//            for (NameDTO nameDTO : names) {
//                System.out.println(nameDTO);
//            }

            /* 🟡 문제 3. 페이징 처리 (JPQL) */
            // 전체 데이터 수 조회
            Long totalCount = em.createQuery("SELECT COUNT(m) FROM mission04_Member m", Long.class).getSingleResult();

            String jpql3 = "SELECT m FROM mission04_Member m ORDER BY m.name";
            int pageSize = 3;

            for (int page = 0; page * pageSize < totalCount; page++) {
                List<Member> members = em.createQuery(jpql3, Member.class)
                .setFirstResult(page * pageSize)
                .setMaxResults(pageSize)
                .getResultList();

                System.out.println("=== Page " + (page + 1) + " ===");
                for (Member member : members) {
                    System.out.println(member.getName());
                }
            }

            /* 🟡 문제 4. QueryDSL로 조건 검색 */


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
