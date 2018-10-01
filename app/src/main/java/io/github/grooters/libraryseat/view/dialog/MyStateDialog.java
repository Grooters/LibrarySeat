package io.github.grooters.libraryseat.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import io.github.grooters.libraryseat.R;
import io.github.grooters.libraryseat.presenter.preinterface.MyStaDiaPreInter;
import io.github.grooters.libraryseat.presenter.preinterfacel.MyStaDiaPreImpL;
import io.github.grooters.libraryseat.view.viewinter.MyStaDiaViewInter;
import io.github.grooters.lller.tool.Toaster;

/**
 * Create by 李林浪 in 2018/9/19
 * Elegant Code...
 */
public class MyStateDialog extends Dialog implements MyStaDiaViewInter,View.OnClickListener{

    private TextView nameText,totalTime,leaveTime;
    private Context context;
    private MyStaDiaPreInter myStaDiaPreInter;

    public MyStateDialog(@NonNull Context context) {
        super(context);
        this.context=context;
        myStaDiaPreInter=new MyStaDiaPreImpL(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_state);
        nameText=findViewById(R.id.text_state_name);
        totalTime=findViewById(R.id.text_state_time);
        leaveTime=findViewById(R.id.text_state_endTime);
        ImageButton leaveImgButt=findViewById(R.id.imgButt_quitDown);
        leaveImgButt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgButt_quitDown:
                myStaDiaPreInter.requestLeave();
                break;
        }
    }

    @Override
    public void showResult(String result) {
        Toaster.showShort(context,result);
    }
}
