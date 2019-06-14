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

    /**
     * 配送单主状态
     *
     * @see #DELIVERY_STATE_TOBE_ASSIGNED_MERCHANT：待分配（物流系统已生成运单，待分配配送商）
     * @see #DELIVERY_STATE_TOBE_ASSIGNED_COURIER：待分配（配送系统已接单，待分配配送员）
     * @see #DELIVERY_STATE_TOBE_FETCHED：待取餐（已分配给配送员，配送员未取餐）
     * @see #DELIVERY_STATE_DELIVERING：配送中（配送员已取餐，正在配送）
     * @see #DELIVERY_STATE_COMPLETED：配送成功（配送员配送完成）
     * @see #DELIVERY_STATE_CANCELLED：配送取消（商家可以重新发起配送）
     * @see #DELIVERY_STATE_EXCEPTION：配送异常
     * @see #DELIVERY_STATE_ARRIVED：已到店(配送员已到店)
     * @see #DELIVERY_STATE_SELF_DELIVERY：商家自行配送
     * @see #DELIVERY_STATE_NO_MORE_DELIVERY：商家不再配送
     * @see #DELIVERY_STATE_REJECT：物流拒单
     */
    public static final String DELIVERY_STATE_TOBE_ASSIGNED_MERCHANT = "tobeAssignedMerchant";
    public static final String DELIVERY_STATE_TOBE_ASSIGNED_COURIER = "tobeAssignedCourier";
    public static final String DELIVERY_STATE_TOBE_FETCHED = "tobeFetched";
    public static final String DELIVERY_STATE_DELIVERING = "delivering";
    public static final String DELIVERY_STATE_COMPLETED = "completed";
    public static final String DELIVERY_STATE_CANCELLED = "cancelled";
    public static final String DELIVERY_STATE_EXCEPTION = "exception";
    public static final String DELIVERY_STATE_ARRIVED = "cancelled";
    public static final String DELIVERY_STATE_SELF_DELIVERY = "selfDelivery";
    public static final String DELIVERY_STATE_NO_MORE_DELIVERY = "noMoreDelivery";
    public static final String DELIVERY_STATE_REJECT = "reject";

    /**
     * 配送单子状态
     *
     * @see #DELIVERY_SUB_STATE_MERCHANT_REASON：商家取消
     * @see #DELIVERY_SUB_STATE_CARRIER_REASON：配送商取消
     * @see #DELIVERY_SUB_STATE_USER_REASON：用户取消
     * @see #DELIVERY_SUB_STATE_SYSTEM_REASON：物流系统取消
     * @see #DELIVERY_SUB_STATE_MERCHANT_CALL_LATE_ERROR：呼叫配送晚
     * @see #DELIVERY_SUB_STATE_MERCHANT_FOOD_ERROR：餐厅出餐问题
     * @see #DELIVERY_SUB_STATE_MERCHANT_INTERRUPT_DELIVERY_ERROR：商户中断配送
     * @see #DELIVERY_SUB_STATE_USER_NOT_ANSWER_ERROR：用户不接电话
     * @see #DELIVERY_SUB_STATE_USER_RETURN_ORDER_ERROR：用户退单
     * @see #DELIVERY_SUB_STATE_USER_ADDRESS_ERROR：用户地址错误
     * @see #DELIVERY_SUB_STATE_DELIVERY_OUT_OF_SERVICE：超出服务范围
     * @see #DELIVERY_SUB_STATE_CARRIER_REMARK_EXCEPTION_ERROR：骑手标记异常
     * @see #DELIVERY_SUB_STATE_SYSTEM_MARKED_ERROR：系统自动标记异常--订单超过3小时未送达
     * @see #DELIVERY_SUB_STATE_OTHER_ERROR：其他异常
     * @see #DELIVERY_SUB_STATE_DELIVERY_TIMEOUT：配送超时，系统标记异常
     * @see #DELIVERY_SUB_STATE_ONLINE_PAY_ERROR：只支持在线订单
     * @see #DELIVERY_SUB_STATE_CONSUMER_LOCATION_TOO_FAR_ERROR：超出服务范围
     * @see #DELIVERY_SUB_STATE_MERCHANT_PUSH_TOO_LATE_ERROR：请求配送过晚无法呼叫
     * @see #DELIVERY_SUB_STATE_SYSTEM_ERROR：系统异常
     * @see #DELIVERY_SUB_STATE_NO_SUB_STATE：无配送子状态
     */
    public static final String DELIVERY_SUB_STATE_MERCHANT_REASON = "merchantReason";
    public static final String DELIVERY_SUB_STATE_CARRIER_REASON = "carrierReason";
    public static final String DELIVERY_SUB_STATE_USER_REASON = "userReason";
    public static final String DELIVERY_SUB_STATE_SYSTEM_REASON = "systemReason";
    public static final String DELIVERY_SUB_STATE_MERCHANT_CALL_LATE_ERROR = "merchantCallLateError";
    public static final String DELIVERY_SUB_STATE_MERCHANT_FOOD_ERROR = "merchantFoodError";
    public static final String DELIVERY_SUB_STATE_MERCHANT_INTERRUPT_DELIVERY_ERROR = "merchantInterruptDeliveryError";
    public static final String DELIVERY_SUB_STATE_USER_NOT_ANSWER_ERROR = "userNotAnswerError";
    public static final String DELIVERY_SUB_STATE_USER_RETURN_ORDER_ERROR = "userReturnOrderError";
    public static final String DELIVERY_SUB_STATE_USER_ADDRESS_ERROR = "userAddressError";
    public static final String DELIVERY_SUB_STATE_DELIVERY_OUT_OF_SERVICE = "deliveryOutOfService";
    public static final String DELIVERY_SUB_STATE_CARRIER_REMARK_EXCEPTION_ERROR = "carrierRemarkExceptionError";
    public static final String DELIVERY_SUB_STATE_SYSTEM_MARKED_ERROR = "systemMarkedError";
    public static final String DELIVERY_SUB_STATE_OTHER_ERROR = "otherError";
    public static final String DELIVERY_SUB_STATE_DELIVERY_TIMEOUT = "deliveryTimeout";
    public static final String DELIVERY_SUB_STATE_ONLINE_PAY_ERROR = "onlinePayError";
    public static final String DELIVERY_SUB_STATE_CONSUMER_LOCATION_TOO_FAR_ERROR = "consumerLocationTooFarError";
    public static final String DELIVERY_SUB_STATE_MERCHANT_PUSH_TOO_LATE_ERROR = "merchantPushTooLateError";
    public static final String DELIVERY_SUB_STATE_SYSTEM_ERROR = "systemError";
    public static final String DELIVERY_SUB_STATE_NO_SUB_STATE = "noSubstate";
}
