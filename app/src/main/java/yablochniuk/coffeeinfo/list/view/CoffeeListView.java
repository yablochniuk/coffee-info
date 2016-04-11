package yablochniuk.coffeeinfo.list.view;

import java.util.List;

import yablochniuk.coffeeinfo.list.model.ContentData;

/**
 * Created by Vitalii Yablochniuk on 4/9/16
 */
public interface CoffeeListView {
    void showLoading();
    void hideLoading();
    void showContent(List<ContentData> content);
}
