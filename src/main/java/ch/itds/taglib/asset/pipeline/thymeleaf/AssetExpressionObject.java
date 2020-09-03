package ch.itds.taglib.asset.pipeline.thymeleaf;

@SuppressWarnings("unused")
public class AssetExpressionObject {

    public String path(String path) {
        return AssetResolver.getAssetPath(path);
    }
}
