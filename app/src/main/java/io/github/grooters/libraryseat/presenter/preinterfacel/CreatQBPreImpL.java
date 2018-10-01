package io.github.grooters.libraryseat.presenter.preinterfacel;

import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import io.github.grooters.libraryseat.presenter.preinterface.CreatQBPreInter;
import io.github.grooters.libraryseat.view.viewinter.CreQBViewInter;

public class CreatQBPreImpL implements CreatQBPreInter{
    private static final String TAG=CreatQBPreImpL.class.getSimpleName();
    private static final String QB_PATH="/LibrarySeat";
    private CreQBViewInter creQBViewInter;
    public CreatQBPreImpL(CreQBViewInter creQBViewInter){
        this.creQBViewInter=creQBViewInter;
    }
    @Override
    public void outQB(Bitmap bitmap, String fileName) {
        boolean pathExist=true;
        boolean fileDelete=true;
        boolean sdExist=Environment.getExternalStorageDirectory().toString().equals(Environment.MEDIA_MOUNTED);
        if(!sdExist){
            creQBViewInter.showToast("SD卡不存在");
        }
        File qbFilePath=new File(Environment.getExternalStorageDirectory().toString()+"/"+QB_PATH);
        Log.i(TAG,"qbFilePath.getPath()："+qbFilePath.getPath());
        if(!qbFilePath.exists()){
            pathExist=qbFilePath.mkdir();
        }
        if(pathExist){
            File qbFile=new File(qbFilePath.getPath()+"/"+fileName+".jpg");
            Log.i(TAG,"qbFile.getPath()："+qbFile.getPath());
            if(qbFile.exists()){
                fileDelete=qbFile.delete();
            }
            if(fileDelete){
                try{
                    FileOutputStream out=new FileOutputStream(qbFile);
                    bitmap.compress(Bitmap.CompressFormat.JPEG,100,out);
                    out.flush();
                    out.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
