package com.nagihome.beghib.ch03;

import java.util.Map;

public interface RankingService {

    int getRankingFor(String subject, String skill);

    void addRanking(String subject, String observer, String skill, int ranking);

    void updateRanking(String subject, String observer, String skill, int ranking);

    void removeRanking(String subject, String observer, String skill);

    Map<String, Double> findRankingsFor(String subject);

    Person findBestPersonFor(String skill);

}
