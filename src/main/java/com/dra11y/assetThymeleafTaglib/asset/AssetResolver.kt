package com.dra11y.assetThymeleafTaglib.asset

import com.dra11y.assetThymeleafTaglib.ManifestLoader
import org.springframework.stereotype.Component

@Component
class AssetResolver(val manifestLoader: ManifestLoader) {
    fun getAssetPath(path: String): String = manifestLoader.getManifest()[path] ?: path
}
