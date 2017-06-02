package performance.charla;

import com.giffing.wicket.spring.boot.context.extensions.ApplicationInitExtension;
import com.giffing.wicket.spring.boot.context.extensions.WicketApplicationInitConfiguration;
import org.apache.wicket.protocol.http.WebApplication;

@ApplicationInitExtension
public class CharlaInitConfiguration implements WicketApplicationInitConfiguration {

    @Override
    public void init(final WebApplication webApplication) {
    }

}
