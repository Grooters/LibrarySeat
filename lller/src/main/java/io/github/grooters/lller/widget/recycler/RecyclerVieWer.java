package io.github.grooters.lller.widget.recycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import java.util.List;
import io.github.grooters.lller.widget.recycler.adapter.GeneralAdapter;
import io.github.grooters.lller.widget.recycler.adapter.MultipleTypeAdapter;
import io.github.grooters.lller.widget.recycler.adapter.MultipleTypeInteface;
import io.github.grooters.lller.widget.recycler.holder.GeneralHolder;

public class RecyclerVieWer <T> extends RecyclerView{
    private Context context;
    public RecyclerVieWer(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RecyclerVieWer(@NonNull Context context) {
        super(context);
        this.context=context;
        setLayoutManager(new LinearLayoutManager(context));
    }

    /**
     * 设置通用适配器
     * @param layoutId ItemView id
     * @param datas item data
     * @param handler itemView赋值接口
     */
    public void setGeneralAdapter(int layoutId, List<T> datas, final RecyclerHandler handler){
        setAdapter(new GeneralAdapter<T>(context,layoutId,datas) {
            @Override
            public void handle(GeneralHolder viewHolder, Object data) {
                handler.handle();
            }
        });
    }

    /**
     * 设置多布局适配器
     * @param datas item data
     * @param RecyclerMultiHanler itemView赋值接口
     */
    public void setMultipleAdapter(List<T> datas, final RecyclerMultiHanler<T> RecyclerMultiHanler){
        setAdapter(new MultipleTypeAdapter<T>(context, datas, new MultipleTypeInteface<T>() {
            @Override
            public int getLayoutId(int itemType) {
                return RecyclerMultiHanler.getLayoutId(itemType);
            }

            @Override
            public int getItemType(int position, List<T> datas) {
                return RecyclerMultiHanler.getItemType(position,datas);
            }
        }) {
            @Override
            public void handle(GeneralHolder viewHolder, Object data) {
                RecyclerMultiHanler.handle();
            }
        });
    }

    public interface RecyclerHandler{
        public void handle();
    }

    public interface RecyclerMultiHanler<T>{
        public void handle();
        //根据position和datas客户端可自己设设置该item中的布局
        public int getItemType(int position, List<T> datas);
        /**
         * 返回当前item需要设置的布局id
         * @param itemType getItemType中返回的itemType
         * @return 返回一个布局id
         */
        public int getLayoutId(int itemType);
    }
}
