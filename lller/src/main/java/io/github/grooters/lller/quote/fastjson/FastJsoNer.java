package io.github.grooters.lller.quote.fastjson;

import android.util.Log;

import com.alibaba.fastjson.JSON;

public class FastJsoNer {

    private static final String TAG=FastJsoNer.class.getSimpleName();

    private FastJsoNer(){ }

    public static FastJsoNer getFastJsoNer(){
        return SingleHolder.fastJsoNer;
    }

    private static class SingleHolder{
        private static final FastJsoNer fastJsoNer=new FastJsoNer();
    }

    public Object toObject(String json,Object bean){
        Log.i(TAG,"bean:"+bean.getClass().getSimpleName());
        return JSON.parseObject(json,bean.getClass());
    }
    public String toJsonString(Object bean){
        Log.i(TAG,"bean:"+bean.getClass().getSimpleName());
        return JSON.toJSONString(bean);
    }
}
