package com.dra11y.assetThymeleafTaglib.extension

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import java.io.InputStream

inline fun <reified T> ObjectMapper.readValue(src: InputStream): T =
    readValue(src, object : TypeReference<T>() {})
