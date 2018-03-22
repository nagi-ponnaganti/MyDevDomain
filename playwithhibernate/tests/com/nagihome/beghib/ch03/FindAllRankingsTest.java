package com.nagihome.beghib.ch03;

import org.testng.annotations.Test;

import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class FindAllRankingsTest {

    RankingService service = new HibernateRankingService();

    @Test
    public void findAllRankingsEmptySet() {
        assertEquals(service.getRankingFor("Nobody", "Java"), 0);
        assertEquals(service.getRankingFor("Nobody", "Python"), 0);
        Map<String, Double> rankings = service.findRankingsFor("Nobody");

        // make sure our dataset size is what we expect: empty
        assertEquals(rankings.size(), 0);
    }

    @Test
    public void findAllRankings() {
        assertEquals(service.getRankingFor("Somebody", "Java"), 0);
        assertEquals(service.getRankingFor("Somebody", "Python"), 0);
        service.addRanking("Somebody", "Nobody", "Java", 9);
        service.addRanking("Somebody", "Nobody", "Java", 8);
        service.addRanking("Somebody", "Nobody", "Python", 7);
        service.addRanking("Somebody", "Nobody", "Python", 5);
        Map<String, Double> rankings = service.findRankingsFor("Somebody");

        assertEquals(rankings.size(), 2);
        assertNotNull(rankings.get("Java"));
        assertEquals(rankings.get("Java"), new Double(8.5));
        assertNotNull(rankings.get("Python"));
        assertEquals(rankings.get("Python"), new Double(6));

    }

}
