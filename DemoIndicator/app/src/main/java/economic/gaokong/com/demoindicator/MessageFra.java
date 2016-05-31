package economic.gaokong.com.demoindicator;

import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by Autism on 2016/5/30.
 */
public class MessageFra extends BaseFra {
    @Override
    protected void initFraData() {

    }

    @Override
    protected View initFraView() {
        View mView = LayoutInflater.from(getActivity()).inflate(R.layout.msg_fra, null);
        return mView;
    }
}
