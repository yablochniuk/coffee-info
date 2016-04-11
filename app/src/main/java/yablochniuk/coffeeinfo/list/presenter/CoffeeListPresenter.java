package yablochniuk.coffeeinfo.list.presenter;

import java.lang.ref.WeakReference;
import java.util.List;

import yablochniuk.coffeeinfo.list.model.CoffeeListModel;
import yablochniuk.coffeeinfo.list.model.CoffeeListModelImpl;
import yablochniuk.coffeeinfo.list.model.ContentData;
import yablochniuk.coffeeinfo.list.view.CoffeeListView;

/**
 * Created by Vitalii Yablochniuk on 4/11/16
 */
public class CoffeeListPresenter implements RequestCoffeeListPresenter, ResponseCoffeeListPresenter {

    private WeakReference<CoffeeListView> mView;
    private CoffeeListModel mModel;

    public CoffeeListPresenter(CoffeeListView view) {
        mView = new WeakReference<>(view);
        mModel = new CoffeeListModelImpl(this);
    }

    @Override
    public void loadBeverages() {
        mView.get().showLoading();
        mModel.loadBeverages();
    }

    @Override
    public void loadBeans() {
        mView.get().showLoading();
        mModel.loadBeans();
    }

    @Override
    public void onLoaded(List<ContentData> content) {
        mView.get().hideLoading();
        mView.get().showContent(content);
    }
}
