package ufo.repo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ufo.dto.UfoSighting;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

public class UfoSightingRepositoryImplTest {

    @Mock
    private UfoResourceTemplate resourceTemplate;
    @InjectMocks
    private UfoSightingRepositoryImpl ufoSightingRepository;

    private String validRecord1 = "20180318\t20180309\tLondon\ttriangle\t1hr\tA Man Named Davi\t this is extra break";
    private String validRecord2 = "20180317\t20180310\tLondon\trectangle\t59min\tA Women named Samy";
    private String validRecord3 = "20180316\t20180311\tLondon\tsquare\t20sec\tA Man Named Pete";
    private String invalidRecord1 = "20180315\t20180312\tLondon\tcircle\t1sec";
    private String invalidRecord2 = "20180314\t20180313\tLondon\trhombus\tA Child Name Martin";

    private Stream<String> dataStream = Stream.of(validRecord1, validRecord2, validRecord3, invalidRecord1, invalidRecord2);


    @Test
    public void testGetAllSightings() {
        List<UfoSighting> ufoSightingResults = ufoSightingRepository.getAllSightingsResults();
        Assert.assertTrue(ufoSightingResults.size() == 3);

        Assert.assertTrue(ufoSightingResults.stream().filter(
                v -> (v.getDateSeen().equals("20180318")
                        && v.getDateReported().equals("20180309")
                        && v.getDescription().equals("A Man Named Davi this is extra break")
                        && v.getDuration().equals("1hr")
                        && v.getPlaceSeen().equals("London")
                        && v.getShape().equals("triangle"))).count() == 1);

    }


    @Test(expected = RuntimeException.class)
    public void testExceptionWhileGetAllSightings() throws IOException {
        when(resourceTemplate.fileLinesStream()).thenThrow(new Exception("something went wrong"));

        List<UfoSighting> ufoSightingResults = ufoSightingRepository.getAllSightingsResults();
        Assert.assertTrue(ufoSightingResults.size() == 3);

        Assert.assertTrue(ufoSightingResults.stream().filter(
                v -> (v.getDateSeen().equals("20180318")
                        && v.getDateReported().equals("20180309")
                        && v.getDescription().equals("A Man Named Davi")
                        && v.getDuration().equals("1hr")
                        && v.getPlaceSeen().equals("London")
                        && v.getShape().equals("triangle"))).count() == 1);

    }


    @Before
    public void init() throws IOException {
        MockitoAnnotations.initMocks(this);
        when(resourceTemplate.fileLinesStream()).thenReturn(dataStream);
    }

}
