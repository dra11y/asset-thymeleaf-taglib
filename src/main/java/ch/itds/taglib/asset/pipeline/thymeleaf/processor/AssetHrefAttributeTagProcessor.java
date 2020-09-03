package ch.itds.taglib.asset.pipeline.thymeleaf.processor;

import org.thymeleaf.templatemode.TemplateMode;

public class AssetHrefAttributeTagProcessor extends AbstractAssetAttributeTagProcessor {

    private static final String ATTR_NAME = "href";
    private static final int PRECEDENCE = 1000;

    public AssetHrefAttributeTagProcessor(final String dialectPrefix) {
        super(
                TemplateMode.HTML, // This processor will apply only to HTML mode
                dialectPrefix,     // Prefix to be applied to name for matching
                null,              // No tag name: match any tag name
                false,             // No prefix to be applied to tag name
                ATTR_NAME,         // Name of the attribute that will be matched
                true,              // Apply dialect prefix to attribute name
                PRECEDENCE,        // Precedence (inside dialect's precedence)
                true);             // Remove the matched attribute afterwards
    }
}
