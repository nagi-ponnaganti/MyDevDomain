package com.nagihome.ocp.ch08;

import java.io.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CopyBufferedSampleFile {

    public static void main(String[] args) throws IOException {
        File source = new File("inputfile.txt");
        File destination = new File("outputfile.txt");
        if (!source.exists()) source.createNewFile();
        if (!destination.exists()) destination.createNewFile();
        copy(source, destination);
    }


    private static void copy(File source, File destination) {

        try (InputStream in = new BufferedInputStream(new FileInputStream(source));
             OutputStream out = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[1024];
            int lengthRead;
            while ((lengthRead = in.read(buffer)) > 0){
                IntStream.range(0, buffer.length).forEach(i -> System.out.print(buffer[i] + " "));
                out.write(buffer, 0, lengthRead);
                out.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
