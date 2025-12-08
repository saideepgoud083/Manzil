package com.example.Manzil.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class CoordinateService {

    private static final String API_KEY = "pk.af52375b8c5aef2277c3e8507fd12281";

    public double[] getCoordinates(String location) {
        try {
            String encodedLocation = URLEncoder.encode(location, StandardCharsets.UTF_8);

            String urlStr = "https://us1.locationiq.com/v1/search?key=" + API_KEY +
                            "&q=" + encodedLocation +
                            "&format=json";

            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();

            if (responseCode != 200) {
                System.out.println("LocationIQ ERROR CODE = " + responseCode);
                return null;
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Parse JSON manually
            String json = response.toString();
            json = json.substring(1, json.length() - 1); // remove [ ]

            String latStr = json.split("\"lat\":\"")[1].split("\"")[0];
            String lonStr = json.split("\"lon\":\"")[1].split("\"")[0];

            return new double[]{Double.parseDouble(latStr), Double.parseDouble(lonStr)};

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

