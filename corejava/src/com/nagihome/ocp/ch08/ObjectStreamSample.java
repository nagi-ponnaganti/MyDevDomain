package com.nagihome.ocp.ch08;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectStreamSample {

    private static void addAnimalsToFile(List<Animal> animals, File dest) {

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dest))) {

            animals.forEach(o -> {
                try {
                    out.writeObject(o);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

//            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            // File end reached
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printAnimalsFromSource(File source) {

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(source))) {

            while(true) {
                Object object = in.readObject();
                if(object instanceof Animal)
                    System.out.println((Animal)object);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            // File end reached
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Animal> animals = new ArrayList<Animal>();
        animals.add(new Animal("Tommy Tiger", 5, 'T'));
        animals.add(new Animal("Peter Penguin", 8, 'P'));
        File dataFile = new File("animal.data");
        if (!dataFile.exists()) dataFile.createNewFile();
        addAnimalsToFile(animals, dataFile);
        printAnimalsFromSource(dataFile);
    }


}
