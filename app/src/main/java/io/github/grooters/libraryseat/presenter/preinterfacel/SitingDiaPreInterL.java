package io.github.grooters.libraryseat.presenter.preinterfacel;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import io.github.grooters.libraryseat.api.ReserveApi;
import io.github.grooters.libraryseat.api.SitingApi;
import io.github.grooters.libraryseat.model.Seat;
import io.github.grooters.libraryseat.presenter.preinterface.SitingDiaPreInter;
import io.github.grooters.libraryseat.view.viewinter.SitingDiaViewInter;
import io.github.grooters.lller.quote.fastjson.FastJsoNer;
import io.github.grooters.lller.quote.okhttp.OkHttPer;

/**
 * Create by 李林浪 in 2018/9/17
 * Elegant Code...
 */
public class SitingDiaPreInterL implements SitingDiaPreInter {
    private static final String TAG=SitingDiaPreInterL.class.getSimpleName();
    private SitingDiaViewInter sitingDiaViewInter;
    private Seat seat;
    public SitingDiaPreInterL(SitingDiaViewInter resDiaViewInter) {
        this.sitingDiaViewInter=resDiaViewInter;
    }
    @Override
    public void requestSeat(int time) {
        seat.setTime(time);
        String json= FastJsoNer.getFastJsoNer().toJsonString(seat);
//        Map<String,String> map=new HashMap<>();
//        map.put("JSON",json);
//        OkHttPer.getOkHeePer().postByOk(SitingApi.REQUEST_SIT_URL, map, new OkHttPer.CallBackOKInter() {
//            @Override
//            public void onResponse(String json) throws IOException {
//                sitingDiaViewInter.showResult(json);
//            }
//            @Override
//            public void onFailure(String errorInfo, IOException e) {
//                sitingDiaViewInter.showResult("服务器异常，请稍后再试");
//            }
//        });
        OkHttPer.getOkHeePer().getByAsync(SitingApi.REQUEST_SIT_URL+"?Seat="+json, new OkHttPer.CallBackOKInter() {
            @Override
            public void onResponse(String json) throws IOException {
                seat.save();
                sitingDiaViewInter.showResult(json);
            }
            @Override
            public void onFailure(String errorInfo, IOException e) {
                sitingDiaViewInter.showResult("服务器异常，请稍后再试");
            }
        });

    }
    @Override
    public void provideInfo(Seat seat) {
        this.seat=seat;
    }

}
