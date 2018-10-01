package io.github.grooters.libraryseat.presenter.preinterfacel;

import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

import io.github.grooters.libraryseat.presenter.preinterface.StartPreInter;
import io.github.grooters.libraryseat.view.viewinter.StartViewInter;

public class StartPreImpL implements StartPreInter {
    private static final String TAG=StartPreImpL.class.getSimpleName();
    private StartViewInter startViewInter;
    private int seconds;
    public StartPreImpL(StartViewInter startViewInter) {
        this.startViewInter=startViewInter;
    }

    @Override
    public void loadStart() {
        startViewInter.loadAnima();
    }

    @Override
    public void jumpLogin(final int second) {
        seconds=second;
        final Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                startViewInter.setCountdown(seconds);
                --seconds;
                Log.i(TAG,"seconds:"+seconds);
                if (seconds<0) {
                    startViewInter.startLogin();
                    cancel();
                }
            }
        }, 0, 1000);
    }
}
