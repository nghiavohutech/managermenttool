package nghiavo.baomoiclone;

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import nghiavo.baomoiclone.dagger.ImageComponent;

/**
 * Run first when start app
 * Created by nghiavo on 12/29/16.
 */
public class App extends Application {

    /**
     * Init image loader.
     *
     * @param context the context
     */
    public static void initImageLoader(Context context) {
        /* Singleton image loader instance */
        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(context);
        config.threadPriority(Thread.NORM_PRIORITY - 2);
        config.denyCacheImageMultipleSizesInMemory();
        config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
        config.diskCacheSize(50 * 1024 * 1024); // 50 MiB
        config.tasksProcessingOrder(QueueProcessingType.LIFO);
        // Initialize ImageLoader with configuration.
    }

    private ImageComponent imageComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        // initImageLoader(getApplicationContext());

    }

}