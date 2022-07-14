package com.dra11y.assetThymeleafTaglib.annotation

import com.dra11y.assetThymeleafTaglib.AssetDialect
import com.dra11y.assetThymeleafTaglib.ThymeleafAssetDialectConfig
import com.dra11y.assetThymeleafTaglib.expression.AssetExpressionFactory
import org.springframework.context.annotation.Import

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@Import(
    ThymeleafAssetDialectConfig::class,
    AssetDialect::class,
    AssetExpressionFactory::class
)
annotation class EnableThymeleafAssetDialect
