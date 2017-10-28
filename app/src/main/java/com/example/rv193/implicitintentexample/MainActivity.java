package com.example.rv193.implicitintentexample;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/*
Remember to add the permissions for Internet
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showWebPage(View view) {
        int chosenItem = view.getId();
        Intent intent = new Intent(), chooser = null;

        switch(chosenItem) {
            case R.id.button_internet:
                /*

                 */
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.rvscript.com"));
                break;
            case R.id.button_map:
                /*
                step 1: Get the lattitude and longitude
                step 2: Create a URI with that
                step 3: Create an Intent object with ACTION_VIEW
                step 4: Tell the Intent object to handle the Uri data
                step 5: Create a chooser
                step 6: Launch the chooser
                 */
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:40.7849130, -73.9749630"));
                chooser = Intent.createChooser(intent, "Launch Maps");
                intent = chooser;
                break;
            case R.id.button_market:
                /*
                Step 1: Create the intent object with ACTION_VIEW
                Step 2: Create the Uri with the app you want to open
                Step 3: Set the Intent data to the above URI
                Step 4: Create a chooser to let the user decid which Activity should handle the intent
                Step 5: Launch the chooser
                 */
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("market://play.google.com/store/apps/details?id=com.marriott.mrt"));
                chooser = Intent.createChooser(intent, "Lauch Markets");
                intent = chooser;
                break;
            case R.id.button_email:
                /*
                Step 1: Create an intent Object with ACTION_SEND
                Step 2: Define the URI protocol as mailto:
                Step 3: Let the Intent object use the above protocol
                Step 4: Specify the Email subject, and message.
                step 5: Specify the Email MIME TYPE as rfc822 for email
                Step 6: Launch the chooser which can handle the Email intent
                 */
                intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                String[] to = {"rvscript@gmail.com", "rvguitarhero1@yahoo.com"};
                intent.putExtra(Intent.EXTRA_EMAIL, to);
                intent.putExtra(Intent.EXTRA_SUBJECT, "Dad android practice");
                intent.putExtra(Intent.EXTRA_TEXT, "Dad is testing code from android app practice");
                intent.setType("message/rfc822");
                chooser = Intent.createChooser(intent, "Choose Email handler");
                intent = chooser;
                break;

        }
        startActivity(intent);
    }
}
