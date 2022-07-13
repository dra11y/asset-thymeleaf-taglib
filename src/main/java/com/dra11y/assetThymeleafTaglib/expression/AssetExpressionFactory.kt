package com.dra11y.assetThymeleafTaglib.expression

import org.thymeleaf.context.IExpressionContext
import org.thymeleaf.expression.IExpressionObjectFactory

class AssetExpressionFactory : IExpressionObjectFactory {
    override fun getAllExpressionObjectNames(): Set<String> {
        return ALL_EXPRESSION_OBJECT_NAMES
    }

    override fun buildObject(context: IExpressionContext, expressionObjectName: String): Any? {
        return if (EVALUATION_VARIABLE_NAME == expressionObjectName) {
            AssetExpression()
        } else null
    }

    override fun isCacheable(expressionObjectName: String): Boolean {
        return EVALUATION_VARIABLE_NAME == expressionObjectName
    }

    companion object {
        private const val EVALUATION_VARIABLE_NAME = "asset"
        private val ALL_EXPRESSION_OBJECT_NAMES = setOf(EVALUATION_VARIABLE_NAME)
    }
}
