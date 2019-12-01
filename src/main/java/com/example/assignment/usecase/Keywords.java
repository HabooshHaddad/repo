package com.example.assignment.usecase;

import java.util.ArrayList;
import java.util.List;

public class Keywords {

    public static List<String> neglectedKeywords = new ArrayList<>();
    public static List<String> featuredKeywords = new ArrayList<>();

     public static void initKeywordsLists() {
        neglectedKeywords.add("bed");
        neglectedKeywords.add("room");
        neglectedKeywords.add("standard");
        neglectedKeywords.add("classic");

        featuredKeywords.add("king bed");
        featuredKeywords.add("single bed");
        featuredKeywords.add("sea view");
        featuredKeywords.add("city view");
    }
}
