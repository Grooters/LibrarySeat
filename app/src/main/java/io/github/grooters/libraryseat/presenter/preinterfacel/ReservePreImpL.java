package io.github.grooters.libraryseat.presenter.preinterfacel;

import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.github.grooters.libraryseat.api.ReserveApi;
import io.github.grooters.libraryseat.api.SeatInfoApi;
import io.github.grooters.libraryseat.model.Seat;
import io.github.grooters.libraryseat.presenter.preinterface.ReservePreInter;
import io.github.grooters.libraryseat.view.viewinter.ReserveViewInter;
import io.github.grooters.lller.quote.fastjson.FastJsoNer;
import io.github.grooters.lller.quote.okhttp.OkHttPer;

public class ReservePreImpL implements ReservePreInter{

    private static final String TAG=ReservePreImpL.class.getSimpleName();
    private ReserveViewInter reserveViewInter;
    private List<Seat> seats;

    public ReservePreImpL(ReserveViewInter reserveViewInter) {
        this.reserveViewInter=reserveViewInter;
    }


    @Override
    public void getSeatInfo() {
        OkHttPer.getOkHeePer().getByAsync(SeatInfoApi.GET_INFO_URL, new OkHttPer.CallBackOKInter() {
            @Override
            public void onFailure(String error, IOException e) {
                Log.i(TAG,"initInfo_failure:"+error);
            }
            @Override
            public void onResponse(String json) throws IOException {
                seats=(List<Seat>) FastJsoNer.getFastJsoNer().toObject(json,seats);

                List<Seat[]> seatsArray=new ArrayList<>();
                Seat[] seatLine=new Seat[5];
                int i=0;
                int j=1;
                int type_temp=1;
                for(Seat seat:seats){
                    //满一行或换楼层
                    if(i>4||seat.getFloor()!=type_temp){
                        seatsArray.add(seatLine);
                        type_temp=seat.getFloor();
                        seatLine=new Seat[5];
                        i=0;
                    }
                    seatLine[i]=seat;
                    //座位添加完成
                    if(j==seatsArray.size()){
                        seatsArray.add(seatLine);
                    }
                    ++i;
                    ++j;
                }
                reserveViewInter.initSeat(seatsArray);
            }
        });
    }

    @Override
    public void requestReser(Seat seat) {
        String param=FastJsoNer.getFastJsoNer().toJsonString(seat);
        OkHttPer.getOkHeePer().getByAsync(ReserveApi.REQUEST_RESERVE+"?Seat="+param, new OkHttPer.CallBackOKInter() {
            @Override
            public void onResponse(String json) throws IOException {
                reserveViewInter.showReserveResult(json);
            }
            @Override
            public void onFailure(String errorInfo, IOException e) {

            }
        });
    }
}
