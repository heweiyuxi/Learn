package com.green.he.ws;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.*;

/**
 * Created by greenhe on 2016/3/24.
 */
public class TestRest {


    private static Logger log = Logger.getLogger(TestRest.class);

    public static String post(String url, Map<String, String> params) {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        String body = null;

        log.info("create httppost:" + url);
        HttpPost post = postForm(url, params);

        body = invoke(httpclient, post);

        httpclient.getConnectionManager().shutdown();

        return body;
    }

    public static String get(String url) {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        String body = null;

        log.info("create httppost:" + url);
        HttpGet get = new HttpGet(url);
        body = invoke(httpclient, get);

        httpclient.getConnectionManager().shutdown();

        return body;
    }


    private static String invoke(DefaultHttpClient httpclient,
                                 HttpUriRequest httpost) {

        HttpResponse response = sendRequest(httpclient, httpost);
        String body = paseResponse(response);

        return body;
    }

    private static String paseResponse(HttpResponse response) {
        log.info("get response from http server..");
        HttpEntity entity = response.getEntity();

        log.info("response status: " + response.getStatusLine());
        String charset = EntityUtils.getContentCharSet(entity);
        log.info(charset);

        String body = null;
        try {
            body = EntityUtils.toString(entity);
            log.info(body);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return body;
    }

    private static HttpResponse sendRequest(DefaultHttpClient httpclient,
                                            HttpUriRequest httpost) {
        log.info("execute post...");
        HttpResponse response = null;

        try {
            response = httpclient.execute(httpost);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    private static HttpPost postForm(String url, Map<String, String> params){

        HttpPost httpost = new HttpPost(url);
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();

        Set<String> keySet = params.keySet();
        for(String key : keySet) {
            nvps.add(new BasicNameValuePair(key, params.get(key)));
        }

        try {
            log.info("set utf-8 form entity to httppost");
            httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return httpost;
    }


    public static void main(String []args){
        String URL ="http://192.1.8.89/supplierportal/api/v4.6/onboard_tracks/1234";
        String username="alicehui.refapp@ecvision.com";
        String password="11111";
        Map<String, String> params = new HashMap<String, String>();
        params.put("name", username);
        params.put("password", password);

        Map<String,String> jsonData = new HashMap<String, String>();
        jsonData.put("onboard_status","Rejected");
        jsonData.put("onboard_reject_reason","It is rejected");
        jsonData.put("updated_by","alicehui.refapp@ecvision.com");
        ObjectMapper mapper = new ObjectMapper();
        String requestData="";
        try {
            requestData = mapper.writeValueAsString(jsonData);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject result = executeHttpPatch(URL, requestData);
        System.out.print(result);
        /*

        {
"onboard_status":"Rejected",
"onboard_reject_reason":"It is rejected",
"updated_by":"alicehui.refapp@ecvision.com"
}
         */
//        String xml = TestRest.post(URL, params);
//        System.out.print(xml);
    }


    public static JSONObject executeHttpPatch(String url,String jsonParam){
        JSONObject resultObj = null;
        HttpClient httpClient = new DefaultHttpClient();
        HttpPatch httpPatch = new HttpPatch(url);
        httpPatch.setHeader("Content-type", "application/json");
        httpPatch.setHeader("Charset", HTTP.UTF_8);
        httpPatch.setHeader("Accept", "application/json");
        httpPatch.setHeader("Accept-Charset", HTTP.UTF_8);

        String username="alicehui.refapp@ecvision.com";
        String password="11111";

        String auth = username + ":" + password;
        byte[] encodedAuth = Base64.encodeBase64(
                auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String( encodedAuth );
        httpPatch.setHeader("Authorization", authHeader);

        try {
            if (jsonParam != null){
                StringEntity entity = new StringEntity(jsonParam,HTTP.UTF_8);
                httpPatch.setEntity(entity);
            }
            HttpResponse response = httpClient.execute(httpPatch);
            StatusLine statusLine = response.getStatusLine();
            int status =statusLine.getStatusCode();

            resultObj = new JSONObject(EntityUtils.toString(response.getEntity()));

            if(status!=HttpStatus.SC_OK){
                throw  new Exception("failed");
            }
        } catch (Exception  e) {
            e.printStackTrace();
        }

        return resultObj;
    }
}
