package com.dra11y.assetThymeleafTaglib

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration(proxyBeanMethods = false)
internal open class ThymeleafAssetDialectAutoConfig {
    @Bean
    @ConditionalOnMissingBean
    open fun assetDialect(): AssetDialect = AssetDialect()
}
