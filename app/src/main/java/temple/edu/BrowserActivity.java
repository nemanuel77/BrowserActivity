package temple.edu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class BrowserActivity extends AppCompatActivity implements PageControlFragment.getURLAddress {

    //define resources
    //Resources res = getResources();
    //PageControlFragment PCF = new PageControlFragment();
    PageViewerElement PVE = new PageViewerElement();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize fragments

        FragmentManager fm = getSupportFragmentManager();

        fm
                .beginTransaction()
                .add(R.id.page_control, PageControlFragment.newInstance())
                .add(R.id.page_viewer, PVE)
                .addToBackStack(null)
                .commit();


    }

    @Override
    public void sendURL(String string) {
        PVE.getURLFromParent(string);
    }
}