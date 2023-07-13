package com.epam.mjc.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String name = null;
        int age = 0;
        String email = null;
        long phone = 0L;

        try {
            String data = Files.readString(file.toPath());
            String[] lines = data.split(System.lineSeparator());

            for (String line : lines) {
                if (line.startsWith("Name: ")) {
                    name = line.substring("Name: ".length());
                } else if (line.startsWith("Age: ")) {
                    age = Integer.parseInt(line.substring("Age: ".length()));
                } else if (line.startsWith("Email: ")) {
                    email = line.substring("Email: ".length());
                } else if (line.startsWith("Phone: ")) {
                    phone = Long.parseLong(line.substring("Phone: ".length()));
                }
            }

        } catch (IOException ex){
            ex.printStackTrace();
        }
        return new Profile(name, age, email, phone);
    }
}
