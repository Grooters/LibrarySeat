package io.github.grooters.libraryseat.presenter.preinterfacel;

import android.content.Context;
import android.util.Log;
import java.io.IOException;
import io.github.grooters.libraryseat.api.LoginApi;
import io.github.grooters.libraryseat.model.User;
import io.github.grooters.libraryseat.presenter.preinterface.LoginPreInter;
import io.github.grooters.libraryseat.view.viewinter.LoginViewInter;
import io.github.grooters.lller.quote.fastjson.FastJsoNer;
import io.github.grooters.lller.quote.okhttp.OkHttPer;

public class LoginPreImpL implements LoginPreInter{
    private LoginViewInter view;
    private User user;
    private static final String TAG=LoginPreImpL.class.getSimpleName();

    public LoginPreImpL(LoginViewInter view) {
        this.view = view;
        user=new User();
    }

    @Override
    public void getUserInfo(final Context context, String number, String pass) {
        OkHttPer.getOkHeePer().getByAsync(LoginApi.GET_USER_INFO+"?number="+number+"&pass="+pass, new OkHttPer.CallBackOKInter() {
            @Override
            public void onResponse(String json) throws IOException {
                Log.i(TAG,"json:"+json);

//                if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
//                    String path= Environment.getExternalStorageDirectory().getAbsolutePath()+"/LibrarySeat";
//                    StreaMer.getStreaMer().outTxt(context,path,"User.ini",json);
//                }

                if(json.equals("用户名不存在")){
                    view.userError();
                }else if(json.equals("密码错误")){
                    view.passError();
                }else if(json.equals("服务器异常")){
                    view.loginFalse();
                }else {
                    user= (User)FastJsoNer.getFastJsoNer().toObject(json,user);
                    user.save();
                    view.loginSuccess();
                }

            }
            @Override
            public void onFailure(String errorInfo, IOException e) {
                Log.i(TAG,"errorInfo:"+errorInfo);
                view.loginFalse();
            }
        });
    }
}
