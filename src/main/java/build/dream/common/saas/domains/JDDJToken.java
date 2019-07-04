package build.dream.common.saas.domains;

import build.dream.common.annotations.Table;
import build.dream.common.basic.BasicDomain;

@Table(name = "jddj_token")
public class JDDJToken extends BasicDomain {
    public static final String TABLE_NAME = "jddj_token";
    /**
     * token
     */
    private String token;

    /**
     * 有效时间
     */
    private Integer expiresIn;

    /**
     * 过期时间
     */
    private Long time;

    /**
     * uid
     */
    private String uid;

    /**
     * 用户昵称
     */
    private String userNick;

    /**
     * 商家ID
     */
    private String venderId;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public String getVenderId() {
        return venderId;
    }

    public void setVenderId(String venderId) {
        this.venderId = venderId;
    }

    public static class Builder extends BasicDomain.Builder<Builder, JDDJToken> {
        public Builder token(String token) {
            instance.setToken(token);
            return this;
        }

        public Builder expiresIn(Integer expiresIn) {
            instance.setExpiresIn(expiresIn);
            return this;
        }

        public Builder time(Long time) {
            instance.setTime(time);
            return this;
        }

        public Builder uid(String uid) {
            instance.setUid(uid);
            return this;
        }

        public Builder userNick(String userNick) {
            instance.setUserNick(userNick);
            return this;
        }

        public Builder venderId(String venderId) {
            instance.setVenderId(venderId);
            return this;
        }

        @Override
        public JDDJToken build() {
            JDDJToken jddjToken = super.build();
            jddjToken.setToken(instance.getToken());
            jddjToken.setExpiresIn(instance.getExpiresIn());
            jddjToken.setTime(instance.getTime());
            jddjToken.setUid(instance.getUid());
            jddjToken.setUserNick(instance.getUserNick());
            jddjToken.setVenderId(instance.getVenderId());
            return jddjToken;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TOKEN = "token";
        public static final String EXPIRES_IN = "expires_in";
        public static final String TIME = "time";
        public static final String UID = "uid";
        public static final String USER_NICK = "user_nick";
        public static final String VENDER_ID = "vender_id";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TOKEN = "token";
        public static final String EXPIRES_IN = "expiresIn";
        public static final String TIME = "time";
        public static final String UID = "uid";
        public static final String USER_NICK = "userNick";
        public static final String VENDER_ID = "venderId";
    }
}
