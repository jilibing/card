package com.zihan.card.main;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zihan.card.R;
import com.zihan.card.database.Card;
import com.zihan.card.detail.CardDetailActivity;
import com.zihan.card.utils.ImageLoaderUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jilibing on 2016/6/17/0017.
 */
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

    private List<Card> mDataList = new ArrayList<>(0);
    public CardAdapter() {

    }

    public void setDataList(List<Card> cardList) {
        this.mDataList.clear();
        this.mDataList.addAll(cardList);
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
        private ImageView iv_img;
        ViewGroup vg_card;
        ViewGroup vg_title;

        ViewGroup vg_test1, vg_test2, vg_test3, vg_test4, vg_test5;
        TextView tv_test1, tv_test1_2, tv_test2, tv_test2_2, tv_test3, tv_test3_2, tv_test4, tv_test4_2, tv_test5, tv_test5_2;

        public CardViewHolder(View itemView) {
            super(itemView);

            vg_card = (ViewGroup) itemView.findViewById(R.id.vg_card);
            vg_title = (ViewGroup) itemView.findViewById(R.id.vg_title);

            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            cardView = (CardView) itemView.findViewById(R.id.cardView);
            iv_img = (ImageView) itemView.findViewById(R.id.iv_img);

            vg_test1 = (ViewGroup) itemView.findViewById(R.id.vg_test1);
            tv_test1 = (TextView) itemView.findViewById(R.id.tv_test1);
            tv_test1_2 = (TextView) itemView.findViewById(R.id.tv_test1_2);

            vg_test2 = (ViewGroup) itemView.findViewById(R.id.vg_test2);
            tv_test2 = (TextView) itemView.findViewById(R.id.tv_test2);
            tv_test2_2 = (TextView) itemView.findViewById(R.id.tv_test2_2);

            vg_test3 = (ViewGroup) itemView.findViewById(R.id.vg_test3);
            tv_test3 = (TextView) itemView.findViewById(R.id.tv_test3);
            tv_test3_2 = (TextView) itemView.findViewById(R.id.tv_test3_2);

            vg_test4 = (ViewGroup) itemView.findViewById(R.id.vg_test4);
            tv_test4 = (TextView) itemView.findViewById(R.id.tv_test4);
            tv_test4_2 = (TextView) itemView.findViewById(R.id.tv_test4_2);

            vg_test5 = (ViewGroup) itemView.findViewById(R.id.vg_test5);
            tv_test5 = (TextView) itemView.findViewById(R.id.tv_test5);
            tv_test5_2 = (TextView) itemView.findViewById(R.id.tv_test5_2);

        }

        public void setData(final Card card) {

            tv_test2.setText(card.title);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CardDetailActivity.launch(view.getContext(), card);
                }
            });

            cardView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    new AlertDialog.Builder(view.getContext()).setTitle("删除这条记录吗？")
                            .setPositiveButton("删除", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    card.delete();
                                    mDataList.remove(card);
                                    notifyDataSetChanged();


                                }
                            })
                            .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            })
                            .show();
                    return true;
                }
            });

            if(TextUtils.isEmpty(card.pic)) {
                iv_img.setVisibility(View.GONE);
            }else {
                iv_img.setVisibility(View.VISIBLE);

                ImageLoaderUtils.display(iv_img, card.pic, new ImageLoaderUtils.OnLoadComplete() {
                    @Override
                    public void loadComplete() {

                        ////



                        ////
                    }
                });
            }

/*
            ///
            BitmapDrawable bitmapDrawable = (BitmapDrawable) iv_img.getDrawable();
            Palette.generateAsync(bitmapDrawable.getBitmap(),  new Palette.PaletteAsyncListener() {
                @Override
                public void onGenerated(Palette palette) {
                    // Here's your generated palette
                    /*
                    Palette.Swatch swatch1 = palette.getVibrantSwatch();
                    if (swatch1 != null) {
                        vg_test1.setBackgroundColor(swatch1.getBodyTextColor());
                        tv_test1.setTextColor(swatch1.getRgb());
                        tv_test1_2.setTextColor(swatch1.getTitleTextColor());

                        Logger.d("1");
                    }
*/
            /*
                    Palette.Swatch swatch2 = palette.getLightVibrantSwatch();
                    if(swatch2 != null) {//ok
                        vg_test2.setBackgroundColor(swatch2.getBodyTextColor());
                        tv_test2.setTextColor(swatch2.getRgb());
                        tv_test2_2.setTextColor(swatch2.getTitleTextColor());

                        Logger.d("2");
                    }
                    */
/*
                    Palette.Swatch swatch3 = palette.getMutedSwatch();
                    if(swatch3 != null) {//同上
                        vg_test3.setBackgroundColor(swatch3.getBodyTextColor());
                        tv_test3.setTextColor(swatch3.getRgb());
                        tv_test3_2.setTextColor(swatch3.getTitleTextColor());

                        Logger.d("3");
                    }

                    Palette.Swatch swatch4 = palette.getLightMutedSwatch();
                    if(swatch4 != null) {
                        vg_test4.setBackgroundColor(swatch4.getBodyTextColor());
                        tv_test4.setTextColor(swatch4.getRgb());
                        tv_test4_2.setTextColor(swatch4.getTitleTextColor());

                        Logger.d("4");
                    }

                    Palette.Swatch swatch5 = palette.getDarkMutedSwatch();
                    if(swatch5 != null) {
                        vg_test5.setBackgroundColor(swatch5.getBodyTextColor());
                        tv_test5.setTextColor(swatch5.getRgb());
                        tv_test5_2.setTextColor(swatch5.getTitleTextColor());

                        Logger.d("5");
                    }
*/
            /*
                }
            });

            ///

            */
        }
    }
}
