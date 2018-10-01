package io.github.grooters.lller.quote.glide;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import java.io.File;
import io.github.grooters.lller.tool.UrIer;

public class Glider {

    private Glider(){ }

    public static Glider getLllGlider(){
        return SingleHolder.lllGlide;
    }

    private static class SingleHolder{
        private static final Glider lllGlide=new Glider();
    }

    public void loadImg(Context context,String url, ImageView imageView){
        Glide.with(context).load(url).into(imageView);
    }

    public void loadLocalImg(Context context,String filePath,ImageView imageView){
        File file=new File(filePath);
        Glide.with(context).load(file).into(imageView);
    }

    public void loadUriImg(Context context,String filePath,ImageView imageView,String authority){
        File file=new File(filePath);
        Uri uri=UrIer.toUri(context,file,authority);
        Glide.with(context).load(uri).into(imageView);

    }

    public void loadResImg(Context context,int resource,ImageView imageView){
        Glide.with(context).load(resource).into(imageView);
    }

    public void loadImg(Context context,String url,int placeHolder, ImageView imageView){
        GlideApp.with(context).load(url).placeholder(placeHolder).into(imageView);
    }

    public void loadLocalImg(Context context,String filePath,int placeHolder,ImageView imageView){
        File file=new File(filePath);
        GlideApp.with(context).load(file).placeholder(placeHolder).into(imageView);
    }

    public void loadUriImg(Context context,String filePath,int placeHolder,ImageView imageView,String authority){
        File file=new File(filePath);
        Uri uri=UrIer.toUri(context,file,authority);
        GlideApp.with(context).load(uri).placeholder(placeHolder).into(imageView);
    }

    public void loadResImg(Context context,int resource,int placeHolder,ImageView imageView){
        GlideApp.with(context).load(resource).placeholder(placeHolder).into(imageView);
    }

}
