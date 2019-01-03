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
    String content;

    

    public void openFile(Path file) throws IOException {

        Charset charset = Charset.forName("UTF-8");
        content = new String(Files.readAllBytes(file), charset);
    }

    public void findTag(String tagToFind) throws IOException {
        Pattern namePattern = Pattern.compile("name");
        Matcher matcher = namePattern.matcher("kde hledat");

        int letter;
        do {
            letter = (char) reader.read();
        } while (letter != '<');

        String tag = "";
        do {
            letter = (char) reader.read();
            tag += String.valueOf(letter);
        } while (letter != '>');


    }

}
