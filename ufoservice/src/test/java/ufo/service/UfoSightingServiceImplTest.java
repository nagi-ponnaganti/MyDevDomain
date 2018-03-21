package ufo.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ufo.dto.UfoSighting;
import ufo.repo.UfoResourceTemplate;
import ufo.repo.UfoSightingRepositoryImpl;
import ufo.util.Constants;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static ufo.util.Constants.TSV_UFO_DATA_FILENAME;

public class UfoSightingServiceImplTest {

    // "tsv.file.loc" could be passed via vm options while running testcase or else testcase look for file on classpath
    private UfoResourceTemplate template = (System.getProperty("tsv.file.loc") == null) ?
            new UfoResourceTemplate(TSV_UFO_DATA_FILENAME, Constants.ResourceFileType.CLASSPATH) :
            new UfoResourceTemplate(System.getProperty("tsv.file.loc"), Constants.ResourceFileType.FILE_SYSTEM);

    // TODO Spring Framework could be used to dependency injection
    private UfoSightingServiceImpl ufoSightingService =
            new UfoSightingServiceImpl(
                    new UfoSightingRepositoryImpl(template));

    @Test
    public void testGetAllSightings() {
        Assert.assertEquals("61391 records Expected", 61391, ufoSightingService.getAllSightings().size());
    }

    @Test
    public void testSearchForYearAndMonth() {
        int year = 1995, month = 10;
        List<UfoSighting> ufos = ufoSightingService.search(year, month);
        Assert.assertEquals("107 records Expected", 107, ufos.size());
    }

    @Mock
    private UfoSightingRepositoryImpl ufoSightingRepositoryMock;
    @InjectMocks
    private UfoSightingServiceImpl ufoSightingServiceMock;


    @Test
    public void testGetAllSightingsWithMock() {
        Assert.assertTrue(ufoSightingServiceMock.getAllSightings().size() == 3);
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        UfoSighting valid1 = new UfoSighting("", "", "", "", "", "");
        UfoSighting valid2 = new UfoSighting("", "", "", "", "", "");
        UfoSighting valid3 = new UfoSighting("", "", "", "", "", "");

        List<UfoSighting> results = Arrays.asList(valid1, valid2, valid3);
        when(ufoSightingRepositoryMock.getAllSightingsResults()).thenReturn(results);
    }

}
