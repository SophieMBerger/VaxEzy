package com.vaxezy.johnlee.vaxezy;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class VisionAPI extends AsyncTask {

    static String apiName = "vaxezvision";
    static String apiKey = "07bc853dc6794a4a8e8748c9e08ef382";


    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    public VisionAPI(String imageUrl){
        this.imageUrl = imageUrl;
    }

    private String imageUrl;

    @Override
    protected String doInBackground(Object[] objects) {

        OkHttpClient client = new OkHttpClient();
        String uriString = "https://westus.api.cognitive.microsoft.com/vision/v2.0/ocr?visualFeatures=Categories,Description,Color,Adult&language=en";
        Request request = new Request.Builder()
                .url(uriString)
                .header("Content-Type", "application/json")
                .header("Ocp-Apim-Subscription-Key", apiKey)
                .post(RequestBody.create(JSON, "{\"url\":\"" + imageUrl + "\"}"))
                .build();

        try (Response response = client.newCall(request).execute()) {

            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            String jsonString = response.body().string();
            RootJson root = gson.fromJson(jsonString, RootJson.class);

            String result = "";

            try {
                for (Region region : root.regions) {
                    for(Line line : region.lines){
                        for (Word word: line.words) {
                            if(word.text != null) {
                                result += " " + word.text;
                            }
                        }
                    }
                }
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }


           return result;
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return null;
    }
}


