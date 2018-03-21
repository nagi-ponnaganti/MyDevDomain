package ufo.repo;

import ufo.dto.UfoSighting;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.stream.Stream;

import static ufo.util.Constants.TSV_DATA_COLUMN_LENGTH;
import static ufo.util.Constants.TSV_DELIMITER;

/**
 * Provides the Implementation for UfoSightingRepository Interface, Mainly to fetch data from data store
 * Data Manipulation operations on the data available in data store
 */
public class UfoSightingRepositoryImpl implements UfoSightingRepository {

    private final static Logger LOGGER = Logger.getLogger(UfoSightingRepositoryImpl.class.getName());

    // This class provides the way to connect to a file and read lines
    private UfoResourceTemplate resourceTemplate;

    /**
     * This Method:
     * 1. Retrieves the Stream of data for the Data store (TSV File)
     * 2. Partition the Data to Valid And Invalid Records Based on Criteria
     * 3. Add to final results
     *
     * @return Return the List  which contains Valid, Invalid Data
     */
    public List<UfoSighting> getAllSightingsResults() {

        List<UfoSighting> finalResults = new ArrayList<>();

        Predicate<String[]> filter = s -> s.length >= TSV_DATA_COLUMN_LENGTH;

        try (Stream<String> stream = resourceTemplate.fileLinesStream()) {

            mapDataStoreStreamToUfoSightingUsingCriteria(stream, filter, finalResults);

            LOGGER.info("Final UFO Results Size: " + finalResults.size());

        } catch (Exception e) {
            throw new RuntimeException("Exception While Processing Data From TSV File", e);
        }

        return finalResults;
    }

    /**
     * Search the results from the file
     *
     * @param yearSeen  The year when the sighting happened
     * @param monthSeen The month when the sightings happened
     * @return
     */
    @Override
    public List<UfoSighting> search(int yearSeen, int monthSeen) {
        List<UfoSighting> finalResults = new ArrayList<>();

        String dateUsed = LocalDate.of(yearSeen, monthSeen, 1).format(DateTimeFormatter.ofPattern("yyyyMM"));
        LOGGER.info("Date Using to Search: " + dateUsed);

        Predicate<String[]> filter = s -> s.length >= TSV_DATA_COLUMN_LENGTH && s[0].startsWith(dateUsed);

        try (Stream<String> stream = resourceTemplate.fileLinesStream()) {

            mapDataStoreStreamToUfoSightingUsingCriteria(stream, filter, finalResults);

            LOGGER.info("Final Search UFO Results Size: " + finalResults.size());

        } catch (Exception e) {
            throw new RuntimeException("Exception While Processing Data From TSV File", e);
        }

        return finalResults;
    }

    /**
     * Maps the Stream to UFO sighting Objects
     *
     * @param stream       Stream of lines from the file
     * @param filter       filter the data based on criteria
     * @param finalResults final results added here
     */
    private void mapDataStoreStreamToUfoSightingUsingCriteria(Stream<String> stream, Predicate<String[]> filter, List<UfoSighting> finalResults) {
        stream.map(s -> s.split(TSV_DELIMITER))
                .peek(this::printInvalidData)
                .filter(filter)
                .map(this::ufoSightingMapperForValidData)
                .forEach(finalResults::add);
    }


    /**
     * ufoSightingMapper is a Method which maps the TSV record to Java Object
     * This Method is used as a part of collection mapping
     */
    // Could be Replaced with External Libraries like uniVocity-parsers, csv parsers which maps Strings to Java Objects
    private UfoSighting ufoSightingMapperForValidData(String[] values) {

        int index = 0;

        if (values.length == TSV_DATA_COLUMN_LENGTH) {

            return new UfoSighting(values[index++], values[index++], values[index++], values[index++], values[index++], values[index++]);

        } else if (values.length > TSV_DATA_COLUMN_LENGTH) {

            String dateSeen = values[index++];
            String dateReported = values[index++];
            String placeSeen = values[index++];
            String shape = values[index++];
            String duration = values[index++];
            StringBuilder description = new StringBuilder("");

            while (index < values.length) {
                description.append(values[index++]);
            }

            return new UfoSighting(dateSeen, dateReported, placeSeen, shape, duration, description.toString());

        } else {
            return new UfoSighting(null, null, null, null, null, null);
        }
    }

    /**
     * print the record whose data is invalid to convert to UFO sighting
     *
     * @param record String array with all Strings in line
     */
    private void printInvalidData(String[] record) {
        if (record.length < TSV_DATA_COLUMN_LENGTH)
            LOGGER.info("Invalid Data can't be converted to UFO: " + Arrays.toString(record));
    }

    /**
     * Constructor requires the template to initialise
     *
     * @param resourceTemplate
     */
    public UfoSightingRepositoryImpl(UfoResourceTemplate resourceTemplate) {
        this.resourceTemplate = resourceTemplate;
    }

}
