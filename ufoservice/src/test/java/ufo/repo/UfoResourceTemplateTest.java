package ufo.repo;

import org.junit.Assert;
import org.junit.Test;
import ufo.util.Constants;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

public class UfoResourceTemplateTest {

    private UfoResourceTemplate ufoResourceTemplate;
    private final String MOCK_TEST_FILE_NAME = "ufo_awesome_test.tsv";

    @Test
    public void testResourceFileLocArgConstructor() throws URISyntaxException {
        ufoResourceTemplate = new UfoResourceTemplate(MOCK_TEST_FILE_NAME, Constants.ResourceFileType.CLASSPATH);
        Assert.assertEquals(Paths.get(ClassLoader.getSystemResource(MOCK_TEST_FILE_NAME).toURI()),
                ufoResourceTemplate.getTsvUfoDataFilePath());
    }

    @Test(expected = RuntimeException.class)
    public void testResourceFileLocArgConstructorWithException() throws URISyntaxException {
        ufoResourceTemplate = new UfoResourceTemplate("some file.tsv", Constants.ResourceFileType.CLASSPATH);
        Assert.assertEquals(Paths.get(ClassLoader.getSystemResource("some file.tsv").toURI()),
                ufoResourceTemplate.getTsvUfoDataFilePath());
    }

    @Test
    public void testFileLinesStream() throws IOException {
        ufoResourceTemplate = new UfoResourceTemplate(MOCK_TEST_FILE_NAME, Constants.ResourceFileType.CLASSPATH);
        Assert.assertTrue(ufoResourceTemplate.fileLinesStream().count() == 2);
    }

}

