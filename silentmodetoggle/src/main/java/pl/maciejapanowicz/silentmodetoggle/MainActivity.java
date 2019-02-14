package pl.maciejapanowicz.silentmodetoggle;

import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import pl.maciejapanowicz.silentmodetoggle.util.RingerHelper;

public class MainActivity extends AppCompatActivity {
    AudioManager audioManager;

    /** Called when the activity is first created*/
    /* This method is called to initialize the activity after the java constructor for this class
    has been called. This is typically where you would call setContentView to inflate your layout,
    and findViewById to initialize your views.
    @param savedInstanceState contains additional data about the saved state of the activity
    if it was previously shutdown and is now being re-created from saved state.*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Always call super.OnCreate () first.
        super.onCreate(savedInstanceState);
        //Get a reference to Android's AudioManager so we can use it to toggle our ringer.
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        Log.d("SilentModeApp", "This is a test");
        /* Initialize our layout using the res/layout/activity_main.xml
           layout file that contains our views for this activity */
        setContentView(R.layout.activity_main);

        //  Find the view with ID (named) "content" in our layout file.
        FrameLayout contentView = (FrameLayout) findViewById(R.id.content);

        /*  Create a click listener for the contentView that will toggle the phone's ringer state,
        and then update the UI to reflect the new state. */

        contentView.setOnClickListener(new View.OnClickListener() {
        public void onClick (View v) {

            /*Toggle the ringer mode. If it's currently normal make it silent.
            If it's currently silent, do the opposite.*/

            RingerHelper.performToggle(audioManager);
            updateUI();
        }
    });
    }

    /**
     * Updates the UI image to show an image representing silent or normal, as appropriate
     */

    private void updateUI() {
        /*  Find the view named phone_icon in our layout. We know it's an ImageView in the layout,
         so downcast it to an ImageView */
        ImageView imageView = (ImageView) findViewById(R.id.phone_icon);

        /* Set phoneImage to the ID of the image that represents ringer on or off.
        These are found in res/drawable-xxdpi*/
        int phoneImage = RingerHelper.isPhoneSilent(audioManager)
                ? R.mipmap.ringer_on
                : R.mipmap.ringer_off;

        //set the imageView to the image in phoneImage
        imageView.setImageResource(phoneImage);
    }

    /**
     * Every time the activity is resumed, make sure to update the buttons to reflect the current
     * state of the system (since the user may have changed the phone's silent state while we
     * were in the background)
     */
    @Override
    protected void onResume() {
        super.onResume();
        //Update our UI in case anything has changed
        updateUI();
    }
}
