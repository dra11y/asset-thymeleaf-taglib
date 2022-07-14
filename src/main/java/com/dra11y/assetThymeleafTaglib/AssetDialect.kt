package com.dra11y.assetThymeleafTaglib

import com.dra11y.assetThymeleafTaglib.asset.AssetResolver
import com.dra11y.assetThymeleafTaglib.expression.AssetExpressionFactory
import com.dra11y.assetThymeleafTaglib.processor.AssetHrefAttributeTagProcessor
import com.dra11y.assetThymeleafTaglib.processor.AssetSrcAttributeTagProcessor
import org.springframework.stereotype.Component
import org.thymeleaf.dialect.AbstractProcessorDialect
import org.thymeleaf.dialect.IExpressionObjectDialect
import org.thymeleaf.processor.IProcessor
import org.thymeleaf.standard.StandardDialect
import org.thymeleaf.standard.processor.StandardXmlNsTagProcessor
import org.thymeleaf.templatemode.TemplateMode

@Component
open class AssetDialect(private val assetExpressionFactory: AssetExpressionFactory, private val assetResolver: AssetResolver) :
    AbstractProcessorDialect(DIALECT_NAMESPACE, "asset", StandardDialect.PROCESSOR_PRECEDENCE),
    IExpressionObjectDialect {

    override fun getProcessors(dialectPrefix: String): Set<IProcessor> {
        val processors: MutableSet<IProcessor> = HashSet()
        processors.add(AssetHrefAttributeTagProcessor(dialectPrefix, assetResolver))
        processors.add(AssetSrcAttributeTagProcessor(dialectPrefix, assetResolver))
        processors.add(StandardXmlNsTagProcessor(TemplateMode.HTML, dialectPrefix))
        return processors
    }

    override fun getExpressionObjectFactory() = assetExpressionFactory

    companion object {
        private const val DIALECT_NAMESPACE = "https://dra11y.github.io/asset-thymeleaf-taglib-kotlin"
    }
}
