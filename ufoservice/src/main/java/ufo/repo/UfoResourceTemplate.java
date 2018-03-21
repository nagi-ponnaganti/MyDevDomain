package ufo.repo;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static ufo.util.Constants.ResourceFileType;

/**
 * This class is used to access the UFO data source as of now in our case it is TSV
 * It always good to decouple the plumbing code from business logic
 */
public class UfoResourceTemplate {

    // Its better to handle Exception while Application Process Starting-Up rather than at Runtime
    // so initializing the path at start-up
    private Path tsvUfoDataFilePath;


    /**
     * This method is used to return the Stream of lines from the File
     *
     * @return
     * @throws IOException
     */
    public Stream<String> fileLinesStream() throws IOException {
        return Files.lines(tsvUfoDataFilePath);
    }

    /**
     * Constructing the Path Of the File
     *
     * @param resourceFileLocation : Location of the file
     * @param type : ResourceFileType is mainly to indicate whether to load the tsv file from classpath or filesystem
     */
    public UfoResourceTemplate(String resourceFileLocation, ResourceFileType type) {

        switch (type) {

            case CLASSPATH:
                try {
                    tsvUfoDataFilePath = Paths.get(ClassLoader.getSystemResource(resourceFileLocation).toURI());
                } catch (URISyntaxException e) {
                    throw new RuntimeException("Exception While Creating Path For TSV_UFO_DATA_FILENAME");
                }
                break;

            case FILE_SYSTEM:
                tsvUfoDataFilePath = Paths.get(resourceFileLocation);
                break;

            default:
                throw new RuntimeException("Not Supported");
        }

    }

    /**
     * Get the File Path Used
     * @return the Path of the File
     */
    public Path getTsvUfoDataFilePath() {
        return tsvUfoDataFilePath;
    }


}
