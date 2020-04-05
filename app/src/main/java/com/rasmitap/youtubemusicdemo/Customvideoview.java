package com.rasmitap.youtubemusicdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

public class Customvideoview extends VideoView {
    long lastPausedTime  = 0; // The time of the last pause (milliseconds)
    long totalPausedTime = 0; // The total time paused (milliseconds)
    private VideoView videoContainer;
    private String fileName;

    public Customvideoview(Context context, VideoView v) {
        super(context);
        videoContainer = (VideoView) v;

        fileName = "android.resource://" + context.getPackageName() + "/" + R.raw.a;
    }

    public Customvideoview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs);
    }
    public Customvideoview(Context context) {
        super(context);
    }


    public void setVideoPath(String path) {
        videoContainer.setVideoPath(path);
    }
    public void startVideo() {
        videoContainer.start();
    }



    @Override
    public void pause() {
        lastPausedTime = System.currentTimeMillis();

        super.pause();
    }

    @Override
    public void start() {
        if (lastPausedTime != 0) {
            totalPausedTime += System.currentTimeMillis() - lastPausedTime;
        }
        super.start();
    }

    public long getTotalTimeMillis() {
        return totalPausedTime;
    }

}
