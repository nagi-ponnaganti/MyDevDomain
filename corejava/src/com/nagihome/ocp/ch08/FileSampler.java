package com.nagihome.ocp.ch08;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

public class FileSampler {

    public static void main(String[] args) throws IOException {
        File file = new File("sample.txt");
        System.out.println("File Exists: " + file.exists());
        file.createNewFile();
        System.out.println(System.getProperty("file.seperator"));
        System.out.println(File.separator);

        String projectPath = "/home/nagi/IdeaProjects/MyDevDomain/corejava";
        File proPathFile = new File(projectPath);
        System.out.println("Exists: " + proPathFile.exists());
        System.out.println("Get Name: " + proPathFile.getName());
        System.out.println("Get Absolute Path: " + proPathFile.getAbsolutePath());
        System.out.println("is Directory: " + proPathFile.isDirectory());
        System.out.println("is File: " + proPathFile.isFile());
        System.out.println("Length: " + file.length());
        System.out.println("lastModified: " + file.lastModified());
        File newFile = new File("sample1.txt");
        newFile.createNewFile();
        System.out.println("rename to: " + file.renameTo(newFile));
        System.out.println("delete file: " + newFile.delete());
        System.out.println("List Files: " + proPathFile.listFiles());
        System.out.println("get Parent: " + proPathFile.getParent());

        Stream.of(proPathFile.listFiles()).map(f -> f.getName()).forEach(System.out::println);
    }
}
