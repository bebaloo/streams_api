package com.foxminded;

import com.foxminded.service.Formatter;
import com.foxminded.service.ResultGenerator;

public class Main {
    public static void main(String[] args) {
        new Formatter().format(new ResultGenerator().generate());
    }
}
