package com.rasmitap.youtubemusicdemo;

import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = (VideoView) findViewById(R.id.videoview);
        String uriPath = "android.resource://"+getPackageName()+"/"+R.raw.a;
        Uri uri = Uri.parse(uriPath);
        videoView.setVideoURI(uri);

        MediaController media=new MediaController(this);
        videoView.setMediaController(media);
        media.setAnchorView(videoView);
        videoView.start();
//        String videopath = "android.resource://" + getPackageCodePath() + "/" + R.raw.a;
//        Uri uri = Uri.parse(Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+R.raw.a);
//        videoView.setVideoURI(uri);

//        videoView.requestFocus();
//        videoView.start();


    }

}
