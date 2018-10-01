package io.github.grooters.libraryseat.view.activity;

import android.Manifest;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import com.yzq.zxinglibrary.android.CaptureActivity;
import com.yzq.zxinglibrary.common.Constant;
import org.litepal.LitePal;
import io.github.grooters.libraryseat.R;
import io.github.grooters.libraryseat.base.BaseActivity;
import io.github.grooters.libraryseat.model.Seat;
import io.github.grooters.libraryseat.model.User;
import io.github.grooters.libraryseat.presenter.preinterface.MainPreInter;
import io.github.grooters.libraryseat.presenter.preinterfacel.MainPreImpL;
import io.github.grooters.libraryseat.view.dialog.CreateQBDialog;
import io.github.grooters.libraryseat.view.dialog.MyStateDialog;
import io.github.grooters.libraryseat.view.dialog.SitingDialog;
import io.github.grooters.libraryseat.view.viewinter.MainViewInter;
import io.github.grooters.lller.tool.PermissioNer;
import io.github.grooters.lller.tool.Toaster;

public class MainActivity extends BaseActivity implements MainViewInter,View.OnClickListener {
    private static final String TAG=MainActivity.class.getSimpleName();
    private MainPreInter mainPreInter;
    private Intent intent;
    private static final int REQUEST_SCANCODE=1;
    private PermissioNer permissioNer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPreInter=new MainPreImpL(this);
        ImageButton mineImgButt=findViewById(R.id.imgButt_mine);
        ImageButton reserveImgButt=findViewById(R.id.imgButt_reserve);
        ImageButton postImgButt=findViewById(R.id.imgButt_post);
        ImageButton createQBImgButt=findViewById(R.id.imgButt_createQB);
        Button scanQBButt=findViewById(R.id.butt_scan);
        ImageButton checkStateButt=findViewById(R.id.imgButt_checkState);
        mineImgButt.setOnClickListener(this);
        reserveImgButt.setOnClickListener(this);
        postImgButt.setOnClickListener(this);
        createQBImgButt.setOnClickListener(this);
        scanQBButt.setOnClickListener(this);
        checkStateButt.setOnClickListener(this);
    }

    @Override
    public Fragment createFragment() {
        return null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imgButt_mine:
                intent=new Intent(this,MineActivity.class);
                startActivity(intent);
                break;
            case R.id.imgButt_reserve:
                intent=new Intent(this,ReserveActivity.class);
                startActivity(intent);
                break;
            case R.id.imgButt_post:
                intent=new Intent(this,PostActivity.class);
                startActivity(intent);
                break;
            case R.id.imgButt_createQB:
                mainPreInter.createQB();
                break;
            case R.id.butt_scan:
                mainPreInter.scanQB();
                break;
            case R.id.imgButt_checkState:
                mainPreInter.checkMyState();
                break;
        }
    }


    @Override
    public void startScanQB() {
        permissioNer= PermissioNer.getLllPer();
        permissioNer.requestPer(this, Manifest.permission.CAMERA, REQUEST_SCANCODE, new PermissioNer.LllPermissionInter() {
            @Override
            public void execute() {
                Intent intent=new Intent(MainActivity.this, CaptureActivity.class);
                startActivityForResult(intent,REQUEST_SCANCODE);
            }
        });
    }

    @Override
    public void showQBDialog() {
        CreateQBDialog createQBDialog=new CreateQBDialog(this);
        createQBDialog.show();
    }


    //返回扫码结果
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            switch (requestCode){
                case REQUEST_SCANCODE:
                    if (data != null) {
                        User user= LitePal.find(User.class,1);
                        String content = data.getStringExtra(Constant.CODED_CONTENT);
                        Seat seat=new Seat(1,1,1,1,1,user.getNumber(),1);
                        SitingDialog dialog=new SitingDialog(this);
                        dialog.sitingDiaPreInter.provideInfo(seat);
                        dialog.show();
                    }
                    break;
            }
        }
    }

    @Override
    public void showStateDialog() {
        MyStateDialog myStateDialog=new MyStateDialog(this);
        myStateDialog.show();
    }

    @Override
    public void showSitResult(String reslut) {
        Toaster.showShort(this,reslut);
    }
}
