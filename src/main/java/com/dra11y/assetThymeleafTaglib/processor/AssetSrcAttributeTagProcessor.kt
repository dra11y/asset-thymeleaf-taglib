package com.dra11y.assetThymeleafTaglib.processor

import com.dra11y.assetThymeleafTaglib.asset.AssetResolver
import org.springframework.stereotype.Component
import org.thymeleaf.templatemode.TemplateMode

@Component
class AssetSrcAttributeTagProcessor(dialectPrefix: String?, assetResolver: AssetResolver) : AbstractAssetAttributeTagProcessor(
    TemplateMode.HTML, // This processor will apply only to HTML mode
    dialectPrefix, // Prefix to be applied to name for matching
    null, // No tag name: match any tag name
    false, // No prefix to be applied to tag name
    ATTR_NAME, // Name of the attribute that will be matched
    true, // Apply dialect prefix to attribute name
    PRECEDENCE, // Precedence (inside dialect's precedence)
    true,
    assetResolver
) {
    init {
        println("init AssetSrcAttributeTagProcessor")
    }

    companion object {
        private const val ATTR_NAME = "src"
        private const val PRECEDENCE = 1000
    }
}
