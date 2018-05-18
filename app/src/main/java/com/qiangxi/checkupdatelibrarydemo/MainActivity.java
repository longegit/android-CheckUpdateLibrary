package com.qiangxi.checkupdatelibrarydemo;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.qiangxi.checkupdatelibrary.CheckUpdateOption;
import com.qiangxi.checkupdatelibrary.Q;
import com.qiangxi.checkupdatelibrary.callback.DownloadCallback;
import com.qiangxi.checkupdatelibrary.callback.StringCallback;
import com.qiangxi.checkupdatelibrary.imageloader.ImageLoader;
import com.qiangxi.checkupdatelibrary.utils.L;

import java.io.File;

public class MainActivity extends AppCompatActivity implements ImageLoader, StringCallback, DownloadCallback {

    private static final String API = "http://v.juhe.cn/historyWeather/province";
    private static final String PATH = Environment.getExternalStorageDirectory().getPath() + "/checkupdatelib";
    private static final String NAME = "/demo.apk";
    private static final String DOWNLOAD = "http://f4.market.xiaomi.com/download/AppStore/09a8d44bf3f4925837eae2b699d36ce8bcd4169c9/com.tencent.mobileqq.apk";
    private static final String IMAGE_URL = "http://imgsrc.baidu.com/imgad/pic/item/6c224f4a20a446233d216c4f9322720e0cf3d730.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void updateDialogClick(View view) {
        Q.show(this, generateOption(), this);
    }

    private CheckUpdateOption generateOption() {
        return new CheckUpdateOption.Builder()
                .setAppName("CheckUpdateLib-2.0")
                .setFileName(NAME)
                .setFilePath(PATH)
                .setImageUrl(IMAGE_URL)
                .setIsForceUpdate(false)
                .setNewAppSize(14)
                .setNewAppUpdateDesc("1.更新了好多东西\n1.更新了好多东西\n1.更新了好多东西")
                .setNewAppUrl(DOWNLOAD)
                .setNewAppVersionName("2.0")
                .setNotificationSuccessContent("下载成功，点击安装")
                .setNotificationFailureContent("下载失败，点击重新下载")
                .setNotificationIconResId(R.mipmap.ic_launcher)
                .setNotificationTitle("checkupdateSample")
                .build();
    }

    @Override
    public void checkUpdateStart() {
        L.e("checkUpdateStart...+Thread=" + Thread.currentThread());
    }

    @Override
    public void checkUpdateFailure(Throwable t) {
        L.e("checkUpdateFailure...+t=" + t.toString() + ",thread=" + Thread.currentThread());
    }

    @Override
    public void checkUpdateFinish() {
        L.e("checkUpdateFinish...+Thread=" + Thread.currentThread());
    }

    @Override
    public void checkUpdateSuccess(String json) {
        L.e("checkUpdateSuccess...+json=" + json + ",thread=" + Thread.currentThread());
    }

    @Override
    public void downloadProgress(long currentLength, long totalLength) {
        L.e("downloadProgress...+currentLength=" + currentLength + ",totalLength=" + totalLength + ",thread=" + Thread.currentThread());
    }

    @Override
    public void downloadSuccess(File apk) {
        L.e("downloadSuccess...+apk.size=" + apk.length() + ",thread=" + Thread.currentThread());
    }

    @Override
    public void loadImage(ImageView view, String imageUrl) {

    }
}

