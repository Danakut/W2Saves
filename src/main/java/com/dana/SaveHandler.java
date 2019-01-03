package com.dana;

import com.dana.entities.Ranger;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Handler;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SaveHandler {

    BufferedReader reader;
    Map<String, String> xmlToJavaTagConvertor;
    String content;
    public List<String> persons;

    public SaveHandler() {

    }

    public void init() throws Exception {
        persons = findPersons();
    }



    public void openFile(Path file) throws IOException {

        Charset charset = Charset.forName("UTF-8");
        content = new String(Files.readAllBytes(file), charset);
    }

    private List<String> findPersons() throws Exception {
        List<String> list = new ArrayList<>();

        Pattern pattern = Pattern.compile("<name>");
        Matcher matcher = pattern.matcher(content);
        int startIndex;
        int endIndex;
        if (matcher.find()) {
            startIndex = matcher.start();
        } else {
            throw new Exception("No persons found in the savefile.");
        }

        //splits the main string into lesser Strings containing just one person each
        while (matcher.find()) {
            endIndex = matcher.start();
            String newPerson = content.substring(startIndex, endIndex);
            list.add(newPerson);
            startIndex = endIndex;
        }

        //the last person
        String newPerson = content.substring(startIndex);
        list.add(newPerson);
        return list;
    }

    public String testThis() {
        String toTest = persons.get(0).substring(0,4);
        return toTest;
    }

}
