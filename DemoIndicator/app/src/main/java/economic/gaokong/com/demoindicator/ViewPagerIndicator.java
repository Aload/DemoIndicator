package economic.gaokong.com.demoindicator;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * @author Autism
 *         <p/>
 *         自定义的viewpagerIndicator
 */
public class ViewPagerIndicator extends RelativeLayout implements ViewPager.OnPageChangeListener {
    private LinearLayout mConnainer;
    //    private LazyViewPager mViewPager;
    private ViewPager mViewPager;
    private PagerAdapter mAdapter;
    private int mCurrentIndex;
    private ViewPager.OnPageChangeListener mListener;


    public ViewPagerIndicator(Context context) {
        this(context, null);
    }

    public ViewPagerIndicator(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ViewPagerIndicator(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    private void initView() {
        View.inflate(getContext(), R.layout.view_pager_indicator, this);
        mConnainer = (LinearLayout) findViewById(R.id.container);
    }

    /**
     * 设置viewpager
     *
     * @param viewPager
     * @param select
     */
    public void setViewPager(ViewPager viewPager, int select) {
        mViewPager = viewPager;
        if (null != mViewPager) {
            mAdapter = mViewPager.getAdapter();
            initPagerData(select);
        }
    }

    /**
     * 初始化选中条目
     *
     * @param select
     */
    private void initPagerData(int select) {
        mConnainer.removeAllViews();
        setVisibility(VISIBLE);
        OnClickListener listener = new OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer tags = (Integer) view.getTag();
                int tag = tags.intValue();
                if (tag < mAdapter.getCount()) {
                    mViewPager.setCurrentItem(tag);
                }
            }
        };
        for (int i = 0; i < mAdapter.getCount(); i++) {
            CharSequence pageTitle = mAdapter.getPageTitle(i);
            TabView tabview = new TabView(getContext(), pageTitle);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LayoutParams.MATCH_PARENT, 1);

            tabview.setGravity(Gravity.CENTER);
            tabview.setTag(i);

            mConnainer.addView(tabview, params);

            if (i == select) {
                tabview.setSelected(true);
                mViewPager.setCurrentItem(i);
            }
            tabview.setOnClickListener(listener);
            mViewPager.setOnPageChangeListener(this);
            tabview.setLayoutParams(params);
        }
    }

    private void selectedCurrent(int tag) {
        if (tag == mCurrentIndex) {
            return;
        }
        mViewPager.setCurrentItem(tag);
        mConnainer.getChildAt(tag).setSelected(true);
        mConnainer.getChildAt(mCurrentIndex).setSelected(false);
        mCurrentIndex = tag;
    }

    /**
     * @param count 消息数量
     */
    public void setCurrentTabTips(int count) {
        setTabTips(mCurrentIndex, count);
    }


    /**
     * @param position 位置点
     * @param count    消息数量
     */
    public void setTabTips(int position, int count) {
        if (position >= mConnainer.getChildCount()) {
            position = mConnainer.getChildCount() - 1;
        }
        TabView tv = (TabView) mConnainer.getChildAt(position);
        tv.setTipsCount(count);
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {
        if (null != mListener) {
            mListener.onPageScrolled(i, v, i1);
        }
    }

    @Override
    public void onPageSelected(int i) {
        selectedCurrent(i);
        if (null != mListener) {
            mListener.onPageSelected(i);
        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {
        if (null != mListener) {
            mListener.onPageScrollStateChanged(i);
        }
    }

    /**
     * 挂载的TabView
     */
    private class TabView extends LinearLayout {
        private CharSequence mTab;
        private TextView mTextView;
        private TextView mTips;
        private View mLine;

        public TabView(Context context, CharSequence tab) {
            super(context);
            View.inflate(context, R.layout.layout_tab_view, this);
            mTab = tab;
            initTabView();
        }

        private void initTabView() {
            setOrientation(VERTICAL);
            mTextView = (TextView) findViewById(R.id.tab_text);
            mLine = findViewById(R.id.tab_line);
            mTips = (TextView) findViewById(R.id.tab_tips);
            mTextView.setText(mTab);
            mTextView.setTextSize(12);
//            mTextView.setTextSize(getResources().getDimension(R.dimen.tabshowtext));
//            mTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,getResources().getDimension(R.dimen.tabshowtext));
            mTextView.setTextColor(getResources().getColorStateList(R.color.colorPrimary));
            mLine.setVisibility(INVISIBLE);
            mTips.setVisibility(GONE);
        }

        @Override
        public void setSelected(boolean selected) {
            super.setSelected(selected);
            mTextView.setSelected(selected);
            mLine.setVisibility(selected ? VISIBLE : INVISIBLE);
        }

        public TextView getTips() {
            return mTips;
        }

        public void setTipsCount(int count) {
            if (count < 1) {
                mTips.setVisibility(GONE);
            } else {
                mTips.setVisibility(VISIBLE);
                String s = count > 99 ? 99 + "+" : count + "";
                mTips.setText(s);
            }
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener listener) {
        mListener = listener;
    }
}
