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
        List<ContentData> beverages = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            beverages.add(new ContentData(R.string.espresso, R.drawable.espresso));
            beverages.add(new ContentData(R.string.latte, R.drawable.latte));
            beverages.add(new ContentData(R.string.mocha, R.drawable.mocha));
            beverages.add(new ContentData(R.string.cappuccino, R.drawable.cappuccino));
            beverages.add(new ContentData(R.string.espresso, R.drawable.espresso));
        }

        mPresenter.onLoaded(beverages);
    }

    @Override
    public void loadBeans() {
        List<ContentData> beans = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            beans.add(new ContentData(R.string.beans_brazil, R.drawable.bean1));
            beans.add(new ContentData(R.string.beans_cuba, R.drawable.bean2));
            beans.add(new ContentData(R.string.beans_jamaica, R.drawable.bean3));
            beans.add(new ContentData(R.string.beans_java, R.drawable.bean4));
            beans.add(new ContentData(R.string.beans_puerto_rico, R.drawable.bean5));
            beans.add(new ContentData(R.string.beans_india, R.drawable.bean6));
        }
        mPresenter.onLoaded(beans);
    }
}
