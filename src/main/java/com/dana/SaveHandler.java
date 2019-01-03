package com.dana;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.io.*;

public class SaveHandler {

    public void openFile() {
        Path path = FileSystems.getDefault().getPath("main","java","com", "dana", "App.java");


        Charset charset = Charset.forName("UTF-8");
        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println("ok");
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }


}

//TODO nacteni souboru - zatim nefunguje, davam spatne cestu - chci vyresit fileChooserem
