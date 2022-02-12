package com.army_builder.systems;


import com.army_builder.Auth;
import okhttp3.*;

import java.io.IOException;

public class Client {

    public void apiInsertTest(String string) throws IOException {

        Auth tempAuth = new Auth();

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");

//        RequestBody body = new MultipartBody.Builder()
//                .setType(MultipartBody.FORM)
//                .addFormDataPart("dataSource","Cluster0")
//                .addFormDataPart("collection","battle")
//                .addFormDataPart("database","game")
//                .addFormDataPart("document",string)
//                .build();
        RequestBody body = RequestBody.create(mediaType, "{\n    \"collection\":\"battle\",\n    \"database\":\"game\",\n    \"dataSource\":\"Cluster0\",\n    \"document\":"  + string);
        Request request = new Request.Builder()
                .url("https://data.mongodb-api.com/app/data-okszo/endpoint/data/beta/action/insertOne")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Access-Control-Request-Headers", "*")
                .addHeader("api-key", tempAuth.getMongoKey())
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.toString());
    }
}
