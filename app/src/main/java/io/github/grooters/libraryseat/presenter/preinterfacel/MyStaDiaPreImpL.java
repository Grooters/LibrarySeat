package io.github.grooters.libraryseat.presenter.preinterfacel;

import org.litepal.LitePal;

import java.io.IOException;

import io.github.grooters.libraryseat.api.SitingApi;
import io.github.grooters.libraryseat.model.Seat;
import io.github.grooters.libraryseat.presenter.preinterface.MyStaDiaPreInter;
import io.github.grooters.libraryseat.view.viewinter.MyStaDiaViewInter;
import io.github.grooters.lller.quote.okhttp.OkHttPer;

/**
 * Create by 李林浪 in 2018/9/27
 * Elegant Code...
 */
public class MyStaDiaPreImpL implements MyStaDiaPreInter{
    private MyStaDiaViewInter viewInter;

    public MyStaDiaPreImpL(MyStaDiaViewInter viewInter) {
        this.viewInter = viewInter;
    }

    @Override
    public void requestLeave() {
        Seat seat= LitePal.find(Seat.class,1);
        OkHttPer.getOkHeePer().getByAsync(SitingApi.REQUEST_LEAVE_SIT_URL + "?id=" + seat.getId(), new OkHttPer.CallBackOKInter() {
            @Override
            public void onResponse(String json) throws IOException {
                viewInter.showResult(json);
            }

            @Override
            public void onFailure(String errorInfo, IOException e) {
                viewInter.showResult("服务器异常");
            }
        });
    }
}
