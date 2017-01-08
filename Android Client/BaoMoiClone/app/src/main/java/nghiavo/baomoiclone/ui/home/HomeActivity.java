package nghiavo.baomoiclone.ui.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import nghiavo.baomoiclone.R;
import nghiavo.baomoiclone.ui.home.categories.CategoriesFragment;
import nghiavo.baomoiclone.ui.home.latestNews.LatestNewsFragment;
import nghiavo.baomoiclone.utils.Functions;

/**
 * First activity start when app launch.
 */
public class HomeActivity extends AppCompatActivity {

    /**
     * The navigation view.
     */
    @BindView(R.id.nav_view)
    NavigationView nav_view;

    /**
     * The left drawer layout.
     */
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer_layout;

    /**
     * The tab layout home.
     */
    @BindView(R.id.tlHome)
    TabLayout tlHome;

    /**
     * The View paper store fragment.
     */
    @BindView(R.id.vpHome)
    ViewPager vpHome;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        // Handle render view
        setUpView();
    }

    /**
     * Render view for first load activity
     */
    private void setUpView() {
        setUpDrawerLayout();
        setupViewPager(vpHome);
        tlHome.setupWithViewPager(vpHome);
        setupTabIcons();
    }

    /**
     * Set up left drawer
     */
    private void setUpDrawerLayout() {
        setUpToolBar();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer_layout.addDrawerListener(toggle);
        toggle.syncState();
        setUpNavView();
    }

    /**
     * Set top action bar for activity
     */
    private void setUpToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    /**
     * Set up content action of navigation view
     */
    private void setUpNavView() {
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {
                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.nav_setup:
                        Functions.showSimpleAlertDialog(HomeActivity.this, getString(R.string.tl_alert), getString(R.string.msg_alert_non_data));
                        break;
                    case R.id.nav_about:
                        Functions.showSimpleAlertDialog(HomeActivity.this, getString(R.string.tl_alert_app_info), getString(R.string.msg_alert_app_info));
                        break;

                }

                drawer_layout.closeDrawers();
                return true;
            }
        });

    }

    /**
     * Set up tab layout icon
     */
    private void setupTabIcons() {
        tlHome.getTabAt(0).setIcon(R.mipmap.ic_lastest_news);
        tlHome.getTabAt(1).setIcon(R.mipmap.ic_categories);
    }

    /**
     * Set up store fragment in home activity
     *
     * @param viewPager fragment container
     */
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new LatestNewsFragment(), getString(R.string.tl_tab_lastest_news));
        adapter.addFrag(new CategoriesFragment(), getString(R.string.tl_tab_categories));
        viewPager.setAdapter(adapter);
    }

    /**
     * The type View pager adapter.
     */
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        /**
         * Instantiates a new View pager adapter.
         *
         * @param manager the manager
         */
        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        /**
         * Add frag.
         *
         * @param fragment the fragment
         * @param title    the title
         */
        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }
    }


}
