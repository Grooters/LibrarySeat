package io.github.grooters.libraryseat.view.fragment.reserve;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.List;
import io.github.grooters.libraryseat.R;
import io.github.grooters.libraryseat.model.Seat;
import io.github.grooters.libraryseat.model.User;
import io.github.grooters.libraryseat.presenter.preinterface.ReservePreInter;
import io.github.grooters.libraryseat.presenter.preinterfacel.ReservePreImpL;
import io.github.grooters.libraryseat.view.viewinter.ReserveViewInter;
import io.github.grooters.lller.tool.Toaster;
import io.github.grooters.lller.widget.recycler.adapter.GeneralAdapter;
import io.github.grooters.lller.widget.recycler.holder.GeneralHolder;

public class ReserveFragment extends Fragment implements ReserveViewInter{
    private View view;
    private ReservePreInter reservePreInter;
    private User user;
    private Seat seat;
    private int type_temp;
    private static String TAG=ReserveFragment.class.getSimpleName();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_seat,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        reservePreInter=new ReservePreImpL(this);
        reservePreInter.getSeatInfo();
    }


    @Override
    public void initSeat(List<Seat[]> seats) {

//        List<Seat[]> seats=new ArrayList<>();
//        Seat[] seatLine=new Seat[5];
//
//        int i=0;
//        int j=1;
//        type_temp=1;
//
//        for(Seat seat:seatList){
//            //满一行或换楼层
//            if(i>4||seat.getFloor()!=type_temp){
//                seats.add(seatLine);
//                type_temp=seat.getFloor();
//                seatLine=new Seat[5];
//                i=0;
//            }
//            seatLine[i]=seat;
//            //座位添加完成
//            if(j==seatList.size()){
//                seats.add(seatLine);
//            }
//            ++i;
//            ++j;
//        }

        type_temp=1;
        RecyclerView recyclerView=view.findViewById(R.id.recycler_oneFloor);
        GeneralAdapter<Seat[]> adapter=new GeneralAdapter<Seat[]>(getContext(),R.layout.recycler_reserve_item,seats) {
            class ButtonListenner implements View.OnClickListener{
                @Override
                public void onClick(View v) {
                    switch(v.getId()){
                        case R.id.imgButt_seat_one:
                            Toaster.showShort(getContext(),"dwdwd");
                            break;
                        case R.id.imgButt_seat_two:
                            break;
                        case R.id.imgButt_seat_three:
                            break;
                        case R.id.imgButt_seat_fourth:
                            break;
                        case R.id.imgButt_seat_five:
                            break;
                    }
                }
            }
            @Override
            public void handle(GeneralHolder viewHolder, Seat[] data) {
                Log.i(TAG,"handle");
                //为不同楼层设置title
                if(type_temp!=data[0].getFloor()||data[0].getFloor()==1){
                    Log.i(TAG,"datas[0].getFloor():"+data[0].getFloor());
                    TextView titleText=viewHolder.handleView(R.id.text_title);
                    titleText.setText(String.valueOf(data[0].getFloor()+"楼"));
                    viewHolder.handleView(R.id.recycler_line).setVisibility(View.VISIBLE);
                    titleText.setVisibility(View.VISIBLE);
                    type_temp=data[0].getFloor();
                }else {
                    //同一楼层隐藏title
                    viewHolder.handleView(R.id.text_title).setVisibility(View.GONE);
                    viewHolder.handleView(R.id.recycler_line).setVisibility(View.GONE);
                }
                ImageButton[] seatButts=new ImageButton[]{viewHolder.handleView(R.id.imgButt_seat_one),viewHolder.handleView(R.id.imgButt_seat_two),
                        viewHolder.handleView(R.id.imgButt_seat_three), viewHolder.handleView(R.id.imgButt_seat_fourth),viewHolder.handleView(R.id.imgButt_seat_five)};
                for(ImageButton imageButton:seatButts){
                    imageButton.setOnClickListener(new ButtonListenner());
                }
                TextView[] seatNumTexts=new TextView[]{viewHolder.handleView(R.id.text_seat_num_one),viewHolder.handleView(R.id.text_seat_num_two),viewHolder.handleView(R.id.text_seat_num_three),
                        viewHolder.handleView(R.id.text_seat_num_fourth),viewHolder.handleView(R.id.text_seat_num_five)};
                TextView[] seatTimeTexts=new TextView[]{viewHolder.handleView(R.id.text_time_one),viewHolder.handleView(R.id.text_time_two),viewHolder.handleView(R.id.text_time_three),
                        viewHolder.handleView(R.id.text_time_fourth),viewHolder.handleView(R.id.text_time_five)};
                int i=0;
                for(Seat seat:data){
                    if(seat==null)
                        return;
                    Log.i(TAG,"seat_count");
                    seatButts[i].setVisibility(View.VISIBLE);
                    seatNumTexts[i].setVisibility(View.VISIBLE);
                    seatTimeTexts[i].setVisibility(View.VISIBLE);
                    switch (seat.getIdle()){
                        case 0:
                            seatButts[i].setBackground(getResources().getDrawable(R.drawable.seat,null));
                            break;
                        case 1:
                            seatButts[i].setBackground(getResources().getDrawable(R.drawable.seat_reserve,null));
                            break;
                        case 2:
                            seatButts[i].setBackground(getResources().getDrawable(R.drawable.seat_occupied,null));
                            break;
                        default:
                            seatNumTexts[i].setText(seat.getNumber());
                            seatTimeTexts[i].setText(seat.getTime()+seat.getStarttime());
                    }
                    ++i;
                }
            }
        };
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showReserveResult(String result) {
        Toaster.showShort(getContext(),result);
    }


}
