package build.dream.common.models.alipay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AlipayCommerceLotteryPresentListQueryModel extends AlipayBasicModel {
    @NotNull
    @Length(min = 8, max = 8)
    @JsonProperty(value = "gmt_start")
    private String gmtStart;

    @NotNull
    @Length(min = 8, max = 8)
    @JsonProperty(value = "gmt_end")
    private String gmtEnd;

    @Min(value = 1)
    @Max(value = 10000)
    @JsonProperty(value = "page_no")
    private Integer pageNo;

    @Min(value = 1)
    @Max(value = 500)
    @JsonProperty(value = "page_size")
    private Integer pageSize;

    public String getGmtStart() {
        return gmtStart;
    }

    public void setGmtStart(String gmtStart) {
        this.gmtStart = gmtStart;
    }

    public String getGmtEnd() {
        return gmtEnd;
    }

    public void setGmtEnd(String gmtEnd) {
        this.gmtEnd = gmtEnd;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public static class Builder {
        private final AlipayCommerceLotteryPresentListQueryModel instance = new AlipayCommerceLotteryPresentListQueryModel();

        public Builder tenantId(String tenantId) {
            instance.setTenantId(tenantId);
            return this;
        }

        public Builder branchId(String branchId) {
            instance.setBranchId(branchId);
            return this;
        }

        public Builder returnUrl(String returnUrl) {
            instance.setReturnUrl(returnUrl);
            return this;
        }

        public Builder notifyUrl(String notifyUrl) {
            instance.setNotifyUrl(notifyUrl);
            return this;
        }

        public Builder authToken(String authToken) {
            instance.setAuthToken(authToken);
            return this;
        }

        public Builder gmtStart(String gmtStart) {
            instance.setGmtStart(gmtStart);
            return this;
        }

        public Builder gmtEnd(String gmtEnd) {
            instance.setGmtEnd(gmtEnd);
            return this;
        }

        public Builder pageNo(Integer pageNo) {
            instance.setPageNo(pageNo);
            return this;
        }

        public Builder pageSize(Integer pageSize) {
            instance.setPageSize(pageSize);
            return this;
        }

        public AlipayCommerceLotteryPresentListQueryModel build() {
            AlipayCommerceLotteryPresentListQueryModel alipayCommerceLotteryPresentListQueryModel = new AlipayCommerceLotteryPresentListQueryModel();
            alipayCommerceLotteryPresentListQueryModel.setTenantId(instance.getTenantId());
            alipayCommerceLotteryPresentListQueryModel.setBranchId(instance.getBranchId());
            alipayCommerceLotteryPresentListQueryModel.setGmtStart(instance.getGmtStart());
            alipayCommerceLotteryPresentListQueryModel.setGmtEnd(instance.getGmtEnd());
            alipayCommerceLotteryPresentListQueryModel.setPageNo(instance.getPageNo());
            alipayCommerceLotteryPresentListQueryModel.setPageSize(instance.getPageSize());
            return alipayCommerceLotteryPresentListQueryModel;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
