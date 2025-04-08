package jpa.m250406.basic.mission02;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hibernate.Hibernate;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_mission");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            /* 🟡 문제 1. Member ↔ Team 단방향 매핑 */
//            Team team = new Team("팀 C");
//            em.persist(team);
//
//            Member member = new Member("브브드", 29, team);
//            em.persist(member);

//            Member findMember = em.find(Member.class, member.getId());
//            System.out.println(findMember.getTeam());

            /* 🟡 문제 2. Member ↔ Team 양방향 매핑 */
//            Member findMember2 = em.find(Member.class, 1L);
//            Team findTeam = em.find(Team.class, 1L);
//            findTeam.addMember(findMember2);
//            Team team2 = findMember2.getTeam();
//            System.out.println(team2.getClass().getName());
//            findTeam.getMembers().forEach(System.out::println);

            /* 🟡 문제 4. 지연 로딩 확인 (Lazy Loading) */
//            Member findMember3 = em.find(Member.class, 1L);
//            Team team3 = findMember3.getTeam();
//            System.out.println(team3.getClass().getName());

            em.flush();
            em.clear();

            /* 🟡 문제 5. 프록시 객체 확인 */
//            Team team4 = em.getReference(Team.class, 1L);
//            System.out.println(team4.getClass().getName());
//            if (team4 instanceof Team) {
//                System.out.println(Hibernate.isInitialized(team4));
//            }

            /* 🟡 문제 6. 연관관계 변경 테스트 */
            Member findMember = em.find(Member.class, 1L);
            Team team5 = em.find(Team.class, 2L);
            findMember.setTeam(team5);
            System.out.println(findMember);
            team5.getMembers().forEach(System.out::println);

            tx.commit();
        } catch(Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
