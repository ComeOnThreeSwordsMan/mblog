package mblog.boot;

import net.sf.ehcache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @author an
 */
@Configuration
@EnableCaching
public class EhCacheConfig {

    /**
     * 邮件发送线程池, 如果任务量多可以适当扩大
     * @return 结果
     */
    @Bean
    public ExecutorService executorService() {
        return newFixedThreadPool(1);
    }
    /**
     * EhCache的配置
     */
    @Bean
    public EhCacheCacheManager cacheManager(CacheManager cacheManager) {
        return new EhCacheCacheManager(cacheManager);
    }

    /**
     * EhCache的配置
     */
    @Bean
    public EhCacheManagerFactoryBean ehcache() {
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
        return ehCacheManagerFactoryBean;
    }

}
