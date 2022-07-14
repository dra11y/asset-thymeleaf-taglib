package com.dra11y.assetThymeleafTaglib.expression

import com.dra11y.assetThymeleafTaglib.asset.AssetResolver
import org.springframework.context.annotation.Import
import org.springframework.stereotype.Component

@Component
@Import(AssetResolver::class)
class AssetExpression(private val assetResolver: AssetResolver) {
    fun path(path: String?): String = assetResolver.getAssetPath(path!!)
}
