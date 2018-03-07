package com.assignment;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // init layout
        setContentView(R.layout.activity_main);
    }

    //this Method will create InboxStyleNotification
    public void sendInboxStyleNotification(View view) {
        Notification notification = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            long when = System.currentTimeMillis();//currentTimeMillis (). Returns the current time in milliseconds
            notification = new Notification.InboxStyle(new Notification.Builder(MainActivity.this)
                    .setTicker("Incomming Message")//setting Ticker it adda a rich notification style to be applied at build time
                    .setSmallIcon(R.mipmap.ic_launcher)//sets icon image
                    .setWhen(when)
                    .setContentTitle("Details...")//sets details
                    .setContentText("Inbox Style")//sets content Text
                    .setNumber(6)//sets numbers of messages that i want to print
                    .setContentIntent(getPendingIntent()))// set pending Intent
                    .addLine("Helloo..!")
                    .addLine("How are you?")
                    .addLine("HIII !!")
                    .addLine("i am fine...")
                    .addLine("what about you? all is well?")
                    .addLine("Yes, every thing is all right..")
                    .setBigContentTitle("Incomming Messages")//sets title
                    .build();
            notification.flags |= Notification.FLAG_AUTO_CANCEL;
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(17, notification);//notify here
        }
    }

    //Creating PendingIntent Method()
    public PendingIntent getPendingIntent() {//pendingIntent is clicking of the notification where we want to go
        Intent resultIntent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);

        // Adds the back stack for the Intent
        stackBuilder.addParentStack(MainActivity.class);

        // Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,
                PendingIntent.FLAG_UPDATE_CURRENT);
        return resultPendingIntent;
    }
}
