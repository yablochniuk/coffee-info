package yablochniuk.coffeeinfo;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yablochniuk.coffeeinformer.R;

import java.util.ArrayList;
import java.util.List;

import yablochniuk.coffeeinfo.adapter.ContentListAdapter;

/**
 * Created by Vitalii Yablochniuk on 4/6/16
 */
public abstract class ContentListFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_list_fragment, container, false);
        RecyclerView contentList = (RecyclerView) view.findViewById(R.id.content_list);

        contentList.setHasFixedSize(true);
        
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 5);

        contentList.setLayoutManager(layoutManager);


        contentList.setAdapter(new ContentListAdapter(getData()));
        return view;
    }

    private List<ContentData> getData() {
        List<ContentData> d = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            d.add(new ContentData("test " + i, R.mipmap.ic_launcher));
        }

        return d;
    }
}
