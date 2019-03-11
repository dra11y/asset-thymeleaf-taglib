package ch.itds.taglib.asset.pipeline.thymeleaf;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;
import org.thymeleaf.standard.processor.StandardXmlNsTagProcessor;
import org.thymeleaf.templatemode.TemplateMode;

import java.util.HashSet;
import java.util.Set;

public class AssetDialect extends AbstractProcessorDialect {

    private static final String DIALECT_NAME_SPACE = "http://www.itds.ch/taglib/assets";

    public AssetDialect() {
        super(DIALECT_NAME_SPACE, "asset", StandardDialect.PROCESSOR_PRECEDENCE);
    }


    public Set<IProcessor> getProcessors(final String dialectPrefix) {
        final Set<IProcessor> processors = new HashSet<>();
        processors.add(new AssetHrefAttributeTagProcessor(dialectPrefix));
        processors.add(new AssetSrcAttributeTagProcessor(dialectPrefix));
        processors.add(new StandardXmlNsTagProcessor(TemplateMode.HTML, dialectPrefix));
        return processors;
    }

}
