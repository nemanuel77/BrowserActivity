package temple.edu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class BrowserActivity extends AppCompatActivity implements PageControlFragment.getURLAddress, PageViewerElement.sendURLToFragment {

    //define resources
    //Resources res = getResources();
    PageControlFragment PCF = new PageControlFragment();
    PageViewerElement PVE = new PageViewerElement();
    int pcfID = 0;
    int pveID = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize fragments

        if (savedInstanceState == null) {
            PCF = PageControlFragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.page_control, PCF)
                    .commit();

            PVE = PageViewerElement.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.page_viewer, PVE)
                    .commit();


        } else {

            PVE = (PageViewerElement) getSupportFragmentManager()
                    .findFragmentById(R.id.page_viewer);


        }
    }

    @Override
    public void sendURL(String string) {
        PVE.getURLFromParent(string);
    }

    @Override
    public void goBack() {
        PVE.goBack();
    }

    @Override
    public void goForward() {
        PVE.goForward();
    }

    @Override
    public void sendURLToTxt(String string) {
        PCF.getNewURL(string);
    }
}