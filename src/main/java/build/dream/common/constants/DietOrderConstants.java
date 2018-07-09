package build.dream.common.constants;

public class DietOrderConstants {
    public static final Integer ORDER_TYPE_SCAN_CODE_ORDER = 1;
    public static final Integer ORDER_TYPE_ELEME_ORDER = 2;
    public static final Integer ORDER_TYPE_MEI_TUAN_ORDER = 3;
    public static final Integer ORDER_TYPE_WEI_XIN_ORDER = 4;

    public static final Integer PAID_TYPE_WEI_XIN = 1;
    public static final Integer PAID_TYPE_ALIPAY = 2;
    public static final Integer PAID_TYPE_ELEME_ON_LINE_PAID = 3;
    public static final Integer PAID_TYPE_MEI_TUAN_ON_LINE_PAID = 4;

    public static final Integer PAY_STATUS_UNPAID = 1;
    public static final Integer PAY_STATUS_PAID = 2;

    public static final String INVOICE_TYPE_PERSONAL = "personal";
    public static final String INVOICE_TYPE_COMPANY = "company";

    public static final String PENDING = "pending";
    public static final String UNPROCESSED = "unprocessed";
    public static final String REFUNDING = "refunding";
    public static final String VALID = "valid";
    public static final String INVALID = "invalid";
    public static final String SETTLED = "valid";

    public static final int ORDER_STATUS_PENDING = 1;
    public static final int ORDER_STATUS_UNPROCESSED = 2;
    public static final int ORDER_STATUS_REFUNDING = 3;
    public static final int ORDER_STATUS_VALID = 4;
    public static final int ORDER_STATUS_INVALID = 5;
    public static final int ORDER_STATUS_SETTLED = 6;

    public static final String NO_REFUND = "noRefund";
    public static final String APPLIED = "applied";
    public static final String REJECTED = "rejected";
    public static final String ARBITRATING = "arbitrating";
    public static final String FAILED = "failed";
    public static final String SUCCESSFUL = "successful";

    public static final int REFUND_STATUS_NO_REFUND = 1;
    public static final int REFUND_STATUS_APPLIED = 2;
    public static final int REFUND_STATUS_REJECTED = 3;
    public static final int REFUND_STATUS_ARBITRATING = 4;
    public static final int REFUND_STATUS_FAILED = 5;
    public static final int REFUND_STATUS_SUCCESSFUL = 6;

    public static final String GROUP_TYPE_NORMAL = "normal";
    public static final String GROUP_TYPE_EXTRA = "extra";
    public static final String GROUP_TYPE_DISCOUNT = "discount";
}
