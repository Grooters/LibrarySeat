package io.github.grooters.libraryseat.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import io.github.grooters.libraryseat.R;
import io.github.grooters.libraryseat.base.BaseActivity;
import io.github.grooters.libraryseat.view.fragment.reserve.ReserveFragment;

public class ReserveActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container_fragment);
    }

    @Override
    public Fragment createFragment() {
        return new ReserveFragment();
    }
}
