package com.dra11y.assetThymeleafTaglib

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource

@Configuration
open class ThymeleafAssetDialectConfig {
    @Bean
    open fun getManifestLoader(): ManifestLoader =
        ManifestLoader(ClassPathResource("manifest.json"))
}
