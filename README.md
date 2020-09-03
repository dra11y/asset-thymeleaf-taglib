# Asset Pipeline Thymeleaf Taglib

[ ![Download](https://api.bintray.com/packages/mkobel/plugins/asset-pipeline-thymeleaf-taglib/images/download.svg) ](https://bintray.com/mkobel/plugins/asset-pipeline-thymeleaf-taglib/_latestVersion)

## Usage

```html
    <!DOCTYPE html>
    <html xmlns:asset="https://www.itds.ch/taglib/asset">
    <script asset:src="@{/assets/main.js}"></script>
    <link asset:href="@{/assets/main.css}" rel="stylesheet"/>
    <meta name="msapplication-TileImage" th:content="${#asset.path('/assets/favicons/mstile-144x144.png')}"/>
    </html>
```

### Register Dialect

If auto-configuration is disabled or not available you must register the dialect as follows:

```java
@Configuration
public class ThymeleafConfig {

    @Bean
    public AssetDialect assetDialect() {
        return new AssetDialect();
    }
}
```


## How it works

The attribute tag processors try to lookup the file in the generated manifest file. If the file is available the url is rewritten according to the manifest file.

If no entry is found (e.g. in development mode) the url is not modified.
