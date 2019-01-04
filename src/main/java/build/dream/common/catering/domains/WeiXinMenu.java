package build.dream.common.catering.domains;

import build.dream.common.annotations.ShardingColumn;
import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;
import java.util.Date;

@ShardingColumn(fieldName = WeiXinMenu.FieldName.TENANT_ID, columnName = WeiXinMenu.ColumnName.TENANT_ID)
public class WeiXinMenu extends BasicDomain {
    public static final String TABLE_NAME = "wei_xin_menu";
    /**
     * 商户ID
     */
    private BigInteger tenantId;
    /**
     * 商户编号
     */
    private String tenantCode;
    /**
     * 父级菜单ID
     */
    private BigInteger parentId;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 菜单类型，click，view，scancode_push，scancode_waitmsg，pic_sysphoto，pic_photo_or_album，pic_weixin，location_select，media_id，view_limited，miniprogram
     */
    private String type;
    /**
     * 文本消息内容
     */
    private String messageContent;
    /**
     * 永久素材media_id
     */
    private String mediaId;
    /**
     * 链接地址，或小程序备用地址
     */
    private String url;
    /**
     * 小程序页面路径
     */
    private String pagePath;
    /**
     * 小程序 app id
     */
    private String miniProgramAppId;

    public BigInteger getTenantId() {
        return tenantId;
    }

    public void setTenantId(BigInteger tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public BigInteger getParentId() {
        return parentId;
    }

    public void setParentId(BigInteger parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPagePath() {
        return pagePath;
    }

    public void setPagePath(String pagePath) {
        this.pagePath = pagePath;
    }

    public String getMiniProgramAppId() {
        return miniProgramAppId;
    }

    public void setMiniProgramAppId(String miniProgramAppId) {
        this.miniProgramAppId = miniProgramAppId;
    }

    public static class Builder {
        private WeiXinMenu instance = new WeiXinMenu();

        public Builder tenantId(BigInteger tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder tenantCode(String tenantCode) {
            instance.setTenantCode(tenantCode);
            return this;
        }

        public Builder parentId(BigInteger parentId) {
            instance.setParentId(parentId);
            return this;
        }

        public Builder name(String name) {
            instance.setName(name);
            return this;
        }

        public Builder type(String type) {
            instance.setType(type);
            return this;
        }

        public Builder messageContent(String messageContent) {
            instance.setMessageContent(messageContent);
            return this;
        }

        public Builder mediaId(String mediaId) {
            instance.setMediaId(mediaId);
            return this;
        }

        public Builder url(String url) {
            instance.setUrl(url);
            return this;
        }

        public Builder pagePath(String pagePath) {
            instance.setPagePath(pagePath);
            return this;
        }

        public Builder miniProgramAppId(String miniProgramAppId) {
            instance.setMiniProgramAppId(miniProgramAppId);
            return this;
        }

        public Builder id(BigInteger id) {
            instance.setId(id);
            return this;
        }

        public Builder createdTime(Date createdTime) {
            instance.setCreatedTime(createdTime);
            return this;
        }

        public Builder createdUserId(BigInteger createdUserId) {
            instance.setCreatedUserId(createdUserId);
            return this;
        }

        public Builder updatedTime(Date updatedTime) {
            instance.setUpdatedTime(updatedTime);
            return this;
        }

        public Builder updatedUserId(BigInteger updatedUserId) {
            instance.setUpdatedUserId(updatedUserId);
            return this;
        }

        public Builder updatedRemark(String updatedRemark) {
            instance.setUpdatedRemark(updatedRemark);
            return this;
        }

        public Builder deletedTime(Date deletedTime) {
            instance.setDeletedTime(deletedTime);
            return this;
        }

        public Builder deleted(boolean deleted) {
            instance.setDeleted(deleted);
            return this;
        }

        public WeiXinMenu build() {
            return instance;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class ColumnName extends BasicDomain.ColumnName {
        public static final String TENANT_ID = "tenant_id";
        public static final String TENANT_CODE = "tenant_code";
        public static final String PARENT_ID = "parent_id";
        public static final String NAME = "name";
        public static final String TYPE = "type";
        public static final String MESSAGE_CONTENT = "message_content";
        public static final String MEDIA_ID = "media_id";
        public static final String URL = "url";
        public static final String PAGE_PATH = "page_path";
        public static final String MINI_PROGRAM_APP_ID = "mini_program_app_id";
    }

    public static final class FieldName extends BasicDomain.FieldName {
        public static final String TENANT_ID = "tenantId";
        public static final String TENANT_CODE = "tenantCode";
        public static final String PARENT_ID = "parentId";
        public static final String NAME = "name";
        public static final String TYPE = "type";
        public static final String MESSAGE_CONTENT = "messageContent";
        public static final String MEDIA_ID = "mediaId";
        public static final String URL = "url";
        public static final String PAGE_PATH = "pagePath";
        public static final String MINI_PROGRAM_APP_ID = "miniProgramAppId";
    }
}