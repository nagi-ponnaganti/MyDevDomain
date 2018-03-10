package com.nagihome.springboot.hazelcast.ch02;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.query.*;

import java.util.Collection;

public class SearchingAndIndexing {

    public static void main(String[] args) {

        HazelcastInstance hz = Hazelcast.newHazelcastInstance();
        IMap<String, City> capitals = hz.getMap("capitals");
        capitals.addIndex("name", false);
        capitals.addIndex("population", true);


        capitals.put("GB",
                new City("London", "GB", 8174100));

        capitals.put("FR",
                new City("Paris", "FR", 2268265));

        capitals.put("US",
                new City("Washington DC", "US", 601723));

        capitals.put("AU",
                new City("Canberra", "AU", 354644));

        Collection<City> possibleLondon = capitals.values(new SqlPredicate(" name = 'London' "));
        System.out.println("possibleLondon: " + possibleLondon);

        Collection<City> popIndex = capitals.values(new SqlPredicate(" population >= 354644 and population < 2268265"));
        System.out.println("popIndex: " + popIndex);

        EntryObject eo = new PredicateBuilder().getEntryObject();
        Collection<City> parisCity = capitals.values(eo.get("name").equal("Paris"));
        System.out.println("parisCity: " + parisCity);

        Predicate largeCityPredicate = Predicates.greaterThan("population", 1000000);
        PagingPredicate pagingPredicate = new PagingPredicate(largeCityPredicate, 1);

        System.err.println(capitals.values(pagingPredicate));
        pagingPredicate.nextPage();
        System.err.println(capitals.values(pagingPredicate));

    }

}
