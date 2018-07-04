package com.example.wordsearch;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Util {

    static int performSearch(String siteName, String searchedWord){
        System.out.println("Work in progress...");
        int wordNum = 0;

        Connection connect = Jsoup.connect(siteName);

        try{
            Document document = connect.get();
            String text = document.body().text();

            Elements links = document.select("html");

            for (Element elem : links) {
                BufferedReader reader = new BufferedReader(new InputStreamReader
                        (new ByteArrayInputStream(elem.text().getBytes())));

            String line;
                while ((line = reader.readLine()) != null) {
                    String[] words = line.split(" ");
                    for (String word : words) {
                        if(word.equals(searchedWord)){
                            wordNum++;
                        }
                    }
                }
                reader.close();
            }

        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Finished. Count: " + wordNum);
        return wordNum;
    }
}