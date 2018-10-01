package io.github.grooters.libraryseat.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.zxing.WriterException;
import com.yzq.zxinglibrary.encode.CodeCreator;
import io.github.grooters.libraryseat.R;
import io.github.grooters.libraryseat.presenter.preinterface.CreatQBPreInter;
import io.github.grooters.libraryseat.presenter.preinterfacel.CreatQBPreImpL;
import io.github.grooters.libraryseat.view.viewinter.CreQBViewInter;

public class CreateQBDialog extends Dialog implements CreQBViewInter,View.OnClickListener{
    private EditText qbContentEdit;
    private CreatQBPreInter creatQBPreInter;
    private Context context;
    public CreateQBDialog(@NonNull Context context) {
        super(context);
        this.context=context;
        creatQBPreInter=new CreatQBPreImpL(this);
    }
    @Override
    public void showToast(String content) {
        Toast.makeText(context,content,Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getWindow()!=null){
            getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        }
        setContentView(R.layout.dialog_setqbinfo);
        qbContentEdit=findViewById(R.id.edit_qb_content);
        Button setContentButt=findViewById(R.id.butt_setQbContent);
        setContentButt.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.butt_setQbContent:
                try {
                    String qBContent=qbContentEdit.getText().toString();
                    Bitmap bitmap= CodeCreator.createQRCode(qBContent,400,400,null);
                    creatQBPreInter.outQB(bitmap,qBContent);
                } catch (WriterException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

}
