package com.example.spring.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class CsvDataService {

    private final String covid_data =
            "https://raw.githubusercontent.com/CSSEGISandData/" +
                    "COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/" +
                    "time_series_covid19_confirmed_global.csv";


    public String getData(){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(covid_data)).build();
        String ret = "No Data";
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            StringReader in = new StringReader(response.body());
            Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(in).getRecords();
            for (CSVRecord record : records) {
                String country = record.get(1);
                if(country.startsWith("Taiwan"))
                    ret = "Taiwan current case count: " + record.get(record.size()-1);
            }
        }
        catch (Exception e){
            return "Has Exception in HTTP send \n" + e.toString();
        }
        return ret;
    }
}
