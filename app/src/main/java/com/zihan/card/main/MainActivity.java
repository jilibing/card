package com.zihan.card.main;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.orhanobut.logger.Logger;
import com.zihan.card.R;
import com.zihan.card.base.BaseActivity;
import com.zihan.card.detail.CardDetailActivity;
import com.zihan.card.model.CardInfo;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainContract.View{

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @BindView(R.id.floatingActionButton)
    FloatingActionButton mFloatingActionButton;

    @OnClick(R.id.floatingActionButton)
    void clickFloatingActionButton() {
        CardDetailActivity.launch(this, null);
    }

    private MainPresenter mMainPresenter;
    private CardAdapter mCardAdapter;

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        Logger.d("init");
        mCardAdapter = new CardAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mRecyclerView.setAdapter(mCardAdapter);

        mMainPresenter = new MainPresenter(this);
        mMainPresenter.getCardList();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle("卡包");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));

        setSupportActionBar(toolbar);
    }

    @Override
    public void getCardListSuccess(List<CardInfo> cardInfoList) {
        mCardAdapter.setDataList(cardInfoList);
    }
}
