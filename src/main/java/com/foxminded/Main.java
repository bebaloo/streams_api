package com.foxminded;

import com.foxminded.services.Formatter;
import com.foxminded.services.ResultGenerator;

public class Main {
    public static void main(String[] args) {
        new Formatter().format(new ResultGenerator().generate());
    } 
}
