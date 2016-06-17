package com.zihan.card.main;

import com.zihan.card.model.CardInfo;

import java.util.List;

/**
 * Created by jilibing on 2016/6/17/0017.
 */
public class MainContract {

    public interface View {

        void getCardListSuccess(List<CardInfo> cardInfoList);
    }

    public interface Presenter {

        void getCardList();
    }
}
