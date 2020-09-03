package ch.itds.taglib.asset.pipeline.thymeleaf.processor;

import ch.itds.taglib.asset.pipeline.thymeleaf.asset.AssetResolver;
import org.thymeleaf.IEngineConfiguration;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractAttributeTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.standard.expression.IStandardExpression;
import org.thymeleaf.standard.expression.IStandardExpressionParser;
import org.thymeleaf.standard.expression.StandardExpressions;
import org.thymeleaf.templatemode.TemplateMode;

abstract class AbstractAssetAttributeTagProcessor extends AbstractAttributeTagProcessor {


    protected AbstractAssetAttributeTagProcessor(TemplateMode templateMode, String dialectPrefix, String elementName,
                                                 boolean prefixElementName, String attributeName,
                                                 boolean prefixAttributeName, int precedence, boolean removeAttribute) {
        super(templateMode, dialectPrefix, elementName, prefixElementName,
                attributeName, prefixAttributeName, precedence, removeAttribute);
    }

    protected void doProcess(final ITemplateContext context, final IProcessableElementTag tag,
                             final AttributeName attributeName, final String attributeValue,
                             final IElementTagStructureHandler structureHandler) {
        final IEngineConfiguration configuration = context.getConfiguration();
        final IStandardExpressionParser parser = StandardExpressions.getExpressionParser(configuration);
        final IStandardExpression expression = parser.parseExpression(context, attributeValue);

        final String directSource = (String) expression.execute(context);
        final String finalSource = AssetResolver.getAssetPath(directSource);

        structureHandler.setAttribute(attributeName.getAttributeName(), finalSource);
    }
}
