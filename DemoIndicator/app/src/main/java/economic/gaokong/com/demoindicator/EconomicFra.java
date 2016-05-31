package economic.gaokong.com.demoindicator;

import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by Autism on 2016/5/30.
 */
public class EconomicFra extends BaseFra {
    @Override
    protected void initFraData() {

    }

    @Override
    protected View initFraView() {
        View mView = LayoutInflater.from(getActivity()).inflate(R.layout.economic_fra, null);
        return mView;
    }
}
