package com.zihan.card.main;

import com.zihan.card.model.CardInfo;

import java.util.ArrayList;
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
        List<CardInfo> cardInfoList = new ArrayList<>(10);
        for (int i=0; i<10; i++) {
            CardInfo cardInfo = new CardInfo();
            cardInfo.title = "卡片是包含一组特定数据集的纸片，数据集含有各种相关信息，例如，关于单一主题的照片，文本，和链接。卡片通常是通往更详细复杂信息的入口。卡片有固定的宽度和可变的高度";
            cardInfoList.add(cardInfo);
        }

        mMainView.getCardListSuccess(cardInfoList);
    }
}
