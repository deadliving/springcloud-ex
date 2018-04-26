package com.my.springcloud.order.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by liuyh on 2018/4/25
 */
@Configuration
public class DefaultRibbonConfig {
//    @Autowired
//    IClientConfig config;

    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }

//    @Bean
//    public IPing ribbonPing() {
//        return new PingUrl();
//    }
//
//    @Bean
//    public ServerList<Server> ribbonServerList(IClientConfig config) {
//        return new RibbonClientDefaultConfiguration.BazServiceList(config);
//    }
//
//    @Bean
//    public ServerListSubsetFilter serverListFilter() {
//        ServerListSubsetFilter filter = new ServerListSubsetFilter();
//        return filter;
//    }

}
