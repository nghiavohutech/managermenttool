package nghiavo.baomoiclone.services;

import java.util.List;

import nghiavo.baomoiclone.models.FeedItem;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Map java function, model with api request and response
 * Created by nghiavo on 12/29/16.
 */
public interface ApiInterface {
    /**
     * Gets list latest feed item with paging support.
     *
     * @param page the page need get
     * @return the list latest feed item parse from json to List<FeedItem>
     */
    @GET("api/BaoMoiCrawler/GetFeed")
    Call<List<FeedItem>> getListLatestFeedItem(@Query("page") int page);

    /**
     * Gets feed detail.
     *
     * @param feedUrl the feed url
     * @return the feed detail type of Html source (scalar type)
     */
    @FormUrlEncoded
    @POST("api/BaoMoiCrawler/GetFeedDetail")
    Call<String> getFeedDetail(@Field("feedUrl") String feedUrl);
}
