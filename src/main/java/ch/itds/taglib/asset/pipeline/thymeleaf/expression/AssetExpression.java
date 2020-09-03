package ch.itds.taglib.asset.pipeline.thymeleaf.expression;

import ch.itds.taglib.asset.pipeline.thymeleaf.asset.AssetResolver;

@SuppressWarnings("unused")
public class AssetExpression {

    public String path(String path) {
        return AssetResolver.getAssetPath(path);
    }
}
