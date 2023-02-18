package com.foxminded.services;

import java.util.List;

import com.foxminded.models.ResultLap;

public class Formatter {
    public void format(List<ResultLap> lapsResults) {
        lapsResults.stream().forEach(System.out::println);
    }
}
