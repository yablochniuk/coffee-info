package yablochniuk.coffeeinfo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.yablochniuk.coffeeinformer.R;

import yablochniuk.coffeeinfo.adapter.NavigationAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;
import yablochniuk.coffeeinfo.list.view.BeansFragment;
import yablochniuk.coffeeinfo.list.view.BeverageFragment;

/**
 * Created by Vitalii Yablochniuk on 3/29/16
 */
public class NavigationActivity extends AppCompatActivity {

    @Bind(R.id.tabs) TabLayout mTabLayout;
    @Bind(R.id.viewpager) ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_content);
        ButterKnife.bind(this);

        setupViewPager(mViewPager);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        NavigationAdapter adapter = new NavigationAdapter(getSupportFragmentManager());
        adapter.addItem(new BeverageFragment(), getString(R.string.beverage_tab_title));
        adapter.addItem(new BeansFragment(), getString(R.string.beans_tab_title));
//        adapter.addItem(new BaristaFragment(), getString(R.string.barista_tab_title));
        viewPager.setAdapter(adapter);
    }
}
