package ch.itds.taglib.asset.pipeline.thymeleaf;

import asset.pipeline.AssetPipelineConfigHolder;

import java.util.Properties;

public class AssetResolver {

    private static final String DEFAULT_ASSET_PATH_PREFIX = "/assets/";

    public static String getAssetPath(String path) {
        String assetPath = path;
        final Properties manifest = AssetPipelineConfigHolder.manifest;

        if (manifest != null && assetPath.startsWith(DEFAULT_ASSET_PATH_PREFIX)) {
            String file = assetPath.substring(DEFAULT_ASSET_PATH_PREFIX.length());
            String mappedFile = manifest.getProperty(file);

            if (mappedFile != null) {
                assetPath = DEFAULT_ASSET_PATH_PREFIX + mappedFile;
            }
        }

        return assetPath;
    }
}
