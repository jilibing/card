package com.zihan.card.database;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by jilibing on 2016/6/20/0020.
 */
@Database(name = AppDatabase.NAME, version = AppDatabase.VERSION)
public class AppDatabase {

    public static final String NAME = "Card";

    public static final int VERSION = 4;
}