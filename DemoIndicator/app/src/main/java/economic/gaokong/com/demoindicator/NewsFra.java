package economic.gaokong.com.demoindicator;

import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by Autism on 2016/5/30.
 */
public class NewsFra extends BaseFra {
    @Override
    protected void initFraData() {

    }

    @Override
    protected View initFraView() {
        View mView = LayoutInflater.from(getActivity()).inflate(R.layout.news_fra, null);
        return mView;
    }
}
