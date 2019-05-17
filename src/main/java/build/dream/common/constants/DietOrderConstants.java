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

    /**
     * 订单付款状态
     *
     * @see #PAY_STATUS_UNPAID：未付款
     * @see #PAY_STATUS_PAID：已付款
     * @see #PAY_STATUS_PART_PAID：部分付款
     */
    public static final Integer PAY_STATUS_UNPAID = 1;
    public static final Integer PAY_STATUS_PAID = 2;
    public static final Integer PAY_STATUS_PART_PAID = 3;

    public static final String INVOICE_TYPE_PERSONAL = "personal";
    public static final String INVOICE_TYPE_COMPANY = "company";

    public static final String PENDING = "pending";
    public static final String UNPROCESSED = "unprocessed";
    public static final String REFUNDING = "refunding";
    public static final String VALID = "valid";
    public static final String INVALID = "invalid";
    public static final String SETTLED = "valid";

    /**
     * 订单状态
     *
     * @see #ORDER_STATUS_PENDING：未生效订单
     * @see #ORDER_STATUS_UNPROCESSED：未处理订单
     * @see #ORDER_STATUS_REFUNDING：退单中订单
     * @see #ORDER_STATUS_VALID：已处理订单
     * @see #ORDER_STATUS_INVALID：无效订单
     * @see #ORDER_STATUS_SETTLED：已完订单
     */
    public static final int ORDER_STATUS_PENDING = 1;
    public static final int ORDER_STATUS_UNPROCESSED = 2;
    public static final int ORDER_STATUS_REFUNDING = 3;
    public static final int ORDER_STATUS_VALID = 4;
    public static final int ORDER_STATUS_INVALID = 5;
    public static final int ORDER_STATUS_SETTLED = 6;

    /**
     * 订单退款状态
     *
     * @see #NO_REFUND：未申请退款
     * @see #APPLIED：用户申请退款
     * @see #REJECTED：店铺拒绝退款
     * @see #ARBITRATING：客服仲裁中
     * @see #FAILED：退款失败
     * @see #SUCCESSFUL：退款成功
     */
    public static final String NO_REFUND = "noRefund";
    public static final String APPLIED = "applied";
    public static final String REJECTED = "rejected";
    public static final String ARBITRATING = "arbitrating";
    public static final String FAILED = "failed";
    public static final String SUCCESSFUL = "successful";

    /**
     * 订单退款状态
     *
     * @see #REFUND_STATUS_NO_REFUND：未申请退款
     * @see #REFUND_STATUS_APPLIED：用户申请退款
     * @see #REFUND_STATUS_REJECTED：店铺拒绝退款
     * @see #REFUND_STATUS_ARBITRATING：客服仲裁中
     * @see #REFUND_STATUS_FAILED：退款失败
     * @see #REFUND_STATUS_SUCCESSFUL：退款成功
     */
    public static final int REFUND_STATUS_NO_REFUND = 1;
    public static final int REFUND_STATUS_APPLIED = 2;
    public static final int REFUND_STATUS_REJECTED = 3;
    public static final int REFUND_STATUS_ARBITRATING = 4;
    public static final int REFUND_STATUS_FAILED = 5;
    public static final int REFUND_STATUS_SUCCESSFUL = 6;

    /**
     * 订单分组类型
     *
     * @see #GROUP_TYPE_NORMAL：正常的菜品
     * @see #GROUP_TYPE_EXTRA：配送费等
     * @see #GROUP_TYPE_DISCOUNT：赠品
     * @see #GROUP_TYPE_COMBO：套餐
     */
    public static final String GROUP_TYPE_NORMAL = "normal";
    public static final String GROUP_TYPE_EXTRA = "extra";
    public static final String GROUP_TYPE_DISCOUNT = "discount";
    public static final String GROUP_TYPE_COMBO = "combo";

    public static final String APPLY = "apply";
    public static final String AGREE = "agree";
    public static final String REJECT = "reject";
    public static final String CANCEL_REFUND = "cancelRefund";
    public static final String CANCEL_REFUND_COMPLAINT = "cancelRefundComplaint";
}
