package build.dream.common.domains.catering;

import build.dream.common.basic.BasicDomain;

import java.util.Date;

public class DataHandleHistory extends BasicDomain {
    public static final String TABLE_NAME = "data_handle_history";
    /**
     * 商户ID
     */
    private Long tenantId;
    /**
     * 商户编码
     */
    private String tenantCode;
    /**
     * 门店ID
     */
    private Long branchId;
    /**
     * 数据签名
     */
    private String signature;
    /**
     * 数据类型
     */
    private String dataType;
    /**
     * 数据内容
     */
    private String dataContent;
    /**
     * 处理时间
     */
    private Date handleTime;

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDataContent() {
        return dataContent;
    }

    public void setDataContent(String dataContent) {
        this.dataContent = dataContent;
    }

    public Date getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }
}
