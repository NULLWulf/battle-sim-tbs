package com.army_builder.systems;


import com.army_builder.Auth;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.IOException;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class Client {

    public void findAll(String string) throws IOException {  // Currently will find all documents as they appear in databse

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(Auth.getFindStr(),mediaType);
        Request request = new Request.Builder()
                .url("https://data.mongodb-api.com/app/data-okszo/endpoint/data/beta/action/find")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Access-Control-Request-Headers", "*")
                .addHeader("api-key", Auth.getMongoKey())
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(requireNonNull(response.body()).string());
    }

    public void insertOneArmy(String test) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(Auth.getDBString()+"\"document\": { \"status\": \"open\"}}",mediaType);
        Request request = new Request.Builder()
                .url("https://data.mongodb-api.com/app/data-okszo/endpoint/data/beta/action/insertOne")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Access-Control-Request-Headers", "*")
                .addHeader("api-key", Auth.getMongoKey())
                .build();
        Response response = client.newCall(request).execute();
//        JSON_Handler json = new JSON_Handler();
//        System.out.println(json.getObjAsJSONString(requireNonNull(response.body()).string()));
    }
}