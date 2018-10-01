package io.github.grooters.libraryseat.view.viewinter;


import java.util.List;

import io.github.grooters.libraryseat.model.Seat;

public interface ReserveViewInter {

    public void showReserveResult(String result);

    public void initSeat(List<Seat[]> seatList);

}
