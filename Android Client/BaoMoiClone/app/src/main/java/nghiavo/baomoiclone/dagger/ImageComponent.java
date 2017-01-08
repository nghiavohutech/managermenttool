package nghiavo.baomoiclone.dagger;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by nghiavo on 1/3/17.
 */

@Singleton
@Component(modules = {ImageModule.class})
public interface ImageComponent {
    ImageLoaderConfiguration getImageLoaderConfig();
    ImageLoader getImageLoader();
}
