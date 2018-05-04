package build.dream.common.erp.catering.domains;

import build.dream.common.basic.BasicDomain;

import java.math.BigInteger;

public class PackageGroup extends BasicDomain {
    private BigInteger packageId;
    private String groupName;
    private Integer groupType;
    private Integer optionalQuantity;

    public BigInteger getPackageId() {
        return packageId;
    }

    public void setPackageId(BigInteger packageId) {
        this.packageId = packageId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getGroupType() {
        return groupType;
    }

    public void setGroupType(Integer groupType) {
        this.groupType = groupType;
    }

    public Integer getOptionalQuantity() {
        return optionalQuantity;
    }

    public void setOptionalQuantity(Integer optionalQuantity) {
        this.optionalQuantity = optionalQuantity;
    }
}
