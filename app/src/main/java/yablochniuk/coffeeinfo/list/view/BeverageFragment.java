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
public class BeverageFragment extends ContentListFragment {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getPresenter().loadBeverages();
    }
}
