package com.example.assignment.usecase;

import com.example.assignment.model.Group;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GroupUseCase {

    List<Group> groups;

    public List<Group> process(List<String> items) {
        Keywords.initKeywordsLists();
        groups = new ArrayList<>();
        items.forEach(item -> groups.addAll(processItem(item)));

        return groups;
    }

    List<Group> processItem(String item) {
        String[] strings = item.toLowerCase().split(",");
        List<String> itemStrings = new ArrayList<>();

        itemStrings.addAll(Arrays.asList(strings));

        List<String> neglectedStrings = itemStrings.stream()
                .filter(i -> Keywords.neglectedKeywords.contains(i))
                .collect(Collectors.toList());

        List<String> featuredStrings = itemStrings.stream().
                filter(i -> Keywords.featuredKeywords.contains(i))
                .collect(Collectors.toList());

        itemStrings.removeAll(featuredStrings);
        itemStrings.removeAll(neglectedStrings);

        List<Group> groups = new ArrayList<>();
        Group group = createGroup(itemStrings.toString(), neglectedStrings, featuredStrings, strings);
        groups.add(group);

        return groups;
    }

    private Group createGroup(String item, List<String> neglectedStrings, List<String> featuredStrings, String[] strings) {
        Group group = new Group();
        group.setName(getReplacedString(item));
        group.setNeglectedKeywords(getReplacedString(neglectedStrings.toString()));
        group.setFeaturedKeywords(getReplacedString(featuredStrings.toString()));
        group.setGroupItems(Arrays.asList(strings));
        return group;
    }

    private String getReplacedString(String item) {
        return item.replaceAll("\\[|\\]", "").replaceAll(",", "");
    }
}
