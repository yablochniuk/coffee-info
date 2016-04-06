package yablochniuk.coffeeinformer.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vitalii Yablochniuk on 3/29/16
 */
public class NavigationAdapter extends FragmentPagerAdapter {

    List<ItemData> items = new ArrayList<>();

    public NavigationAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addItem(Fragment fragment, String title) {
        items.add(new ItemData(fragment, title));
    }

    @Override
    public Fragment getItem(int position) {
        return items.get(position).fragment;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return items.get(position).title;
    }

    private class ItemData {
        Fragment fragment;
        String title;

        public ItemData(Fragment fragment, String title) {
            this.fragment = fragment;
            this.title = title;
        }
    }
}
