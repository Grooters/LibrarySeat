package io.github.grooters.libraryseat.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import io.github.grooters.libraryseat.R;


public abstract class BaseActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager manager=getSupportFragmentManager();
        Fragment fragment=createFragment();
        if(fragment!=null){
            manager.beginTransaction().replace(R.id.frame_fragment,fragment).commit();

        }
    }
    public void commit(Fragment fragment){
        if(fragment==null){
            return;
        }
        FragmentManager manager=getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.frame_fragment,fragment).commit();
    }
    public abstract Fragment createFragment();
}
