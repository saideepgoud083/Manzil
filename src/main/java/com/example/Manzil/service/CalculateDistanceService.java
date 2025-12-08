package com.example.Manzil.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
@Service
public class CalculateDistanceService {
	public double calculateDistance(double startLat, double startLon, double endLat, double endLon) {

        try {
            String apiKey = "yourapikey";

            // API requires lon,lat ORDER
            String url = "https://api.openrouteservice.org/v2/directions/driving-car" +
                         "?api_key=" + apiKey +
                         "&start=" + startLon + "," + startLat +
                         "&end=" + endLon + "," + endLat;

            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder json = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                json.append(line);
            }
            br.close();

            // Parse JSON
            JSONObject obj = new JSONObject(json.toString());
            JSONObject summary = obj.getJSONArray("features")
                                    .getJSONObject(0)
                                    .getJSONObject("properties")
                                    .getJSONObject("summary");

            double distanceMeters = summary.getDouble("distance");
            double distanceKm = distanceMeters / 1000.0;

            return distanceKm;

        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }

}
