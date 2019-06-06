package build.dream.common.models.alipay;

import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class ZolozAuthenticationCustomerFtokenQueryModel extends AlipayBasicModel {
    @NotNull
    @Length(max = 64)
    private String ftoken;

    @InList(value = {"1", "2", "3", "4"})
    @JsonProperty(value = "biz_type")
    private String bizType;

    @JsonProperty(value = "ext_info")
    private ExtInfo extInfo;

    public String getFtoken() {
        return ftoken;
    }

    public void setFtoken(String ftoken) {
        this.ftoken = ftoken;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public ExtInfo getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(ExtInfo extInfo) {
        this.extInfo = extInfo;
    }

    public static class ExtInfo extends BasicModel {
        @InList(value = {"1", "2"})
        @JsonProperty(value = "query_type")
        private String queryType;

        public String getQueryType() {
            return queryType;
        }

        public void setQueryType(String queryType) {
            this.queryType = queryType;
        }
    }

    public static class Builder extends AlipayBasicModel.Builder<Builder> {
        private final ZolozAuthenticationCustomerFtokenQueryModel instance = new ZolozAuthenticationCustomerFtokenQueryModel();

        public Builder() {
            setAlipayBasicModel(instance);
        }

        public Builder ftoken(String ftoken) {
            instance.setFtoken(ftoken);
            return this;
        }

        public Builder bizType(String bizType) {
            instance.setBizType(bizType);
            return this;
        }

        public Builder extInfo(ExtInfo extInfo) {
            instance.setExtInfo(extInfo);
            return this;
        }

        public ZolozAuthenticationCustomerFtokenQueryModel build() {
            ZolozAuthenticationCustomerFtokenQueryModel zolozAuthenticationCustomerFtokenQueryModel = new ZolozAuthenticationCustomerFtokenQueryModel();
            build(zolozAuthenticationCustomerFtokenQueryModel);
            zolozAuthenticationCustomerFtokenQueryModel.setFtoken(instance.getFtoken());
            zolozAuthenticationCustomerFtokenQueryModel.setBizType(instance.getBizType());
            zolozAuthenticationCustomerFtokenQueryModel.setExtInfo(instance.getExtInfo());
            return zolozAuthenticationCustomerFtokenQueryModel;
        }

    }

    public static Builder builder() {
        return new Builder();
    }
}