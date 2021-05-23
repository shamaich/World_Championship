package com.shamaich.worldchampionship.rannable;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.shamaich.worldchampionship.view.MainActivity;

public class SplashActivityRun implements Runnable {

    private Context context;
    private Activity activity;

    public SplashActivityRun(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
    }

    @Override
    public void run() {
        Intent intent = new Intent(activity, MainActivity.class);
        context.startActivities(new Intent[]{intent});
        activity.finish();
    }
}
