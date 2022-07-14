package com.dra11y.assetThymeleafTaglib

import com.dra11y.assetThymeleafTaglib.extension.readValue
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.core.io.Resource

class ManifestLoader(resource: Resource) {
    val manifest: Map<String, String>

    init {
        manifest = jacksonObjectMapper().readValue(resource.inputStream)
    }
}
