package com.owlgrin.horntell.net;

import com.google.gson.Gson;
import com.owlgrin.horntell.enums.RequestEndpoint;
import com.owlgrin.horntell.util.Util;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;


import java.io.IOException;

/**
 * Created by dave on 15/11/15.
 */
public class RequestUtil<T> {

    protected static final String BASE_URI = "http://demo.api.horntell.com";
    protected static final String VERSION = "v1";


    HttpClient httpClient = new DefaultHttpClient();


    public HttpResponse sendRequest(T requestBody,RequestEndpoint endpoint) throws IOException {

        switch (endpoint.getMethod()){
            case GET: return getRequest(endpoint);
            case POST:return postRequest(requestBody,endpoint);
            case PUT:return putRequest(requestBody, endpoint);
            case DELETE: return deleteRequest(endpoint);
            case PATCH:return patchRequest(requestBody,endpoint);
            default: return null;
        }
    }


    private HttpResponse getRequest(RequestEndpoint endpoint) throws IOException {
        HttpGet getRequest = new HttpGet(BASE_URI+endpoint);
        pushRequiredHeaders(getRequest);
        HttpResponse response = httpClient.execute(getRequest);
        return response;
    }

    private HttpResponse postRequest(T requestBody, RequestEndpoint endpoint) throws IOException {
        HttpPost post = new HttpPost(BASE_URI+endpoint);
        pushRequiredHeaders(post);
        post.setEntity(new StringEntity(new Gson().toJson(requestBody)));
        HttpResponse response = httpClient.execute(post);
        return response;
    }

    private HttpResponse putRequest(T requestBody, RequestEndpoint endpoint) throws IOException{
        HttpPut httpPut = new HttpPut(BASE_URI+endpoint);
        pushRequiredHeaders(httpPut);
        httpPut.setEntity(new StringEntity(new Gson().toJson(requestBody)));
        HttpResponse response = httpClient.execute(httpPut);
        return response;
    }

    private HttpResponse patchRequest(T requestBody, RequestEndpoint endpoint) throws IOException{
        HttpPatch httpPatch = new HttpPatch(BASE_URI+endpoint);
        pushRequiredHeaders(httpPatch);
        httpPatch.setEntity(new StringEntity(new Gson().toJson(requestBody)));
        HttpResponse response = httpClient.execute(httpPatch);
        return response;
    }

    private HttpResponse deleteRequest(RequestEndpoint endpoint) throws IOException {
        HttpDelete httpDelete = new HttpDelete(BASE_URI+endpoint);
        pushRequiredHeaders(httpDelete);
        HttpResponse response = httpClient.execute(httpDelete);
        return response;
    }

    private static HttpRequestBase pushRequiredHeaders(HttpRequestBase request) {
        request.addHeader("Authorization", Util.getBasicAuthCredentials());
        request.addHeader("Accept", "application/vnd.horntell."+VERSION+"+json");
        request.addHeader("Content-Type","text/json");
        return request;
    }


}
