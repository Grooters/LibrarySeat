package io.github.grooters.libraryseat.view.fragment.start;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import io.github.grooters.libraryseat.R;
import io.github.grooters.libraryseat.presenter.preinterface.StartPreInter;
import io.github.grooters.libraryseat.presenter.preinterfacel.StartPreImpL;
import io.github.grooters.libraryseat.view.activity.LoginActivity;
import io.github.grooters.libraryseat.view.viewinter.StartViewInter;

public class StartFragment extends Fragment implements StartViewInter,View.OnClickListener{
    private View view;
    private StartPreInter startPreInter;
    private TextView jumpText;
    private ImageButton jumButton;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_start,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        startPreInter=new StartPreImpL(this);
        jumpText=view.findViewById(R.id.text_jump);
        jumButton=view.findViewById(R.id.butt_jump);
        jumButton.setOnClickListener(this);
        startPreInter.loadStart();
        startPreInter.jumpLogin(3);
    }

    @Override
    public void startLogin() {
        Intent intent=new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void setCountdown(final int seconds) {
        if (getActivity()==null) return;
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                jumpText.setText(" "+seconds);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.butt_jump:
                startPreInter.jumpLogin(0);
                break;
        }
    }

    @Override
    public void loadAnima() {

    }
}
