package com.zihan.card.main;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zihan.card.R;
import com.zihan.card.detail.CardDetailActivity;
import com.zihan.card.model.CardInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jilibing on 2016/6/17/0017.
 */
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

    private List<CardInfo> mDataList = new ArrayList<>(0);
    public CardAdapter() {

    }

    public void setDataList(List<CardInfo> cardInfoList) {
        this.mDataList.clear();
        this.mDataList.addAll(cardInfoList);
        notifyDataSetChanged();
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CardViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_card, parent, false));
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        holder.setData(mDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    class CardViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_title;
        private CardView cardView;

        public CardViewHolder(View itemView) {
            super(itemView);

            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            cardView = (CardView) itemView.findViewById(R.id.cardView);


        }

        public void setData(final CardInfo cardInfo) {
            tv_title.setText(cardInfo.title);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CardDetailActivity.launch(view.getContext(), cardInfo);
                }
            });

        }
    }
}
