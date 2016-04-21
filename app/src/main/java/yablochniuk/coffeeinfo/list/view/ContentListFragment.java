package yablochniuk.coffeeinfo.list.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yablochniuk.coffeeinformer.R;

import java.util.List;

import yablochniuk.coffeeinfo.list.model.ContentData;
import yablochniuk.coffeeinfo.list.presenter.CoffeeListPresenter;
import yablochniuk.coffeeinfo.list.presenter.RequestCoffeeListPresenter;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;

/**
 * Created by Vitalii Yablochniuk on 4/6/16
 */
public abstract class ContentListFragment extends Fragment implements CoffeeListView {

    public static final int COLUMNS_LANDSCAPE = 3;
    private static final int COLUMNS_PORTRAIT = 2;
    private RecyclerView mContentView;
    private ContentListAdapter mContentAdapter;
    private RequestCoffeeListPresenter mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new CoffeeListPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_list_fragment, container, false);
        mContentView = (RecyclerView) view.findViewById(R.id.content_list);
        mContentView.setHasFixedSize(true);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView.LayoutManager layoutManager = createLayoutManager();
        mContentView.setLayoutManager(layoutManager);
        mContentView.addItemDecoration(new ContentItemDecoration(getContext()));
        mContentAdapter = new ContentListAdapter();
        mContentView.setAdapter(mContentAdapter);
    }

    @Override
    public void showContent(List<ContentData> content) {
        mContentAdapter.setContent(content);
        mContentAdapter.notifyDataSetChanged();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    protected RequestCoffeeListPresenter getPresenter() {
        return mPresenter;
    }


    private RecyclerView.LayoutManager createLayoutManager() {
        int orientation = getResources().getConfiguration().orientation;
        int columns = COLUMNS_PORTRAIT;
        if (orientation == COLUMNS_LANDSCAPE) {
            columns = COLUMNS_LANDSCAPE;
        }

        return new GridLayoutManager(getContext(), columns);
    }
}
