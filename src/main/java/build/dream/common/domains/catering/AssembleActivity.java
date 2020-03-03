package build.dream.common.domains.catering;

import build.dream.common.basic.BasicDomain;

import java.util.Date;

public class AssembleActivity extends BasicDomain {
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
     * 商品ID
     */
    private Long goodsId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品图片地址
     */
    private String imageUrl;

    /**
     * 活动名称
     */
    private String name;

    /**
     * 活动状态，1-未开始，2-进行中，3-已过期，4-已终止
     */
    private Integer status;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 是否限购，1-限购，0-不限购
     */
    private Integer limited;

    /**
     * 限购数量
     */
    private Double limitQuantity;

    /**
     * 成团人数
     */
    private Integer assemblePersons;

    /**
     * 成团时限，单位分钟
     */
    private Integer assembleTimeLimit;

    /**
     * 生效前显示时间
     */
    private Integer beforeShowTime;

    /**
     * 时间单位，1-天，2-小时，3-分钟
     */
    private Integer timeUnit;

    /**
     * 原价
     */
    private Double originalPrice;

    /**
     * 拼团价
     */
    private Double assemblePrice;

    /**
     * 拼团库存
     */
    private Double assembleStock;

    /**
     * 剩余库存
     */
    private Double surplusStock;

    /**
     * 活动说明
     */
    private String description;

    /**
     * 拼团实付金额
     */
    private Double paymentAmount;

    /**
     * 成团团数
     */
    private Integer assembleCompletedCount;

    /**
     * 成团人数
     */
    private Integer assembleCompletedPersons;
}
