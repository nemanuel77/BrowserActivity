package temple.edu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class BrowserActivity extends AppCompatActivity implements PageControlFragment.getURLAddress, PageViewerElement.sendURLToFragment {

    //define resources
    //Resources res = getResources();
    PageControlFragment PCF = new PageControlFragment();
    PageViewerElement PVE = new PageViewerElement();
    FragmentManager fm;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize fragments

        fm = getSupportFragmentManager();
        Fragment tempFragment;

        if ((tempFragment = fm.findFragmentById(R.id.page_control)) instanceof  PageControlFragment)
            PCF = (PageControlFragment) tempFragment;
        else{
            PCF = new PageControlFragment();
            fm.beginTransaction()
                    .add(R.id.page_control, PCF)
                    .commit();
        }

        if ((tempFragment = fm.findFragmentById(R.id.page_viewer)) instanceof PageViewerElement)
            PVE = (PageViewerElement) tempFragment;
        else{
            PVE = new PageViewerElement();
            fm.beginTransaction()
                    .add(R.id.page_viewer, PVE)
                    .commit();
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