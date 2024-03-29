package com.example.converter;

import org.json.JSONObject;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.text.ParseException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Converter {

    private static final SimpleDateFormat DSV_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat JSONL_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");


    public static void convertDsvToJSONL(String inputFile, String outputFile) throws IOException {

        try {
            Reader reader = Files.newBufferedReader(Paths.get(inputFile));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader());

            FileWriter fileWriter = new FileWriter(outputFile);

            Stream<CSVRecord> csvRecordStream = StreamSupport.stream(csvParser.spliterator(), false);

            csvRecordStream.forEach(record -> {
                JSONObject jsonRecord = convertRecordToJSON(record);

                try {
                    fileWriter.write(jsonRecord.toString() + "\n");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static JSONObject convertRecordToJSON(CSVRecord record) {
        JSONObject jsonObject = new JSONObject();
        for (String key : record.toMap().keySet()) {
            String value = record.get(key);
            if ("dateOfBirth".equals(key)) {
                try {
                    Date date = DSV_DATE_FORMAT.parse(value);
                    jsonObject.put(key, JSONL_DATE_FORMAT.format(date));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else if ("salary".equals(key)) {
                jsonObject.put(key, Integer.parseInt(value));
            } else {
                jsonObject.put(key, value);
            }
        }
        return jsonObject;
    }

}