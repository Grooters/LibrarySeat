package io.github.grooters.lller.tool;

import android.Manifest;
import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Create by 李林浪 in 2018/9/21
 * Elegant Code...
 */
public class StreaMer {

    private static final String TAG=StreaMer.class.getSimpleName();

    private StreaMer(){ }

    private static class SingletonHolder{
        private static final StreaMer streaMer=new StreaMer();
    }
    public static StreaMer getStreaMer(){
        return SingletonHolder.streaMer;
    }

    public void outTxt(Context context,final String path,final String name,final String content){
        PermissioNer.getLllPer().requestPer(context, Manifest.permission.WRITE_EXTERNAL_STORAGE, 1, new PermissioNer.LllPermissionInter() {
            @Override
            public void execute() {
                try {
                    File dir=new File(path);
                    if(!dir.exists()){
                        Log.i(TAG,"!dir.exists()");
                        dir.mkdir();
                    }
                    File file=new File(path+"/"+name);
                    if(file.exists()){
                        file.delete();
                    }
                    Log.i(TAG,file.getAbsolutePath());
                    file.createNewFile();
                    PrintStream out=new PrintStream(new FileOutputStream(file));
                    out.print(content);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public String inText(String name){
        try {
            File file=new File(name);
            if(!file.exists()){
                Log.i(TAG,"file is not exit");
            }
            BufferedReader reader=new BufferedReader(new FileReader(file));
            return  reader.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
