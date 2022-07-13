package com.dra11y.assetThymeleafTaglib.expression

import com.dra11y.assetThymeleafTaglib.asset.AssetResolver
import org.springframework.beans.factory.annotation.Autowired

class AssetExpression {
    @Autowired lateinit var assetResolver: AssetResolver

    fun path(path: String?): String {
        return assetResolver.getAssetPath(path!!)
    }
}
