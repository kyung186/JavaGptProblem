package jpa.m250406.basic.mission03;

import jakarta.persistence.*;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_mission");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
//            Team team = new Team("팀 D");
//            Member member = new Member("테스트", 20, team);
//            em.persist(team);
//            em.persist(member);

            /* 🟡 문제 1. 프록시 객체 확인 */
//            Member findMember = em.find(Member.class, 1L);
//            Team findTeam = em.find(Team.class, 5);
//            findMember.setTeam(findTeam);
//            System.out.println(findMember);

            em.flush();
            em.clear();

            /* 🟡 문제 4. Fetch Join으로 N+1 문제 해결 */
            String jpql1 = "SELECT m FROM mission03_Member m JOIN FETCH m.team";

            TypedQuery<Member> query = em.createQuery(jpql1, Member.class);
            List<Member> members1 = query.getResultList();
            for (Member member : members1) {
                System.out.println(member.getName() + " / " + member.getTeam().getName());
            }

            System.out.println();

            List<Member> members2 = em.createQuery(jpql1, Member.class).getResultList();
            for (Member member : members2) {
                System.out.println(member.getName() + " / " + member.getTeam().getName());
            }

            /* 🟡 문제 5. 컬렉션 Fetch Join과 중복 문제 */
            String jpql2 = "SELECT t FROM mission03_Team t JOIN FETCH t.members";
            List<Team> teams1 = em.createQuery(jpql2, Team.class).getResultList();
            System.out.println(teams1.size());
            System.out.println("=== teams1 ===");
            for (Team team : teams1) {
                System.out.println(team + " / " + team.getMembers().size());
            }

            String jpql3 = "SELECT DISTINCT t FROM mission03_Team t JOIN FETCH t.members";
            List<Team> teams2 = em.createQuery(jpql3, Team.class).getResultList();
            System.out.println(teams2.size());
            System.out.println("=== teams2 ===");
            for (Team team : teams2) {
                System.out.println(team + " / " + team.getMembers().size());
            }

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
