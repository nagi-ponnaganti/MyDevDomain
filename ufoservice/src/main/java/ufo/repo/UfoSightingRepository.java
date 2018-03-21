package ufo.repo;

import ufo.dto.UfoSighting;

import java.util.List;

/**
 * UfoSightingRepository : This Interface should provide the methods to perform
 * Data Manipulation operations on the data available in data store
 */

public interface UfoSightingRepository {

    /**
     * This Method Fetches the Data from the Data store (TSV File)
     *
     * @return List<UfoSighting> contains all records of TSV File
     */
    List<UfoSighting> getAllSightingsResults();


    /**
     * Search for sightings happened in the specified year and month;
     *
     * @param yearSeen  The year when the sighting happened
     * @param monthSeen The month when the sightings happened
     */
    List<UfoSighting> search(int yearSeen, int monthSeen);

}
