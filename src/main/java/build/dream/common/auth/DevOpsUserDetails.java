package build.dream.common.auth;

public class DevOpsUserDetails extends AbstractUserDetails {
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
