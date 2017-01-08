package nghiavo.baomoiclone.services;

import java.util.concurrent.TimeUnit;

import nghiavo.baomoiclone.libraries.ToStringConverterFactory;
import nghiavo.baomoiclone.utils.Constants;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Initialize a base api client to connect to web api
 * Created by nghiavo on 12/29/16.
 */
public class ApiClient {

    /**
     *  The constant api connect time out
     */
    private static int timeOut = 1000;

    /**
     *  The constant base object retrofit
     */
    private static Retrofit retrofit = null;

    /**
     * The constant base api service client.
     */
    public static ApiInterface apiService =
            ApiClient.getClient().create(ApiInterface.class);

    /**
     * Init a base client.
     *
     * @return the client
     */
    public static Retrofit getClient() {
        if (retrofit == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .readTimeout(timeOut, TimeUnit.SECONDS)
                    .connectTimeout(timeOut, TimeUnit.SECONDS)
                    .build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.API_URL)
                    .client(okHttpClient)
                    .addConverterFactory(new ToStringConverterFactory()) // Convert response scalar
                    .addConverterFactory(GsonConverterFactory.create()) // Convert response json
                    .build();
        }
        return retrofit;
    }
}
