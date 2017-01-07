package com.india.nitish.notificationex;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3;
    NotificationCompat.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // all notification are under the control of notification manager
        final NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // will display new notification
                builder = new NotificationCompat.Builder(MainActivity.this);
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setTicker("1 mail");
                builder.setContentTitle("Job");
                //setting large image
                BitmapDrawable myimage = (BitmapDrawable) getResources().getDrawable(R.drawable.bear);
                builder.setLargeIcon(myimage.getBitmap());
                builder.setContentText("Urgent Opening with IBM, please send resume! ");
                builder.setContentInfo("1 unread");

                builder.setAutoCancel(true); // once user clicks remove that notification
                //prepare intent to start same activity when click in notification
                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                PendingIntent p = PendingIntent.getActivity(MainActivity.this,
                                                                0, intent,0);
                builder.setContentIntent(p);



                //request notification manager to display notification
                notificationManager.notify(1,builder.build());

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setTicker("urgernt");
                builder.setContentTitle("from home");
                builder.setContentText("send money immediately.");
                notificationManager.notify(1,builder.build());
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //we will delete notification
                //notificationManager.cancel(1);  //remove 1st notification from area
                //notificationManager.cancelAll(); //remove all notifications

            }
        });
    }
}
