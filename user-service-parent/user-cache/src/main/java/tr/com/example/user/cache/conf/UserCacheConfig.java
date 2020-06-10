package tr.com.example.user.cache.conf;

import com.hazelcast.config.Config;
import com.hazelcast.config.NetworkConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class UserCacheConfig {
    @Bean
    public Config hazelCastConfig(){
        Config config = new Config();
        config.setInstanceName("user-cache");
        NetworkConfig networkConfig = new NetworkConfig();
        networkConfig.setPort(9601);
        networkConfig.getJoin().getMulticastConfig().setEnabled(false);
        networkConfig.getJoin().getTcpIpConfig().setEnabled(true);
        config.setNetworkConfig(networkConfig);
        return config;
    }

}
