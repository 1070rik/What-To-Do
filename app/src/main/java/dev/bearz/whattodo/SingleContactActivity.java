package dev.bearz.whattodo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class SingleContactActivity  extends Activity {

    // JSON node keys
    private static final String TAG_THING = "Thing";
    private static final String TAG_PLACE = "Place";
    private static final String TAG_TIME = "Time";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_contact);

        // getting intent data
        Intent in = getIntent();

        // Get JSON values from previous intent
        String name = in.getStringExtra(TAG_THING);
        String email = in.getStringExtra(TAG_PLACE);
        String mobile = in.getStringExtra(TAG_TIME);

        // Displaying all values on the screen
        TextView lblName = (TextView) findViewById(R.id.thing);
        TextView lblEmail = (TextView) findViewById(R.id.place);
        TextView lblMobile = (TextView) findViewById(R.id.time);



        lblMobile.setMovementMethod(new ScrollingMovementMethod());


        lblName.setText(name);
        lblEmail.setText(email);
        lblMobile.setText(mobile);
        ImageView imageView = (ImageView) findViewById(R.id.event);
        URL url = null;
        try {
            url = new URL("http://media.hugo.events/events/766/jazzout_2015__header_1436357115.jpg");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Bitmap bmp = null;
        try {
            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
       imageView.setImageBitmap(bmp);
    }
}