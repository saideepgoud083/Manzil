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

    private static final String API_KEY = "YOUR_API_KEY";

    public double[] getCoordinates(String location) {
        try {
            String url = "https://us1.locationiq.com/v1/search?key=" + API_KEY +
                    "&q=" + URLEncoder.encode(location, StandardCharsets.UTF_8) +
                    "&format=json";

            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String response = br.readLine();

            // Validate API response
            if (response == null || response.equals("[]") || !response.trim().startsWith("[")) {
                return null; // invalid location OR API error
            }

            // Parse JSON array safely
            JSONArray jsonArray = new JSONArray(response);
            JSONObject obj = jsonArray.getJSONObject(0);

            double lat = obj.getDouble("lat");
            double lon = obj.getDouble("lon");

            return new double[]{lat, lon};

        } catch (Exception e) {
            e.printStackTrace();
            return null; // invalid location or API error
        }
    }
}
