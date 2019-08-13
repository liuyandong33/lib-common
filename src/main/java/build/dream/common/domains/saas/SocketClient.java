package build.dream.common.domains.saas;

import build.dream.common.basic.BasicDomain;

public class SocketClient extends BasicDomain {
    public static final String TABLE_NAME = "socket_client";
    /**
     * session id
     */
    private String sessionId;

    /**
     * 账号
     */
    private String account;

    /**
     * 别名
     */
    private String alias;

    /**
     * 标签
     */
    private String tag;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public static class Builder extends BasicDomain.Builder<Builder, SocketClient> {
        public Builder sessionId(String sessionId) {
            instance.setSessionId(sessionId);
            return this;
        }

        public Builder account(String account) {
            instance.setAccount(account);
            return this;
        }

        public Builder alias(String alias) {
            instance.setAlias(alias);
            return this;
        }

        public Builder tag(String tag) {
            instance.setTag(tag);
            return this;
        }

        @Override
        public SocketClient build() {
            SocketClient socketClient = super.build();
            socketClient.setSessionId(instance.getSessionId());
            socketClient.setAccount(instance.getAccount());
            socketClient.setAlias(instance.getAlias());
            socketClient.setTag(instance.getTag());
            return socketClient;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String SESSION_ID = "session_id";
        public static final String ACCOUNT = "account";
        public static final String ALIAS = "alias";
        public static final String TAG = "tag";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String SESSION_ID = "sessionId";
        public static final String ACCOUNT = "account";
        public static final String ALIAS = "alias";
        public static final String TAG = "tag";
    }
}
