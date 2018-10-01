package io.github.grooters.lller.widget.recycler.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import java.util.List;
import io.github.grooters.lller.widget.recycler.holder.GeneralHolder;

public abstract class MultipleTypeAdapter <T> extends GeneralAdapter<T> {
    private Context context;
    private MultipleTypeInteface <T> multipleTypeInteface;
    public MultipleTypeAdapter(Context context, List<T> datas,MultipleTypeInteface<T> multipleTypeInteface ) {
        super(context,-1,datas);
        this.context=context;
        this.multipleTypeInteface=multipleTypeInteface;
    }
    @NonNull
    @Override
    public GeneralHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int itemType) {
        return GeneralHolder.getHolder(context,viewGroup,multipleTypeInteface.getLayoutId(itemType));
    }
    @Override
    public int getItemViewType (int position) {
        return multipleTypeInteface.getItemType(position,datas);
    }
}
