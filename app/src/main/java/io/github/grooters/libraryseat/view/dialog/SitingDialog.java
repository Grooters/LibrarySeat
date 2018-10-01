package io.github.grooters.libraryseat.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import io.github.grooters.libraryseat.R;
import io.github.grooters.libraryseat.presenter.preinterface.SitingDiaPreInter;
import io.github.grooters.libraryseat.view.viewinter.SitingDiaViewInter;
import io.github.grooters.lller.tool.Toaster;

/**
 * Create by 李林浪 in 2018/9/24
 * Elegant Code...
 */
public class SitingDialog extends Dialog implements SitingDiaViewInter,View.OnClickListener{
    private Context context;
    public SitingDiaPreInter sitingDiaPreInter;
    private EditText timeEdiText;

    public SitingDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_sit);
        timeEdiText=findViewById(R.id.edit_sit_time);
        Button setButton=findViewById(R.id.butt_setTime);
        setButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.butt_setTime:
                sitingDiaPreInter.requestSeat(Integer.valueOf(timeEdiText.getText().toString()));
                break;
        }
    }

    @Override
    public void showResult(String result) {
        Toaster.showShort(context,result);
    }
}
