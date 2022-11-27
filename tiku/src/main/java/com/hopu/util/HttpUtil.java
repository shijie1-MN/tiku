package com.hopu.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author shijie
 * #Description HttpUtil
 * #Date: 2022/10/19 19:49
 */
public class HttpUtil {
    public static String getURL(String url){
        String result=null;
        CloseableHttpClient httpClient= HttpClients.createDefault();
        HttpGet get=new HttpGet(url);
        CloseableHttpResponse response=null;
        try {
            response=httpClient.execute(get);
            if (response!=null&&response.getStatusLine().getStatusCode()==200) {
                HttpEntity entity=response.getEntity();
                result=entityToString(entity);
            }
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                httpClient.close();
                if (response != null) {
                    response.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String entityToString(HttpEntity entity) throws IOException {
        String result=null;
        if (entity != null) {
            long length=entity.getContentLength();
            if (length!=-1&&length<2048) {
                result= EntityUtils.toString(entity,"UTF-8");
            }else{
                InputStreamReader reader1=new InputStreamReader(entity.getContent(),"UTF-8");
                CharArrayBuffer buffer=new CharArrayBuffer(2048);
                char[] tmp=new char[1024];
                int l;
                while ((l=reader1.read(tmp)) !=-1){
                    buffer.append(tmp,0,l);
                }
                result=buffer.toString();
            }
        }
        return result;
    }
}
