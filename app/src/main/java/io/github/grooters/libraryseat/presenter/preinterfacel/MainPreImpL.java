package io.github.grooters.libraryseat.presenter.preinterfacel;

import io.github.grooters.libraryseat.presenter.preinterface.MainPreInter;
import io.github.grooters.libraryseat.view.viewinter.MainViewInter;

public class MainPreImpL implements MainPreInter {

    private MainViewInter viewInter;
    private static final String TAG=MainPreImpL.class.getSimpleName();

    public MainPreImpL(MainViewInter viewInter) {
        this.viewInter = viewInter;
    }

    @Override
    public void scanQB() {
        viewInter.startScanQB();
    }

    @Override
    public void createQB() {
        viewInter.showQBDialog();
    }

    @Override
    public void checkMyState() {
        viewInter.showStateDialog();
    }
}
