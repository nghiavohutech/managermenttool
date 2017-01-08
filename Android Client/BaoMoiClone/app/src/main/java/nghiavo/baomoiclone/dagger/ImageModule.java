package nghiavo.baomoiclone.dagger;

import android.app.Application;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by nghiavo on 1/3/17.
 */

@Module
public class ImageModule {
    @Provides
    @Singleton
    ImageLoaderConfiguration getImageLoaderConfig(Application application) {
        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(application);
        config.threadPriority(Thread.NORM_PRIORITY - 2);
        config.denyCacheImageMultipleSizesInMemory();
        config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
        config.diskCacheSize(50 * 1024 * 1024); // 50 MiB
        config.tasksProcessingOrder(QueueProcessingType.LIFO);
        return config.build();
    }

    @Provides
    @Singleton
    ImageLoader getImageLoader(ImageLoaderConfiguration config) {
        ImageLoader.getInstance().init(config);
        return ImageLoader.getInstance();
    }
}
