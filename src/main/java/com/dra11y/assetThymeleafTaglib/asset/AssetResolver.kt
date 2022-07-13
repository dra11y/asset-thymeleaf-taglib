package com.dra11y.assetThymeleafTaglib.asset

object AssetResolver {
    @JvmStatic
    fun getAssetPath(path: String): String {
        var assetPath = path
        println("assetPath = $assetPath")
        return assetPath
    }
}
