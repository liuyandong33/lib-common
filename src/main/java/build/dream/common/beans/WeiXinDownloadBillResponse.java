package build.dream.common.beans;

import java.util.List;

public class WeiXinDownloadBillResponse {
    public List<WeiXinBill> bills;
    public WeiXinBillSummary summary;

    public List<WeiXinBill> getBills() {
        return bills;
    }

    public void setBills(List<WeiXinBill> bills) {
        this.bills = bills;
    }

    public WeiXinBillSummary getSummary() {
        return summary;
    }

    public void setSummary(WeiXinBillSummary summary) {
        this.summary = summary;
    }
}
