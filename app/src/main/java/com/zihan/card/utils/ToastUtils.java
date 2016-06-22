package com.zihan.card.utils;

import android.widget.Toast;

import com.zihan.card.CardApp;

/**
 * Created by jilibing on 2016/6/22/0022.
 */
public class ToastUtils {

    private static Toast sToast;

    private static Toast getToast(String msg) {
        if (sToast == null) {
            sToast = Toast.makeText(CardApp.getsAppContext(), msg, Toast.LENGTH_SHORT);
        }else {
            sToast.setText(msg);
        }
        return sToast;
    }

    public static void show(final String msg) {
        HandlerUtils.post(new Runnable() {
            @Override
            public void run() {
                getToast(msg).show();
            }
        });
    }
}