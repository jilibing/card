package com.zihan.card.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zihan.card.utils.EventBusUtils;

import butterknife.ButterKnife;

/**
 * Created by jilibing on 2016/6/17/0017.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected abstract int getContentView();

    protected abstract void init();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getContentView());

        ButterKnife.bind(this);

        EventBusUtils.getInstance().register(this);

        init();
    }

    @Override
    protected void onDestroy() {
        EventBusUtils.getInstance().unregister(this);
        super.onDestroy();
    }
}
