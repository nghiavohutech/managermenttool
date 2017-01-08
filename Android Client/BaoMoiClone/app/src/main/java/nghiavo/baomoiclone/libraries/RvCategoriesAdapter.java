package nghiavo.baomoiclone.libraries;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import nghiavo.baomoiclone.R;
import nghiavo.baomoiclone.models.RvCategoriesItem;

/**
 * Setup layout for item in RecycleView for categories
 * Created by nghiavo on 12/29/16.
 */
public class RvCategoriesAdapter extends RecyclerView.Adapter<RvCategoriesAdapter.ViewHolder> {

    /**
     * Use to inflater a layout
     */
    private LayoutInflater mLayoutInflater;

    /**
     * Contain data item for recycle view
     */
    private ArrayList<RvCategoriesItem> mDataList;

    /**
     * Instantiates a new Rv categories adapter.
     *
     * @param context  the context
     * @param dataList the list categories
     */
    public RvCategoriesAdapter(Context context, ArrayList<RvCategoriesItem> dataList) {
        super();
        mLayoutInflater = LayoutInflater.from(context);
        mDataList = dataList;
    }

    @Override
    public RvCategoriesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.cv_categories_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final RvCategoriesAdapter.ViewHolder holder, int position) {
        final RvCategoriesItem data = mDataList.get(position);
        holder.tvCategories.setText(data.getLabel());
        holder.imvCategories.setImageResource(data.getIcon());
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    /**
     * The type View holder.
     */
    static class ViewHolder extends RecyclerView.ViewHolder {

        /**
         * The Icon of a category.
         */
        ImageView imvCategories;

        /**
         * The Title of a category.
         */
        TextView tvCategories;

        /**
         * The Recycler view.
         */
        RecyclerView recyclerView;

        /**
         * Instantiates a new View holder.
         *
         * @param v the v
         */
        public ViewHolder(View v) {
            super(v);
            tvCategories = (TextView) v.findViewById(R.id.tvCategories);
            imvCategories = (ImageView) v.findViewById(R.id.imvCategories);
            recyclerView = (RecyclerView) v.findViewById(R.id.rvCategories);
        }
    }
}