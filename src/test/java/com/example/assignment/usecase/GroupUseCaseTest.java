package com.example.assignment.usecase;

import com.example.assignment.model.Group;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GroupUseCaseTest {

    @Test
    void givenListOfItemsWhenProcessListGroups() {
        List<String> items = new ArrayList<>();
        items.add("room,standard,sea view");
        items.add("CLASSIC,Room,City View");
        items.add("junior,suite,sea View");
        items.add("suite,junior,room,city view");

        GroupUseCase useCase = new GroupUseCase();
        List<Group> actualGroups = useCase.process(items);
        assertEquals("room standard",actualGroups.get(0).getName());
        assertEquals("sea view",actualGroups.get(0).getFeaturedKeywords());
    }


}