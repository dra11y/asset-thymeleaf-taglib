package ch.itds.taglib.asset.pipeline.thymeleaf;

import org.thymeleaf.context.IExpressionContext;
import org.thymeleaf.expression.IExpressionObjectFactory;

import java.util.Collections;
import java.util.Set;

public class AssetExpressionFactory implements IExpressionObjectFactory {

    private static final String EVALUATION_VARIABLE_NAME = "asset";

    private static final Set<String> ALL_EXPRESSION_OBJECT_NAMES = Collections.unmodifiableSet(
            Collections.singleton(EVALUATION_VARIABLE_NAME)
    );

    @Override
    public Set<String> getAllExpressionObjectNames() {
        return ALL_EXPRESSION_OBJECT_NAMES;
    }

    @Override
    public Object buildObject(IExpressionContext context, String expressionObjectName) {
        if (EVALUATION_VARIABLE_NAME.equals(expressionObjectName)) {
            return new AssetExpressionObject();
        }
        return null;
    }

    @Override
    public boolean isCacheable(String expressionObjectName) {
        return EVALUATION_VARIABLE_NAME.equals(expressionObjectName);
    }
}
