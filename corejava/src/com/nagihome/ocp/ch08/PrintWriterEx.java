package com.nagihome.ocp.ch08;

import java.io.*;

public class PrintWriterEx {

    public static void main(String[] args) throws IOException {

        File file  = new File("samplefile.txt");
        if(!file.exists()) file.createNewFile();

        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
            pw.print("Today's whether is: ");
            pw.println("sunny");
            pw.printf("Todays wether is good in %s city", "London");
        }

    }

}
