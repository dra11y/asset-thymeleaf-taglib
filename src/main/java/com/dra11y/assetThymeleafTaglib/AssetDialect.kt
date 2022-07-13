package com.dra11y.assetThymeleafTaglib

import com.dra11y.assetThymeleafTaglib.expression.AssetExpressionFactory
import com.dra11y.assetThymeleafTaglib.processor.AssetHrefAttributeTagProcessor
import com.dra11y.assetThymeleafTaglib.processor.AssetSrcAttributeTagProcessor
import org.thymeleaf.dialect.AbstractProcessorDialect
import org.thymeleaf.dialect.IExpressionObjectDialect
import org.thymeleaf.expression.IExpressionObjectFactory
import org.thymeleaf.processor.IProcessor
import org.thymeleaf.standard.StandardDialect
import org.thymeleaf.standard.processor.StandardXmlNsTagProcessor
import org.thymeleaf.templatemode.TemplateMode

class AssetDialect :
    AbstractProcessorDialect(DIALECT_NAMESPACE, "asset", StandardDialect.PROCESSOR_PRECEDENCE),
    IExpressionObjectDialect {
    private val expressionObjectsFactory: IExpressionObjectFactory

    init {
        expressionObjectsFactory = AssetExpressionFactory()
    }

    override fun getProcessors(dialectPrefix: String): Set<IProcessor> {
        val processors: MutableSet<IProcessor> = HashSet()
        processors.add(AssetHrefAttributeTagProcessor(dialectPrefix))
        processors.add(AssetSrcAttributeTagProcessor(dialectPrefix))
        processors.add(StandardXmlNsTagProcessor(TemplateMode.HTML, dialectPrefix))
        return processors
    }

    override fun getExpressionObjectFactory() = expressionObjectsFactory

    companion object {
        private const val DIALECT_NAMESPACE = "https://dra11y.github.io/asset-thymeleaf-taglib-kotlin"
    }
}
