package com.example.assignment.controller;

import com.example.assignment.model.Group;
import com.example.assignment.usecase.GroupUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/grouping")
public class GroupingController {
    public GroupingController() {
    }

    @PostMapping()
    public List<Group> groupItems(@RequestBody List<String> items) {
        GroupUseCase useCase = new GroupUseCase();
        return useCase.process(items);
    }
}
