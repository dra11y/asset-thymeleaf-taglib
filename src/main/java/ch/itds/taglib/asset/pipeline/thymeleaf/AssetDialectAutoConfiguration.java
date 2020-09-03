package ch.itds.taglib.asset.pipeline.thymeleaf;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class AssetDialectAutoConfiguration {

    @Configuration(proxyBeanMethods = false)
    static class ThymeleafAssetDialect {

        @Bean
        @ConditionalOnMissingBean
        public AssetDialect assetDialect() {
            return new AssetDialect();
        }

    }

}
