package io.github.grooters.lller.widget.recycler.adapter;

import java.util.List;

public interface MultipleTypeInteface <T>{
    public int getLayoutId(int itemType);
    public int getItemType(int position, List<T> datas);
}
