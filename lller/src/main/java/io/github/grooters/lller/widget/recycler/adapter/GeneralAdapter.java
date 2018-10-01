package io.github.grooters.lller.widget.recycler.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;
import java.util.List;
import io.github.grooters.lller.widget.recycler.holder.GeneralHolder;

public abstract class GeneralAdapter <T> extends RecyclerView.Adapter <GeneralHolder> {
    private static final String TAG=GeneralAdapter.class.getSimpleName();
    private int layoutId;
    private Context context;
    List<T> datas;
    public GeneralAdapter(Context context, int layoutId,List<T> datas) {
        super();
        this.datas=datas;
        this.context=context;
        this.layoutId=layoutId;
    }
    @NonNull
    @Override
    public GeneralHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.i(TAG,"onCreateViewHolder");
        return GeneralHolder.getHolder(context,viewGroup,layoutId);
    }
    @Override
    public void onBindViewHolder(@NonNull GeneralHolder viewHolder, int i) {
        Log.i(TAG,"onBindViewHolder");
        handle(viewHolder,datas.get(i));
    }
    @Override
    public int getItemCount() {
        Log.i(TAG,"datas.size: "+datas.size());
        return datas.size();
    }
    @Override
    public long getItemId(int position) {
        Log.i(TAG,"ItemId: "+position);
        return position;
    }
    public abstract void handle(GeneralHolder viewHolder,T data);
}
