package io.github.grooters.lller.tool;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;
import java.io.File;

public class UrIer {

//    file_paths.xml:

//    <paths xmlns:android="http://schemas.android.com/apk/res/android">
//        <files-path name="path_name" path="external-path"/>
//    </paths>

//    files-path 对应目录Context.getFilesDir()
//    cache-path 对应目录Context.getCacheDir()
//    external-path 对应目录Environment.getExternalStorageDirectory()
//    external-files-path 对应目录Context,getExternalFilesDir(String)或者Context.getExternalFilesDir(null)
//    external-cache-path 对应目录Context.getExternalCacheDir()

//    <provider
//        android:name="android.support.v4.content.FileProvider"
//        android:authorities="authorities"
//        android:exported="false"
//        android:grantUriPermissions="true">
//        <meta-data
//            android:name="android.support.FILE_PROVIDER_PATHS"
//            android:resource="@xml/file_paths" />
//    </provider>


    public static Uri toUri(Context context,File file,String authority){
        if(Build.VERSION.SDK_INT<24){
            return Uri.fromFile(file);
        }
        return FileProvider.getUriForFile(context,authority,file);
    }
}
