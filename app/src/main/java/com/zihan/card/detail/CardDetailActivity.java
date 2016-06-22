package com.zihan.card.detail;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.orhanobut.logger.Logger;
import com.zihan.card.R;
import com.zihan.card.base.BaseActivity;
import com.zihan.card.database.Card;
import com.zihan.card.event.UpdateCardListEvent;
import com.zihan.card.utils.EventBusUtils;
import com.zihan.card.utils.FileUtils;
import com.zihan.card.utils.ImageLoaderUtils;
import com.zihan.card.utils.ToastUtils;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;

public class CardDetailActivity extends BaseActivity {

    @BindView(R.id.iv_img)
    ImageView mIvImg;

    @BindView(R.id.et_title)
    EditText mEtTitle;

    public final static int BIG_CAPTURE = 1;
    public final static int REQUEST_IMAGE = 2;

    private String mPicPath;
    private Uri outputFileUri;

    @OnClick(R.id.iv_img)
    void addImg() {
        File file = FileUtils.createImageFile();
        if(file == null) {
            ToastUtils.show("创建文件失败！");
            return;
        }

        if(false) {
            outputFileUri = Uri.fromFile(file);
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(intent, BIG_CAPTURE);
            }
        }else {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, REQUEST_IMAGE);
        }



    }

    private Card mCardInfo;

    public static void launch(Context context, Card card) {
        Intent intent = new Intent(context, CardDetailActivity.class);
        intent.putExtra("card_info", card);
        context.startActivity(intent);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_card_detail;
    }

    @Override
    protected void init() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle("卡包");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));

        setSupportActionBar(toolbar);

        mCardInfo = (Card) getIntent().getSerializableExtra("card_info");
        if (mCardInfo != null) {
            mEtTitle.setText(mCardInfo.title);
            mEtTitle.setSelection(mCardInfo.title.length());

            if(!TextUtils.isEmpty(mCardInfo.pic)) {
                ImageLoaderUtils.display(mIvImg, mCardInfo.pic);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_ok:

                String title = mEtTitle.getEditableText().toString();
                if (TextUtils.isEmpty(title)) {
                    Toast.makeText(CardDetailActivity.this, "内容为空", Toast.LENGTH_SHORT).show();
                    return true;
                }

                if(mCardInfo == null) {
                    mCardInfo = new Card();
                }

                mCardInfo.title = title;
                if(!TextUtils.isEmpty(mPicPath)) {
                    mCardInfo.pic = mPicPath;
                }
                mCardInfo.save();

                EventBusUtils.getInstance().post(new UpdateCardListEvent());

                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Logger.i("onActivityResult requestCode:"+resultCode+" requestCode:"+requestCode);
        if(resultCode == RESULT_OK && requestCode== BIG_CAPTURE){
            Logger.i("outputFileUri:" + outputFileUri);
            mPicPath = outputFileUri.getPath();
            ImageLoaderUtils.display(mIvImg, mPicPath);
        }

        if (resultCode == RESULT_OK && requestCode == REQUEST_IMAGE) {
            Logger.i("GalleryUri:" + data.getData());
            mPicPath = data.getData().getPath();
            ImageLoaderUtils.display(mIvImg, mPicPath);
        }
    }
}
