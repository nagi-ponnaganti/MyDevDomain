package com.nagihome.ocp.ch08;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyTextFileSample {


    private static List<String> readData(File source) {

        List<String> data = new ArrayList<>();

        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            String s;
            while ((s = in.readLine()) != null) {
                data.add(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    private static void writeData(File destination, List<String> data) {

        try (BufferedWriter out = new BufferedWriter(new FileWriter(destination))) {
            data.forEach(s -> {
                try {
                    out.write(s);
                    out.newLine();
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException {
        File source = new File("inputfile.txt");
        File destination = new File("outputfile.txt");
        if (!source.exists()) source.createNewFile();
        if (!destination.exists()) destination.createNewFile();

        writeData(destination, readData(source));
    }

}
