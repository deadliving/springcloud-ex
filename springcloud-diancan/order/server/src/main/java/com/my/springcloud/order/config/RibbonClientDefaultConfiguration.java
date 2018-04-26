package com.my.springcloud.order.config;

import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * Created by liuyh on 2018/4/25
 */
@RibbonClients(defaultConfiguration = DefaultRibbonConfig.class)
public class RibbonClientDefaultConfiguration {
//    public static class BazServiceList extends ConfigurationBasedServerList {
//        public BazServiceList(IClientConfig config) {
//            super.initWithNiwsConfig(config);
//        }
//    }
}
