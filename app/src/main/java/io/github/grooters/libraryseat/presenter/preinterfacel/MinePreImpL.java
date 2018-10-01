package io.github.grooters.libraryseat.presenter.preinterfacel;

import org.litepal.LitePal;

import io.github.grooters.libraryseat.model.User;
import io.github.grooters.libraryseat.presenter.preinterface.MinePreInter;
import io.github.grooters.libraryseat.view.viewinter.MineViewInter;

public class MinePreImpL implements MinePreInter{
    private MineViewInter mineViewInter;
    private static final String TAG=MinePreImpL.class.getSimpleName();

    public MinePreImpL(MineViewInter mineViewInter) {
        this.mineViewInter=mineViewInter;
    }
    @Override
    public void getUser() {

//        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
//            String name=Environment.getExternalStorageState()+"/LibrarySeat/user.ini";
//            json= StreaMer.getStreaMer().inText(name);
//        }

        User user= LitePal.find(User.class,1);
        mineViewInter.setInfo(user);
    }
}