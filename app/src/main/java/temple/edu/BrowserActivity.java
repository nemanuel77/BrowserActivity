package temple.edu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.res.Resources;
import android.os.Bundle;

public class BrowserActivity extends AppCompatActivity {

    //define resources
    //Resources res = getResources();
    PageControlFragment PCF = new PageControlFragment();
    PageViewerElement PVE = new PageViewerElement();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize fragments

        FragmentManager fm = getSupportFragmentManager();

        fm
                .beginTransaction()
                .add(R.id.page_control, PCF)
                .add(R.id.page_viewer, PVE)
                .commit();






    }
}