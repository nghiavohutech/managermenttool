package nghiavo.baomoiclone.ui.home.latestNews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import org.apache.commons.lang3.StringEscapeUtils;

import java.text.ParseException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import nghiavo.baomoiclone.R;
import nghiavo.baomoiclone.models.FeedItem;
import nghiavo.baomoiclone.utils.Constants;

/**
 * Parse data to latest news list view
 * Created by nghiavo on 12/29/16.
 */
public class LvLatestNewsAdapter extends BaseAdapter {

    /**
     * Contain data item for list view
     */
    private List<FeedItem> feedItems;

    /**
     * Use to inflater a layout
     */
    private LayoutInflater inflater;

    /**
     * Instantiates a new Lv latest news adapter.
     *
     * @param context   the context
     * @param feedItems the feed items
     */
    public LvLatestNewsAdapter(Context context, List<FeedItem> feedItems) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.feedItems = feedItems;
    }

    @Override
    public int getCount() {
        return feedItems.size();
    }

    @Override
    public FeedItem getItem(int i) {
        return feedItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get current feed
        FeedItem currentItem = getItem(position);
        /* Inject view ID */
        ViewHolder holder;
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = inflater.inflate(R.layout.lv_latest_news_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        // Set thumb of feed
        ImageLoader.getInstance().displayImage(currentItem.imageUrl, holder.imgThumb);
        // Set title of feed
        holder.tvTitle.setText(StringEscapeUtils.unescapeHtml3(currentItem.title));
        // Set description of feed
        holder.tvShortDescription.setText(StringEscapeUtils.unescapeHtml3(currentItem.shortDescription));
        /* Convert time from api */
        try {
            holder.tvDateTime.setText(Constants.TIME_FORMAT.format(Constants.API_TIME_FORMAT.parse(currentItem.dateTime)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // Set source of feed
        holder.tvSource.setText(currentItem.source);
        return convertView;
    }

    /**
     * The type View holder.
     */
    static class ViewHolder {

        /**
         * The ImageView thumb.
         */
        @BindView(R.id.imgThumb)
        ImageView imgThumb;

        /**
         * The TextView title.
         */
        @BindView(R.id.tvTitle)
        TextView tvTitle;

        /**
         * The TextView short description.
         */
        @BindView(R.id.tvShortDescription)
        TextView tvShortDescription;

        /**
         * The TextView date time post.
         */
        @BindView(R.id.tvDateTime)
        TextView tvDateTime;

        /**
         * The TextView source.
         */
        @BindView(R.id.tvSource)
        TextView tvSource;

        /**
         * Instantiates a new View holder.
         *
         * @param view the view
         */
        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}
