package com.nagihome.ocp.ch08;

import java.io.*;

public class CopySampleFile {

    private static void copy(File inputFile, File outputFile) {

        try (InputStream in = new FileInputStream(inputFile);
             OutputStream out = new FileOutputStream(outputFile)) {

            int b;

            while ((b = in.read()) != -1) {
                System.out.println("byte: " + b);
                out.write(b);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        File source = new File("inputfile.txt");
        File destination = new File("outputfile.txt");
        if (!source.exists()) source.createNewFile();
        if (!destination.exists()) destination.createNewFile();
        copy(source, destination);
    }

}
