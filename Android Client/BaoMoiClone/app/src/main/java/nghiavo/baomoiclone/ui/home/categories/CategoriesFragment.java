package nghiavo.baomoiclone.ui.home.categories;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import nghiavo.baomoiclone.R;
import nghiavo.baomoiclone.libraries.RecyclerItemClickListener;
import nghiavo.baomoiclone.libraries.RvCategoriesAdapter;
import nghiavo.baomoiclone.models.RvCategoriesItem;
import nghiavo.baomoiclone.utils.Functions;

/**
 * A simple {@link Fragment} subclass.
 * Show all categories of bao Bao Moi for use can select
 */
public class CategoriesFragment extends Fragment {

    private View fragCategories;

    /**
     * The view of list categories.
     */
    @BindView(R.id.rvCategories)
    RecyclerView rvCategories;

    /**
     * Declare list store categories
     */
    private ArrayList<RvCategoriesItem> listCategories;

    /**
     * Adapter for rvCategories
     */
    private RvCategoriesAdapter listCategoriesAdapter;

    /**
     * Instantiates a new Categories fragment.
     */
    public CategoriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragCategories = inflater.inflate(R.layout.fragment_categories, container, false);
        ButterKnife.bind(this, fragCategories);
        // Handle render view
        setUpView();
        return fragCategories;
    }

    /**
     * Sets up layouts categories.
     */
    public void setUpView() {
        // Metro item view
        setGridRecyclerView();
        // Auto fix size item view
        rvCategories.setHasFixedSize(true);
        // Setup list categories
        getListCategoriesItems();
        // Init list categories adapter
        listCategoriesAdapter = new RvCategoriesAdapter(getContext(), listCategories);
        /* Setup view for recycle view and handle any action */
        rvCategories.setAdapter(listCategoriesAdapter);
        rvCategories.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Functions.showSimpleAlertDialog(getActivity(), getString(R.string.tl_alert), getString(R.string.msg_alert_non_data));
                    }
                })
        );
    }

    /**
     * Sets grid recycler view.
     */
    private void setGridRecyclerView() {
        // Grid layout with 3 item on a line
        rvCategories.setLayoutManager(new GridLayoutManager(getContext(), 3));
    }

    /**
     * Init list categories
     */
    private void getListCategoriesItems() {
        listCategories = new ArrayList<>();
        listCategories.add(new RvCategoriesItem(R.mipmap.ic_tech, getString(R.string.tl_cat_tech)));
        listCategories.add(new RvCategoriesItem(R.mipmap.ic_football, getString(R.string.tl_cat_football)));
        listCategories.add(new RvCategoriesItem(R.mipmap.ic_food, getString(R.string.tl_cat_food)));
        listCategories.add(new RvCategoriesItem(R.mipmap.ic_travel, getString(R.string.tl_cat_travel)));

    }

}
