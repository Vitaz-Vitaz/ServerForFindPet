package com.koribsky.service;

import liquibase.util.csv.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class OpenCsvWriterExample {
    public static void main(String[] args) throws IOException {

        List csvData = createCsvDataSimple();

        // default all fields are enclosed in double quotes
        // default separator is a comma

        try (CSVWriter writer = new CSVWriter(new FileWriter("C:\\Users\\Admin\\Downloads\\LibrarySpring-Module-4\\ServerForFindPet\\src\\main\\resources\\db.changelog\\data\\csv\\2022-04-30--0001-point-data.csv"))) {
            writer.writeAll(csvData);
        }

    }
    private static List createCsvDataSimple() {
        String[] header = {"id", "description", "photo", "X", "Y"};
        String[] record1 = {"1", "first ", "cat", "1", "2"};
        String[] record2 = {"2", "second ", "dog", "2", "1"};

        List list = new ArrayList<>();
        list.add(header);
        list.add(record1);
        list.add(record2);

        return list;
    }
}
