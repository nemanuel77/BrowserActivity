package temple.edu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class BrowserActivity extends AppCompatActivity implements PageControlFragment.getURLAddress, PageViewerFragment.sendURLToFragment {

    //define resources
    //Resources res = getResources();

    //define fragments to be used in application
    PageControlFragment PCF = new PageControlFragment();
    PageViewerFragment PVE = new PageViewerFragment();
    BrowserControlFragment BCF = new BrowserControlFragment();
    PageListFragment PLF = new PageListFragment();

    //fragment managing object
    FragmentManager fm;

    //boolean to check phone orientation(landscape/mobile)
    Boolean isLandscape;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //check for a container that is only drawn in landscape orientation.
        isLandscape = findViewById(R.id.page_list) != null;

        //initialize fragment manager
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

        if ((tempFragment = fm.findFragmentById(R.id.page_viewer)) instanceof PageViewerFragment)
            PVE = (PageViewerFragment) tempFragment;
        else{
            PVE = new PageViewerFragment();
            fm.beginTransaction()
                    .add(R.id.page_viewer, PVE)
                    .commit();
        }

        if((tempFragment = fm.findFragmentById(R.id.browser_control)) instanceof BrowserControlFragment)
            BCF = (BrowserControlFragment) tempFragment;
        else{
            BCF = new BrowserControlFragment();
            fm.beginTransaction()
                    .add(R.id.browser_control,BCF)
                    .commit();
        }


        //add another container and attach fragment to container if orientation is set to landscape.
        //1:09PM 10-31: Blank Fragments created, page_list attaches properly.
        //TODO: create a list in page_list, build fragments(all new fragments are currently blank)
        if(isLandscape)

            if((tempFragment = fm.findFragmentById(R.id.page_list)) instanceof  PageListFragment)
                PLF = (PageListFragment) tempFragment;
            else{

                fm.beginTransaction()
                        .add(R.id.page_list,PLF)
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