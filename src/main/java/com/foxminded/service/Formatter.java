package com.foxminded.service;

import java.util.List;

import com.foxminded.model.ResultLap;

public class Formatter {
    public void format(List<ResultLap> lapsResults) {
        lapsResults.stream().forEach(System.out::println);
    }
}
