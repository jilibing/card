package com.zihan.card.detail;

import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import android.widget.ImageView;

import com.zihan.card.R;
import com.zihan.card.base.BaseActivity;
import com.zihan.card.model.CardInfo;

import butterknife.BindView;

public class CardDetailActivity extends BaseActivity {

    @BindView(R.id.iv_img)
    ImageView mIvImg;

    @BindView(R.id.et_title)
    EditText mEtTitle;

    private CardInfo mCardInfo;

    public static void launch(Context context, CardInfo cardInfo) {
        Intent intent = new Intent(context, CardDetailActivity.class);
        intent.putExtra("card_info", cardInfo);
        context.startActivity(intent);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_card_detail;
    }

    @Override
    protected void init() {
        mCardInfo = (CardInfo) getIntent().getSerializableExtra("card_info");
        if(mCardInfo != null) {
            mEtTitle.setText(mCardInfo.title);
            mEtTitle.setSelection(mCardInfo.title.length());
        }
    }
}
