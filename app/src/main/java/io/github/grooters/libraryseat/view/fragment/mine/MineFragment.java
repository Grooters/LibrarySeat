package io.github.grooters.libraryseat.view.fragment.mine;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import io.github.grooters.libraryseat.R;
import io.github.grooters.libraryseat.model.User;
import io.github.grooters.libraryseat.presenter.preinterface.MinePreInter;
import io.github.grooters.libraryseat.presenter.preinterfacel.MinePreImpL;
import io.github.grooters.libraryseat.view.viewinter.MineViewInter;

public class MineFragment extends Fragment implements MineViewInter{
    private View view;
    private MinePreInter minePreInter;
    private TextView nickNameText,nameText,signatureText,departmentText,majorText,numberText,timeText,numText;
    private ImageView avatarImg;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_mine,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        minePreInter=new MinePreImpL(this);
        nickNameText=view.findViewById(R.id.text_nickName);
        nameText=view.findViewById(R.id.text_name);
        signatureText=view.findViewById(R.id.text_signature);
        departmentText=view.findViewById(R.id.text_department);
        majorText=view.findViewById(R.id.text_major);
        numberText=view.findViewById(R.id.text_number);
        timeText=view.findViewById(R.id.text_time);
        avatarImg=view.findViewById(R.id.img_avatar);
        numText=view.findViewById(R.id.text_num);
        minePreInter.getUser();
    }

    @Override
    public void setInfo(User user) {
        nickNameText.setText(user.getNickName());
        nameText.setText(user.getName());
        signatureText.setText(user.getSignature());
        departmentText.setText(user.getDepartment());
        majorText.setText(user.getMajor());
        numberText.setText(String.valueOf(user.getSeatNumber()));
        numText.setText(String.valueOf(user.getNumber()));
        timeText.setText(String.valueOf(user.getTime()));
    }
}
