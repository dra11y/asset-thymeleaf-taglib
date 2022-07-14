package com.dra11y.assetThymeleafTaglib.expression

import org.springframework.context.annotation.Import
import org.springframework.stereotype.Component
import org.thymeleaf.context.IExpressionContext
import org.thymeleaf.expression.IExpressionObjectFactory

@Component
@Import(AssetExpression::class)
class AssetExpressionFactory(private val assetExpression: AssetExpression) : IExpressionObjectFactory {
    override fun getAllExpressionObjectNames(): Set<String> = ALL_EXPRESSION_OBJECT_NAMES

    override fun buildObject(context: IExpressionContext, expressionObjectName: String): Any? =
        if (EVALUATION_VARIABLE_NAME == expressionObjectName) {
            assetExpression
        } else null

    override fun isCacheable(expressionObjectName: String): Boolean =
        EVALUATION_VARIABLE_NAME == expressionObjectName

    companion object {
        private const val EVALUATION_VARIABLE_NAME = "asset"
        private val ALL_EXPRESSION_OBJECT_NAMES = setOf(EVALUATION_VARIABLE_NAME)
    }
}
