############################################################################

UPDATE ON 21-Mar-2018

# Instructions to Run the TestCase UfoSightingServiceImplTest:

1. The Testcase is Under the package test/java/ufo/service
2. The Testcase Requires Below two steps to Run
   2a)
   - Either Pass the VM option -Dtsv.file.loc="$filePath/ufo_awesome.tsv" where tsv file locates
   OR
   - Add the tsv file to test resources which is under test/resources

   2b) Make sure test/resources is marked as test resources directory


# Related to Project "Your comments on what you would change on the interface and DTO"

1. On DTO we need an unique identifier for each record
2. On DTO we need an flag to represent if the data used to create dto is consistent or not
3. On DTO we should represent properties in correct datatype like date, number etc
4. On Interface for searching it good to pass the Object which contains all the criteria info, so that multiple
    scenarios can be covered, atleast the date parameter instead of ints


############################################################################


# UFO Sightings Service

We have a huge TSV file (included in the project resources folder) and we need to consume the information inside it.
We have provided a simple interface (UfoSightingService) and would like you provide an implementation for it.
  


### First Objective
- Write an implementation of the UfoSightingService interface that fulfill the requirements in the javadocs present on it.
- Searching the sighting happened on October 1995 should return 107 sightings
- Searching all the sightings should return 61391 results


### Second objective
Optimize it to be as fast as it can be

### Constraints
- UfoSighting DTO and UfoSightingService interface cannot be changed
- TSV File cannot be altered
- Usage of multithreading is not allowed

### What are we looking for

- Clean code
- Unit testing
- Your comments on what you would change on the interface and DTO


### Suggestions
Keep it simple
You can use any Java version

You can use any library available on internet but none should be necessary




### How to submit the code

Via mail but make sure to

Clean the project (don't submit the target folder)

Remove the tsv file (Limited inbox, sorry)




