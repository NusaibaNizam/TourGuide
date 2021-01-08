package org.a55889966.bleach.saran.tourguide;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;


public class TourMate extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
