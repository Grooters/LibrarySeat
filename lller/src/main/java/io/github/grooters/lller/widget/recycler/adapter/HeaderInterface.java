package io.github.grooters.lller.widget.recycler.adapter;

import java.util.List;

public interface HeaderInterface <T>{
    public static final int HEADER_TYPE=0;
    public int getLayoutId(int itemType);
    public int getItemType(int position, List<T> datas);
}
