package yablochniuk.coffeeinfo.list.presenter;

import java.util.List;

import yablochniuk.coffeeinfo.list.model.ContentData;

/**
 * Created by Vitalii Yablochniuk on 4/11/16
 */
public interface ResponseCoffeeListPresenter {

    void onLoaded(List<ContentData> content);
}
