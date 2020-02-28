package build.dream.common.models;

public class OAuthBasicModel extends BasicModel {
    private String $id;
    private String $timestamp;
    private String $accessToken;

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public String get$timestamp() {
        return $timestamp;
    }

    public void set$timestamp(String $timestamp) {
        this.$timestamp = $timestamp;
    }

    public String get$accessToken() {
        return $accessToken;
    }

    public void set$accessToken(String $accessToken) {
        this.$accessToken = $accessToken;
    }
}
