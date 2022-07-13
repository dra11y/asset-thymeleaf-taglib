package com.dra11y.assetThymeleafTaglib.processor

import org.thymeleaf.templatemode.TemplateMode

class AssetSrcAttributeTagProcessor(dialectPrefix: String?) : AbstractAssetAttributeTagProcessor(
    TemplateMode.HTML, // This processor will apply only to HTML mode
    dialectPrefix, // Prefix to be applied to name for matching
    null, // No tag name: match any tag name
    false, // No prefix to be applied to tag name
    ATTR_NAME, // Name of the attribute that will be matched
    true, // Apply dialect prefix to attribute name
    PRECEDENCE, // Precedence (inside dialect's precedence)
    true
) {
    companion object {
        private const val ATTR_NAME = "src"
        private const val PRECEDENCE = 1000
    }
}
