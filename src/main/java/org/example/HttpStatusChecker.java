package org.example;

import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {

    public String getStatusImage(int code) throws Exception {
        String urlString = "https://http.cat/" + code + ".jpg";
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == 404) {
            throw new Exception("Image not found for status code: " + code);
        }

        return urlString;
    }

    public static void main(String[] args) {
        HttpStatusChecker checker = new HttpStatusChecker();
        try {
            System.out.println(checker.getStatusImage(200)); // Should return URL
            System.out.println(checker.getStatusImage(10000)); // Should throw exception
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}