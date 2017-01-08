package nghiavo.baomoiclone.utils;

import java.text.SimpleDateFormat;

/**
 * Contain all Constants for app
 * Created by nghiavo on 12/29/16.
 */
public class Constants {

    /**
     * Base link to web api crawler
     */
    public static String API_URL = "http://mamagermenttoolapi.azurewebsites.net/";

    /**
     * The constant API_TIME_FORMAT.
     */
    public static SimpleDateFormat API_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+07:00");
    /**
     * The constant TIME_FORMAT.
     */
    public static SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("dd/MM/yyy HH:mm");

    /**
     * The constant extraFeedUrl.
     */
    public static String EXTRA_FEED_URL = "extraFeedUrl";

    /**
     * Type of response feed detail
     */
    public static String RES_FEED_DETAIL_TYPE = "text/html; charset=utf-8";

}
