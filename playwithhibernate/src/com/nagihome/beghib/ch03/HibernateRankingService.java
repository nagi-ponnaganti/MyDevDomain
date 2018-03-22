package com.nagihome.beghib.ch03;

import com.nagihome.beghib.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class HibernateRankingService implements RankingService {

    @Override
    public int getRankingFor(String subject, String skill) {

        Integer ranking = 0;

        try (Session session = SessionUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            ranking = getRankingFor(session, subject, skill);
            tx.commit();
        }

        return ranking;
    }

    private int getRankingFor(Session session, String subject, String skill) {

        Query<Ranking> rankingQuery = session.createQuery("from Ranking r where r.subject.name=:subject and r.skill.name=:skill");

        rankingQuery.setParameter("subject", subject);
        rankingQuery.setParameter("skill", skill);

        IntSummaryStatistics stats = rankingQuery.list().stream().collect(Collectors.summarizingInt(Ranking::getRanking));

        return (int) stats.getAverage();
    }

    @Override
    public void addRanking(String subject, String observer, String skill, int ranking) {

        try (Session session = SessionUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            addRanking(session, subject, observer, skill, ranking);
            tx.commit();
        }

    }

    public void addRanking(Session session, String subject, String observer, String skill, int ranking) {

        Person subjectPerson = savePerson(session, subject);
        Person observerPerson = savePerson(session, observer);
        Skill skillOfPerson = saveSkill(session, skill);

        Ranking ranking1 = new Ranking();
        ranking1.setObserver(observerPerson);
        ranking1.setRanking(ranking);
        ranking1.setSkill(skillOfPerson);
        ranking1.setSubject(subjectPerson);

        session.save(ranking1);

    }

    @Override
    public void updateRanking(String subject, String observer, String skill, int ranking) {

        try (Session session = SessionUtil.getSession()) {

            Transaction tx = session.beginTransaction();
            Ranking ranking1 = findRanking(session, subject, observer, skill);

            if (ranking1 == null) {
                addRanking(session, subject, observer, skill, ranking);
            } else {
                ranking1.setRanking(ranking);
            }

            tx.commit();
        }
    }


    @Override
    public void removeRanking(String subject, String observer, String skill) {

        try (Session session = SessionUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            removeRanking(session, subject, observer, skill);
            tx.commit();
        }
    }

    private void removeRanking(Session session, String subject, String observer, String skill) {
        Ranking ranking = findRanking(session, subject, observer, skill);
        if (ranking != null) {
            session.delete(ranking);
        }
    }

    @Override
    public Map<String, Double> findRankingsFor(String subject) {
        try (Session session = SessionUtil.getSession()) {
            return findRankingsFor(session, subject);
        }
    }

    private Map<String, Double> findRankingsFor(Session session, String subject) {
        Query<Ranking> rankingQuery = session.createQuery("from Ranking r where r.subject.name=:subject", Ranking.class);
        rankingQuery.setParameter("subject", subject);

        return rankingQuery.list().stream().collect(Collectors.groupingBy(ranking -> ranking.getSkill().getName(), Collectors.averagingInt(Ranking::getRanking)));
    }

    @Override
    public Person findBestPersonFor(String skill) {

        try (Session session = SessionUtil.getSession()) {
            return findBestPersonFor(session, skill);
        }
    }

    private Person findBestPersonFor(Session session, String skill) {

        Query<Ranking> rankingQuery = session.createQuery("from Ranking r where r.skill.name=:skill");
        rankingQuery.setParameter("skill", skill);

        Optional<Map.Entry<String, Double>> entryOptional = rankingQuery.list().stream()
                .collect(Collectors.groupingBy(ranking -> ranking.getSubject().getName(), Collectors.averagingInt(Ranking::getRanking)))
                .entrySet()
                .stream()
                .max(Comparator.comparing(e -> e.getValue()));

        return findPerson(session, (entryOptional.isPresent()) ? entryOptional.get().getKey() : null);
    }


    private Ranking findRanking(Session session, String subject, String observer, String skill) {

        Query<Ranking> rankingQuery = session.createQuery("from Ranking r where r.subject.name=:subject and r.observer.name=:observer and r.skill.name=:skill");
        rankingQuery.setParameter("subject", subject);
        rankingQuery.setParameter("observer", observer);
        rankingQuery.setParameter("skill", skill);

        return rankingQuery.uniqueResult();
    }


    private Person findPerson(Session session, String name) {
        Query<Person> personQuery = session.createQuery("from Person p where p.name=:name");
        personQuery.setParameter("name", name);
        return personQuery.uniqueResult();
    }


    private Skill findSkill(Session session, String name) {
        Query<Skill> skillQuery = session.createQuery("from Skill s where s.name=:name");
        skillQuery.setParameter("name", name);
        return skillQuery.uniqueResult();
    }

    private Person savePerson(Session session, String name) {

        Person person = findPerson(session, name);

        if (person == null) {
            person = new Person();
            person.setName(name);
            session.persist(person);
        }

        return person;
    }


    private Skill saveSkill(Session session, String name) {

        Skill skill = findSkill(session, name);

        if (skill == null) {
            skill = new Skill();
            skill.setName(name);
            session.persist(skill);
        }

        return skill;
    }

}
