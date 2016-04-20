package yablochniuk.coffeeinfo.list.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yablochniuk.coffeeinformer.R;

import java.util.List;

import yablochniuk.coffeeinfo.list.model.ContentData;
import yablochniuk.coffeeinfo.list.presenter.CoffeeListPresenter;
import yablochniuk.coffeeinfo.list.presenter.RequestCoffeeListPresenter;

/**
 * Created by Vitalii Yablochniuk on 4/6/16
 */
public abstract class ContentListFragment extends Fragment implements CoffeeListView {

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
        RecyclerView.LayoutManager layoutManager = new CoffeeGridLayoutManger(getContext(),
                (int) (400 * getResources().getSystem().getDisplayMetrics().density));
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

    private static class CoffeeGridLayoutManger extends GridLayoutManager {

        private int minItemWidth;

        public CoffeeGridLayoutManger(Context context, int minItemWidth) {
            super(context, 1);
            this.minItemWidth = minItemWidth;
        }

        @Override
        public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
            updateSpanCount();
            super.onLayoutChildren(recycler, state);
        }


        private void updateSpanCount() {
            int spanCount = getWidth() / minItemWidth;
            if (spanCount < 1) {
                spanCount = 1;
            }
            this.setSpanCount(spanCount);
        }
    }
}
