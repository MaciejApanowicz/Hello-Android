package pl.maciejapanowicz.silentmodetoggle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    /** Called when the activity is first created*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     /* Initialize our layout using the res/layout/activity_main.xml*/
     /* layout file that contains our views for this activity */
        setContentView(R.layout.activity_main);
    }
}
