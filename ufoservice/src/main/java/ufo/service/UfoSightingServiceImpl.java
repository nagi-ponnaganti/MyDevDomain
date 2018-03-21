package ufo.service;

import ufo.dto.UfoSighting;
import ufo.repo.UfoSightingRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class UfoSightingServiceImpl implements UfoSightingService {

    private final static Logger LOGGER = Logger.getLogger(UfoSightingServiceImpl.class.getName());

    private UfoSightingRepository ufoSightingRepository;

    /**
     * Returns all the sightings in the tsv file.
     */
    public List<UfoSighting> getAllSightings() {
        return ufoSightingRepository.getAllSightingsResults();
    }

    /**
     * Search for sightings happened in the specified year and month;
     *
     * @param yearSeen  The year when the sighting happened
     * @param monthSeen The month when the sightings happened
     */
    public List<UfoSighting> search(int yearSeen, int monthSeen) {
        return ufoSightingRepository.search(yearSeen, monthSeen);
    }

    /**
     * Requires repo to initialize
     *
     * @param ufoSightingRepository
     */
    public UfoSightingServiceImpl(UfoSightingRepository ufoSightingRepository) {
        this.ufoSightingRepository = ufoSightingRepository;
    }
}
