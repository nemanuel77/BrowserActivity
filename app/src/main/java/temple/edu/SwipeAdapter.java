package temple.edu;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class SwipeAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> myFragmentList;

    public SwipeAdapter(@NonNull FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.myFragmentList = fragmentList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return myFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return myFragmentList.size();
    }
}
