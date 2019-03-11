# Asset Pipeline Thymeleaf Taglib

## Usage

1. Register dialect
    ```java
    @Configuration
    public class ThymeleafConfig {
    
        @Bean
        public AssetDialect assetDialect() {
            return new AssetDialect();
        }
    
    }
    ```

2.  Use tags
    ```html
    <script asset:src="@{/assets/main.js}"></script>
    <link asset:href="@{/assets/main.css} " th:rel="stylesheet"/>
    ```

## How it work's

The attribute tag processors try to lookup the file in the generated manifest file. If the file is available the url is rewritten according to the manifest file.

If no entry is found (e.g. in development mode) the url is not modified.