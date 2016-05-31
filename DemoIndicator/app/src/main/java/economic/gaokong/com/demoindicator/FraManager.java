package economic.gaokong.com.demoindicator;

import android.util.SparseArray;

/**
 * Created by Autism on 2016/5/30.
 */
public class FraManager {
    private static SparseArray<BaseFra> mCache = new SparseArray<>();

    public static BaseFra getFragment(int position) {
        BaseFra mBaseFra = mCache.get(position);
        if (null == mBaseFra) {
            switch (position) {
                case 0:
                    mBaseFra=new MessageFra();
                    break;
                case 1:
                    mBaseFra=new NewsFra();
                    break;
                case 2:
                    mBaseFra=new EconomicFra();
                    break;
                default:
                    break;
            }
        }
        mCache.put(position, mBaseFra);
        return mBaseFra;
    }
}
