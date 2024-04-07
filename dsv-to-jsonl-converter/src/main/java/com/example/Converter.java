package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Converter {

    public static void convertDSVtoJsonl(String inputFile, String outputFile, String delimiter) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             FileWriter writer = new FileWriter(outputFile)) {

            String[] headers = reader.readLine().split(delimiter);

            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(delimiter);

                // Ensure the number of columns matches the number of headers
                if (values.length != headers.length) {
                    System.out.println("Warning: Number of columns in the row does not match the number of headers. Skipping row.");
                    continue; // Skip this row
                }

                StringBuilder json = new StringBuilder("{");
                for (int j = 0; j < headers.length; j++) {
                    String header = headers[j];
                    String value = values[j];

                    // Handle special case for dateOfBirth field
                    if (header.equalsIgnoreCase("dateOfBirth")) {
                        // Format date to "YYYY-MM-dd" format
                        value = formatDate(value);
                    }

                    // Handle special case for salary field
                    if (header.equalsIgnoreCase("salary")) {
                        // Parse salary as integer
                        value = value.replaceAll("[^\\d]", "");
                    }

                    json.append("\"").append(header).append("\":\"").append(value).append("\",");
                }
                json.deleteCharAt(json.length() - 1);
                json.append("}\n");
                writer.write(json.toString());
            }
        }
    }

    // Helper method to format date to "YYYY-MM-dd" format
// Helper method to format date to "YYYY-MM-dd" format
    private static String formatDate(String date) {
        // Add your logic here to parse different date formats and return the date in "YYYY-MM-dd" format
        // For simplicity, assuming date format is "dd-MM-yyyy" for now
        SimpleDateFormat[] dateFormats = {
                new SimpleDateFormat("dd-MM-yyyy"),
                new SimpleDateFormat("yyyy-MM-dd"),
                new SimpleDateFormat("MM-dd-yyyy"),
                new SimpleDateFormat("yyyy/MM/dd")
        };

        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (SimpleDateFormat inputFormat : dateFormats) {
            try {
                Date parsedDate = inputFormat.parse(date);
                return outputFormat.format(parsedDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        // If parsing fails for all formats, return original date
        return date;
    }

}
