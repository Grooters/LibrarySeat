package io.github.grooters.lller.widget.recycler.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import java.util.List;

import io.github.grooters.lller.widget.recycler.holder.GeneralHolder;

public abstract class HeaderAdapter <T> extends GeneralAdapter<T>{
    private HeaderInterface <T> headerInterface;
    private Context context;
    private List<T> datas;
    private boolean initHeader;

    public HeaderAdapter(Context context, HeaderInterface<T> headerInterface, List<T> datas,boolean dividingLine) {
        super(context,-1,datas);
        this.context=context;
        this.headerInterface=headerInterface;
        this.datas=datas;
    }

    @NonNull
    @Override
    public GeneralHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int itemType) {
        return GeneralHolder.getHolder(context,viewGroup,headerInterface.getLayoutId(itemType));
    }

    @Override
    public void onBindViewHolder(@NonNull GeneralHolder viewHolder, int i) {
        if(getItemViewType(i)==HeaderInterface.HEADER_TYPE&&initHeader){
            header(viewHolder,datas.get(i));
            initHeader=false;
            return;
        }
        handle(viewHolder,datas.get(i));
    }

    @Override
    public int getItemViewType(int position) {
        return headerInterface.getItemType(position,datas);
    }

    public abstract void header(GeneralHolder viewHolder,T data);


}
