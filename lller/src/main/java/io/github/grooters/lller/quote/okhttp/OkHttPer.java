package io.github.grooters.lller.quote.okhttp;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttPer{
    private static final String TAG=OkHttPer.class.getSimpleName();
    private String json;
    private OkHttPer(){}
    public static OkHttPer getOkHeePer(){
        return SingletonHolder.okHttPer;
    }
    private static class SingletonHolder{
        private static final OkHttPer okHttPer=new OkHttPer();
    }


    /**
     * 同步get请求
     * @param url 接口地址
     * @return 结果Json串
     */
    public String getBySync(final String url){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    OkHttpClient client=new OkHttpClient();
                    Request request=new Request.Builder().url(url).build();
                    Response response=client.newCall(request).execute();
                    if(response.isSuccessful()&&response.body()!=null){
                        json=response.body().string();
                        Log.i(TAG,"Json: "+json);
                        response.close();
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }).start();
        return json;
    }

    public long getContentLength(final String url){
        try{
            OkHttpClient client=new OkHttpClient();
            Request request=new Request.Builder().url(url).build();
            Response response=client.newCall(request).execute();
            if(response.isSuccessful()&&response.body()!=null){
                long length=response.body().contentLength();
                Log.i(TAG,"length: "+length);
                response.close();
                return length;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return 0;
    }


    /**
     * 异步get请求
     * @param url 接口地址
     * @param callBackOKInter 回调接口，重写请求结果方法
     */
    public void getByAsync(String url, final CallBackOKInter callBackOKInter){
        OkHttpClient client=new OkHttpClient();
        final Request request=new Request.Builder().url(url).build();
        Callback callback=new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callBackOKInter.onFailure("error",e);
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json=response.body().string();
                Log.i(TAG,"json:"+json);
                callBackOKInter.onResponse(json);
                response.close();
            }
        };
        client.newCall(request).enqueue(callback);
    }


    /**
     * post请求
     * @param url 接口地址
     * @param map 参数存放容器
     * @param callBackOKInter 回调接口，重写请求结果方法
     */
    public void postByOk(String url, Map<String,String> map, final CallBackOKInter callBackOKInter){
        OkHttpClient client=new OkHttpClient();
        FormBody.Builder formBody=new FormBody.Builder();
        for(String key:map.keySet()){
            formBody.add(key,map.get(key));
        }
        Request request=new Request.Builder().url(url).post(formBody.build()).build();
        Callback callback=new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callBackOKInter.onFailure("error",e);
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json=response.body().string();
                Log.i(TAG,"json:"+json);
                callBackOKInter.onResponse(json);
            }
        };
        client.newCall(request).enqueue(callback);
    }



    public InputStream downOk(String url, Map<String,String> header) throws IOException{
        OkHttpClient client=new OkHttpClient();
        Request request=null;
        if(header!=null){
            for(String key:header.keySet()){
                request=new Request.Builder().addHeader(key,header.get(key)).url(url).build();
            }
        }else{
            request=new Request.Builder().url(url).build();
        }
        Response response= client.newCall(request).execute();
        InputStream in=response.body().byteStream();
        response.close();
        return in;
    }

    public interface CallBackOKInter{
        public void onResponse(String json)throws IOException;
        public void onFailure(String errorInfo, IOException e);
    }
}
