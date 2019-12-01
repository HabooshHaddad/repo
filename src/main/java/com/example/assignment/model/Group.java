package com.example.assignment.model;

import lombok.*;

import java.util.List;

@Data
public class Group {
    public String name;
    public String featuredKeywords;
    public String neglectedKeywords;
    public List<String> groupItems;
}
