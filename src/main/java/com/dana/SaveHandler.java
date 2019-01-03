package com.dana;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SaveHandler {

    BufferedReader reader;
    Map<String, String> xmlToJavaTagConvertor;



    public void openFile(Path file) {

        Charset charset = Charset.forName("UTF-8");
        try {
            reader = Files.newBufferedReader(file, charset);

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }







        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            int test = reader.read();
            char test2 = (char) test;
            System.out.println(test);
            System.out.println(test2);
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

    public TagToken findTag(String) throws IOException {
        Pattern pattern = Pattern.compile("expression");
        Matcher matcher = pattern.matcher("kde hledat");

        int letter;
        do {
            letter = (char) reader.read();
        } while (letter != '<');

        String tag = "";
        do {
            letter = (char) reader.read();
            tag += String.valueOf(letter);
        } while (letter != '>');

        return tag;

    }

}
