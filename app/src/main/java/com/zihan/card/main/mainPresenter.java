package com.zihan.card.main;

import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.zihan.card.database.Card;
import com.zihan.card.database.Card_Table;

import java.util.List;

/**
 * Created by jilibing on 2016/6/17/0017.
 */
public class MainPresenter implements MainContract.Presenter {

    MainContract.View mMainView;
    public MainPresenter(MainContract.View view) {
        mMainView = view;
    }

    @Override
    public void getCardList() {
        List<Card> cardList = SQLite.select().from(Card.class)
                .orderBy(Card_Table.id, false) // 排序
                .queryList();
        mMainView.getCardListSuccess(cardList);
    }
}
