package io.github.grooters.libraryseat.presenter.preinterface;

import io.github.grooters.libraryseat.model.Seat;
import io.github.grooters.libraryseat.model.User;

/**
 * Create by 李林浪 in 2018/9/17
 * Elegant Code...
 */
public interface SitingDiaPreInter {
    /**
     * 预约座位
     * @param time 可占用时间
     */
    public void requestSeat(int time);

    /**
     * 在预约fragment中提供dialog用户点击了的座位信息
     * @param seat
     */
    public void provideInfo(Seat seat);

}
