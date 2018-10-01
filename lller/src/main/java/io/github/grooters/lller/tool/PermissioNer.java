package io.github.grooters.lller.tool;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

public class PermissioNer {
    private Context context;
    private int requestCode;
    private LllPermissionInter lllPermissionInter;

    private PermissioNer() {
        this.context = context;
    }

    private static class SingletonHolder{
        private static final PermissioNer permissioNer=new PermissioNer();
    }
    public static PermissioNer getLllPer(){
        return SingletonHolder.permissioNer;
    }

    /**
     * 请求动态权限
     * @param context 上下文
     * @param permission 权限名称
     * @param requestCode 请求码
     * @param lllPermissionInter 执行接口
     */
    public void requestPer(Context context,String permission,int requestCode,LllPermissionInter lllPermissionInter){
        this.context=context;
        this.requestCode=requestCode;
        this.lllPermissionInter=lllPermissionInter;
        if(ActivityCompat.checkSelfPermission(context,permission)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions((Activity) context,new String[]{permission},requestCode);
            lllPermissionInter.execute();
        }else{
            lllPermissionInter.execute();
        }
    }

    /**
     * 返回申请权限的响应结果，在客户端重写方法内调用该方法
     * @param requestCode 请求码
     * @param permissions 权限名称
     * @param grantResults 有重写方法中的参数作为该参数
     */
    public void showResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == this.requestCode) {
            if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                lllPermissionInter.execute();
            } else {
                Toast.makeText(context, "未能获取相关权限", Toast.LENGTH_LONG).show();
            }
        }
    }

    public interface LllPermissionInter{
        public void execute();
    }
}
