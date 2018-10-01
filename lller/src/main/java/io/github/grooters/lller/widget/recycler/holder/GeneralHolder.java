package io.github.grooters.lller.widget.recycler.holder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class GeneralHolder extends RecyclerView.ViewHolder{
    private static final String TAG=GeneralHolder.class.getSimpleName();
    private SparseArray<View> views;
    private Context context;
    private View itemView;
    private GeneralHolder(@NonNull View itemView,Context context) {
        super(itemView);
        Log.i(TAG,"GeneralHolder");
        this.itemView=itemView;
        this.context=context;
        views=new SparseArray<>();
    }
    public static GeneralHolder getHolder(Context context, ViewGroup parent, int layoutId){
        Log.i(TAG,"getHolder");
        View itemView=LayoutInflater.from(context).inflate(layoutId,parent,false);
        return new GeneralHolder(itemView,context);
    }
    public <T extends View> T handleView(int viewId){
        View view=views.get(viewId);
        if(view==null){
            Log.i(TAG,"view==null");
            view=itemView.findViewById(viewId);
            views.put(viewId,view);
        }
        return (T)view;
    }
}
