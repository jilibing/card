package com.zihan.card.main;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.orhanobut.logger.Logger;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.zihan.card.R;
import com.zihan.card.base.BaseActivity;
import com.zihan.card.database.Card;
import com.zihan.card.detail.CardDetailActivity;
import com.zihan.card.model.CardInfo;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainContract.View {

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


        FlowManager.init(new FlowConfig.Builder(getApplicationContext()).build());



        List<Card> cardList = SQLite.select().from(Card.class).queryList();
        Logger.d("cardList.size():" + cardList.size());

        try {
            Card card = new Card();
            card.title = "222";
            card.testCol = "ddd";
            card.save();

        } catch (Exception e) {
            Logger.d("e:"+e.getLocalizedMessage());
        }

        List<Card> cardList2 = SQLite.select().from(Card.class).queryList();

        for (int i=0; i<cardList2.size(); i++) {
            Logger.d("i:"+(i+1) + " card:"+ cardList2.get(i));
        }
    }

    @Override
    public void getCardListSuccess(List<CardInfo> cardInfoList) {
        mCardAdapter.setDataList(cardInfoList);
    }
}
