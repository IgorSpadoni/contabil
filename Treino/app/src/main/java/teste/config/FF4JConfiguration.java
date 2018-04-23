package teste.config;


import com.mongodb.DBCollection;
import org.ff4j.FF4j;
import org.ff4j.core.Feature;
import org.ff4j.store.FeatureStoreMongoDB;
import org.ff4j.web.ApiConfig;
import org.ff4j.web.FF4jDispatcherServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;

@Configuration
@ComponentScan(basePackages = "org.ff4j.aop")
public class FF4JConfiguration {

    private static final String DEFAULT_CONSOLE = "/ff4j-console/*";
    private static final String FEATURE_COLLECTION = "ff4j-igor-features";

    @Autowired
    private MongoDbFactory mongoFactory;

    @Bean
    public FF4j getFF4j() {

        final FF4j ff4j = new FF4j();
        configureFeatureStoreMongoDB(ff4j);

        final Features[] features = Features.values();
        for (Features feature : features) {
            createIfNotExists(ff4j, feature);
        }

        return ff4j;

    }

    @Bean
    public FF4jDispatcherServlet getFF4JServlet(final FF4j ff4j) {
        final FF4jDispatcherServlet consoleServlet = new FF4jDispatcherServlet();
        consoleServlet.setFf4j(ff4j);
        return consoleServlet;
    }

    @Bean
    public ApiConfig getApiConfig(final FF4j ff4j) {
        final ApiConfig apiConfig = new ApiConfig();
        apiConfig.setAuthenticate(false);
        apiConfig.setAutorize(false);
        apiConfig.setFF4j(ff4j);
        return apiConfig;
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean(final FF4j ff4j) {
        return new ServletRegistrationBean(getFF4JServlet(ff4j), DEFAULT_CONSOLE);
    }

    private void configureFeatureStoreMongoDB(final FF4j ff4j) {
        final DBCollection ff4jCollection = mongoFactory.getDb().getCollection(FEATURE_COLLECTION);
        final FeatureStoreMongoDB featureStoreMongoDB = new FeatureStoreMongoDB(ff4jCollection);
        ff4j.setFeatureStore(featureStoreMongoDB);
    }

    private void createIfNotExists(final FF4j ff4j, final Features feature) {
        final String featureKey = feature.getKey();
        if (!ff4j.getFeatureStore().exist(featureKey)) {
            final Feature fp = new Feature(featureKey, feature.isDefaultValue());
            fp.setDescription(feature.getDescription());
            fp.setGroup(feature.getGroupname());
            ff4j.createFeature(fp);
        }
    }
}