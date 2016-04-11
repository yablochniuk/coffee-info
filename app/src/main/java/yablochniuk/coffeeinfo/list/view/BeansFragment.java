package yablochniuk.coffeeinfo.list.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import yablochniuk.coffeeinfo.list.view.ContentListFragment;

/**
 * Created by Vitalii Yablochniuk on 3/29/16
 */
public class BeansFragment extends ContentListFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = super.onCreateView(inflater, container, savedInstanceState);
        getPresenter().loadBeans();
        return v;
    }
}

