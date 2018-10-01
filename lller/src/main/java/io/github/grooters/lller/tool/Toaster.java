package io.github.grooters.lller.tool;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;


/**
 * Create by 李林浪 in 2018/9/14
 * Elegant Code...
 */
public class Toaster {
    public static void showShort(final Context context,final String content){
        Handler handler=new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context,content,Toast.LENGTH_SHORT).show();
            }
        });
    }
    public static void showLong(final Context context,final String content){
        Handler handler=new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context,content,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
