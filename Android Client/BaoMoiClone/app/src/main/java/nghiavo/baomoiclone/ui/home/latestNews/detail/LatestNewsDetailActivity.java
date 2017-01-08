package nghiavo.baomoiclone.ui.home.latestNews.detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import nghiavo.baomoiclone.R;
import nghiavo.baomoiclone.services.ApiClient;
import nghiavo.baomoiclone.utils.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Show content of a feed in new activity
 * The type Latest news detail activity.
 */
public class LatestNewsDetailActivity extends AppCompatActivity {

    /**
     * The Web view display html source get from api.
     */
    @BindView(R.id.wvFeedDetail)
    WebView wvFeedDetail;

    /**
     * The Progress bar for loading.
     */
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lastest_news_detail);
        ButterKnife.bind(this);
        // Handle render view
        setUpView();
    }

    /**
     * Setup base view
     * Communication with api get feed html source and bind to view
     */
    private void setUpView() {
        // Enable back button on action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        /* Call api to get source of feed */
        Call<String> callGetFeedDetail = ApiClient.apiService.getFeedDetail(getIntent().getStringExtra(Constants.EXTRA_FEED_URL));
        callGetFeedDetail.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                try {
                    // Bind web view with a html source and support vietnamese
                    wvFeedDetail.loadData(response.body(), Constants.RES_FEED_DETAIL_TYPE, null);
                    progressBar.setVisibility(View.INVISIBLE);
                } catch (NullPointerException e) {
                    // Handle exception
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                // Handle exception
            }
        });
    }
}
