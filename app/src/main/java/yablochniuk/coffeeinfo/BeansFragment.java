package yablochniuk.coffeeinfo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yablochniuk.coffeeinformer.R;

/**
 * Created by Vitalii Yablochniuk on 3/29/16
 */
public class BeansFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.beans_fragment, container, false);
    }
}
