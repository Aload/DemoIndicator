package economic.gaokong.com.demoindicator;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

/**
 * @author Autism
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        //TODO nothing
    }

    /**
     * 初始化view
     */
    private void initView() {
        String[] mTitle = getResources().getStringArray(R.array.demo);
        ViewPagerIndicator mIndicator = (ViewPagerIndicator) findViewById(R.id.demo_indicator);
        ViewPager mPager = (ViewPager) findViewById(R.id.demo_pager);
        mPager.setAdapter(new DemoAdapter(getSupportFragmentManager(),mTitle));
        mIndicator.setViewPager(mPager,0);
        mIndicator.setTabTips(0,5);
        mIndicator.setTabTips(1,10);
        mIndicator.setTabTips(2,2);
    }
}
