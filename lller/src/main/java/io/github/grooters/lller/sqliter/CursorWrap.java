package io.github.grooters.lller.sqliter;

import android.database.Cursor;
import android.database.CursorWrapper;

public class CursorWrap extends CursorWrapper{

    private Cursor cursor;

    public CursorWrap(Cursor cursor){
        super(cursor);
        this.cursor=cursor;
    }

}
