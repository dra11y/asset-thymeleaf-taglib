package com.dra11y.assetThymeleafTaglib

import com.dra11y.assetThymeleafTaglib.extension.readValue
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.core.io.Resource

class ManifestLoader(private val resource: Resource) {

    private var cachedManifest: Map<String, String> = mapOf()
    private var lastModified: Long = 0

    init {
        updateCachedManifest()
    }

    fun getManifest(): Map<String, String> {
        if (resource.file.lastModified() != lastModified) updateCachedManifest()
        return cachedManifest
    }

    fun updateCachedManifest() {
        lastModified = resource.file.lastModified()
        cachedManifest = jacksonObjectMapper().readValue(resource.inputStream)
    }
}
