package com.example.order.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.beans.factory.annotation.Autowired;
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
