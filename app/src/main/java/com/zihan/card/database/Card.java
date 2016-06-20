package com.zihan.card.database;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ModelContainer;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by jilibing on 2016/6/20/0020.
 */
@Table(database = AppDatabase.class)
@ModelContainer
public class Card extends BaseModel {

    @Column
    @PrimaryKey(autoincrement = true)
    public long id;

    @Column
    public String title;

    @Column
    public String pic;

    @Column
    public String testCol;

    @Override
    public String toString() {
        return "id:"+id+" title:"+title+" pic:"+pic+" testCol:"+testCol;
    }
}
