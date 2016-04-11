package yablochniuk.coffeeinfo.list.model;

import com.yablochniuk.coffeeinformer.R;

import java.util.ArrayList;
import java.util.List;

import yablochniuk.coffeeinfo.list.presenter.ResponseCoffeeListPresenter;

/**
 * Created by Vitalii Yablochniuk on 4/11/16
 */
public class CoffeeListModelImpl implements CoffeeListModel {

    private ResponseCoffeeListPresenter mPresenter;

    public CoffeeListModelImpl(ResponseCoffeeListPresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void loadBeverages() {
        List<ContentData> d = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            d.add(new ContentData("test " + i, R.mipmap.ic_launcher));
        }

        mPresenter.onLoaded(d);
    }

    @Override
    public void loadBeans() {
        List<ContentData> d = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            d.add(new ContentData("test " + i, R.mipmap.ic_launcher));
        }

        mPresenter.onLoaded(d);
    }
}
