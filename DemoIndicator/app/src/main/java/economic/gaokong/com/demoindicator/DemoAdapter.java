package economic.gaokong.com.demoindicator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Autism on 2016/5/30.
 */
public class DemoAdapter extends FragmentStatePagerAdapter {

    private String [] mTitles;

    public DemoAdapter(FragmentManager fm) {
        super(fm);
    }

    public DemoAdapter (FragmentManager mFm,String[]mTitle){
        this(mFm);
        mTitles=mTitle;
    }

    @Override
    public Fragment getItem(int position) {
        return FraManager.getFragment(position);
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
