package com.dra11y.assetThymeleafTaglib.processor

import com.dra11y.assetThymeleafTaglib.asset.AssetResolver
import org.springframework.stereotype.Component
import org.thymeleaf.context.ITemplateContext
import org.thymeleaf.engine.AttributeName
import org.thymeleaf.model.IProcessableElementTag
import org.thymeleaf.processor.element.AbstractAttributeTagProcessor
import org.thymeleaf.processor.element.IElementTagStructureHandler
import org.thymeleaf.standard.expression.StandardExpressions
import org.thymeleaf.templatemode.TemplateMode

@Component
abstract class AbstractAssetAttributeTagProcessor protected constructor(
    templateMode: TemplateMode?,
    dialectPrefix: String?,
    elementName: String?,
    prefixElementName: Boolean,
    attributeName: String?,
    prefixAttributeName: Boolean,
    precedence: Int,
    removeAttribute: Boolean,
    private val assetResolver: AssetResolver
) : AbstractAttributeTagProcessor(
    templateMode,
    dialectPrefix,
    elementName,
    prefixElementName,
    attributeName,
    prefixAttributeName,
    precedence,
    removeAttribute
) {
    override fun doProcess(
        context: ITemplateContext,
        tag: IProcessableElementTag,
        attributeName: AttributeName,
        attributeValue: String,
        structureHandler: IElementTagStructureHandler
    ) {
        val configuration = context.configuration
        val parser = StandardExpressions.getExpressionParser(configuration)
        val expression = parser.parseExpression(context, attributeValue)
        val directSource = expression.execute(context) as String
        val finalSource = assetResolver.getAssetPath(directSource)
        println("doProcess finalSource = $finalSource")
        structureHandler.setAttribute(attributeName.attributeName, finalSource)
    }
}
