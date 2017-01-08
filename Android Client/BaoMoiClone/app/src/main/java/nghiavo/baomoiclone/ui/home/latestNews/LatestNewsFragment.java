package nghiavo.baomoiclone.ui.home.latestNews;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import in.srain.cube.views.loadmore.LoadMoreContainer;
import in.srain.cube.views.loadmore.LoadMoreHandler;
import in.srain.cube.views.loadmore.LoadMoreListViewContainer;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import nghiavo.baomoiclone.R;
import nghiavo.baomoiclone.models.FeedItem;
import nghiavo.baomoiclone.services.ApiClient;
import nghiavo.baomoiclone.ui.home.latestNews.detail.LatestNewsDetailActivity;
import nghiavo.baomoiclone.utils.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Get and show latest feed from api with paging, refresh support
 */
public class LatestNewsFragment extends Fragment implements PtrHandler, LoadMoreHandler {

    // Main view container
    private View fragLatestNews;

    /**
     * List of latest feed and adapter to render
     */
    private List<FeedItem> feedItems;
    private LvLatestNewsAdapter lvLatestNewsAdapter;

    // Page of list view, use to paging, auto increase when scroll bottom of list view
    private int currentPage = 1;

    // Check the action of use is refresh or load more
    private boolean isRefresh;

    /**
     * The list view store latest news.
     */
    @BindView(R.id.lvLatestNews)
    ListView lvLatestNews;

    /**
     * The Progress bar for loading.
     */
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    /**
     * The Ptr frame -> use to support action refresh when use scroll down on top list view.
     */
    @BindView(R.id.ptrFrame)
    PtrClassicFrameLayout ptrFrame;

    /**
     * The Lm container -> use to support action load more when user scroll to bottom list view.
     */
    @BindView(R.id.lmContainer)
    LoadMoreListViewContainer lmContainer;


    /**
     * Instantiates a new Latest news fragment.
     */
    public LatestNewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragLatestNews = inflater.inflate(R.layout.fragment_latest_news, container, false);
        ButterKnife.bind(this, fragLatestNews);
        // Handle render view
        setUpView();
        return fragLatestNews;
    }

    /**
     * Render view for first load fragment
     */
    private void setUpView() {
        /* Init list feed store and set base adapter for list view */
        feedItems = new ArrayList<>();
        lvLatestNewsAdapter = new LvLatestNewsAdapter(getContext(), feedItems);
        lvLatestNews.setAdapter(lvLatestNewsAdapter);
        // Enable can refresh list view
        ptrFrame.setPtrHandler(this);
        // Set last update time in header
        ptrFrame.setLastUpdateTimeRelateObject(this);
        // Enable can load more list view
        lmContainer.setLoadMoreHandler(this);
        // Enable auto load more when scroll to bottom of list
        lmContainer.setAutoLoadMore(true);
        // Get data page 1 in first load fragment
        onRefreshBegin(ptrFrame);
    }

    /**
     * Communication with api to get list feed
     *
     * @param page value of page want get list feed
     */
    private void getFeedFromApi(int page) {
        // Start loading
        progressBar.setVisibility(View.VISIBLE);
        Call<List<FeedItem>> callGetListLatestNews = ApiClient.apiService.getListLatestFeedItem(page);
        callGetListLatestNews.enqueue(new Callback<List<FeedItem>>() {
            @Override
            public void onResponse(Call<List<FeedItem>> call, Response<List<FeedItem>> response) {
                try {
                    feedItems.addAll(response.body());
                    lvLatestNewsAdapter.notifyDataSetChanged();
                } catch (NullPointerException e) {
                    // Handle exception
                }
                completeLoadTask(isRefresh);
            }

            @Override
            public void onFailure(Call<List<FeedItem>> call, Throwable t) {
                completeLoadTask(isRefresh);
            }
        });
    }

    /**
     * Trigger when finish request to api
     *
     * @param isRefresh check action is refresh or load more
     */
    private void completeLoadTask(boolean isRefresh) {
        if (isRefresh) {
            // Done refresh
            ptrFrame.refreshComplete();
        } else {
            // Done load more
            lmContainer.loadMoreFinish(false, true);
        }
        // Stop loading
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onLoadMore(LoadMoreContainer loadMoreContainer) {
        // This is action load more
        isRefresh = false;
        // Increase to next page
        currentPage++;
        // Get data next page
        getFeedFromApi(currentPage);
    }

    @Override
    public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
        // Enable a list view can refresh
        return PtrDefaultHandler.checkContentCanBePulledDown(frame, lvLatestNews, header);
    }

    @Override
    public void onRefreshBegin(PtrFrameLayout frame) {
        // This is action refresh
        isRefresh = true;
        // Set currentPage reset to default
        currentPage = 1;
        // Reset list of feed
        feedItems.clear();
        // Get data on first page
        getFeedFromApi(currentPage);
    }

    /**
     * On item click of lvLatestNews.
     *
     * @param position the position user selected
     */
    @OnItemClick(R.id.lvLatestNews)
    public void OnItemClickLvLatestNews(int position) {
        /* Send feedUrl and start activity feed detail */
        Intent detailIntent = new Intent(getActivity(), LatestNewsDetailActivity.class);
        detailIntent.putExtra(Constants.EXTRA_FEED_URL, feedItems.get(position).href);
        startActivity(detailIntent);
    }
}
