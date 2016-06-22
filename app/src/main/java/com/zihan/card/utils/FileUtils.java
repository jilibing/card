package com.zihan.card.utils;

import android.os.Environment;

import com.orhanobut.logger.Logger;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jilibing on 2016/6/22/0022.
 */
public class FileUtils {

    public static String CARD = "cardPackage";

    public static String getCardPath() {
        File dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + CARD);
        if(!dir.exists()) {
            dir.mkdirs();
        }

        try {
            return dir.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static File createImageFile() {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        try {
            File imageFile = new File(getCardPath() + File.separator + timeStamp + ".jpg");
            Logger.e("path:"+imageFile.getCanonicalPath());
            return imageFile;
        } catch (Exception e) {
            return null;
        }
    }




}
