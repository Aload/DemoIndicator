# DemoIndicator
首次提交关于带bageviewIndicator

### 一.How to use?

 1. used

   ```
    <economic.gaokong.com.demoindicator.ViewPagerIndicator
    android:id="@+id/demo_indicator"
    android:layout_width="match_parent"
    android:layout_height="53dp" />
  ```


----------

 2.怎样设置可以绑定view呢?
 
  ```
    public void setCurrentTabTips(int count) {
                setTabTips(mCurrentIndex, count);
            }
  
   ```
   
   ```
   public void setTabTips(int position, int count) {
            if (position >= mConnainer.getChildCount()) {
                position = mConnainer.getChildCount() - 1;
            }
            TabView tv = (TabView) mConnainer.getChildAt(position);
            tv.setTipsCount(count);
        }
   
   ```
   
3.用户可以通过动态的设置count来改变所标记

 ```
    String[] mTitle = getResources().getStringArray(R.array.demo);
        ViewPagerIndicator mIndicator = (ViewPagerIndicator) findViewById(R.id.demo_indicator);
        ViewPager mPager = (ViewPager) findViewById(R.id.demo_pager);
        mPager.setAdapter(new DemoAdapter(getSupportFragmentManager(),mTitle));
        mIndicator.setViewPager(mPager,0);
        mIndicator.setTabTips(0,5);
        mIndicator.setTabTips(1,10);
        mIndicator.setTabTips(2,2);
 ```
