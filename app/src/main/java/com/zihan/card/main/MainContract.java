package com.zihan.card.main;

import com.zihan.card.database.Card;

import java.util.List;

/**
 * Created by jilibing on 2016/6/17/0017.
 */
public class MainContract {

    public interface View {

        void getCardListSuccess(List<Card> cardList);
    }

    public interface Presenter {

        void getCardList();
    }
}
