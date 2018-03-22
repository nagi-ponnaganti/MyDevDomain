package com.nagihome.beghib.ch03;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AddRankingTest {

    private RankingService service = new HibernateRankingService();

    @Test
    public void testAddRanking() {
        service.addRanking("J. C. Smell", "Drew Lombardo", "Mule", 8);
        assertEquals(service.getRankingFor("J. C. Smell", "Mule"), 8);
    }

}
