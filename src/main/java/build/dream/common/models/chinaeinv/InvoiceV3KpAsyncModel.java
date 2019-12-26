package build.dream.common.models.chinaeinv;

import build.dream.common.constants.Constants;
import build.dream.common.models.BasicModel;
import build.dream.common.utils.CustomDateUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class InvoiceV3KpAsyncModel extends BasicModel {
    @NotNull
    private String appCode;

    @NotNull
    @Length(max = 50)
    private String serialNo;

    @NotNull
    @Length(max = 19)
    private String postTime = CustomDateUtils.format(new Date(), Constants.DEFAULT_DATE_PATTERN);

    @NotNull
    private Order order;

    @NotNull
    private Invoice invoice;

    @NotEmpty
    private List<Item> items;

    @NotEmpty
    private List<Notice> notices;

    private Map<String, Object> extendedParams;

    private Map<String, Object> dynamicParams;

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Notice> getNotices() {
        return notices;
    }

    public void setNotices(List<Notice> notices) {
        this.notices = notices;
    }

    public Map<String, Object> getExtendedParams() {
        return extendedParams;
    }

    public void setExtendedParams(Map<String, Object> extendedParams) {
        this.extendedParams = extendedParams;
    }

    public Map<String, Object> getDynamicParams() {
        return dynamicParams;
    }

    public void setDynamicParams(Map<String, Object> dynamicParams) {
        this.dynamicParams = dynamicParams;
    }

    public static class Order extends BasicModel {
        @NotNull
        @Length(max = 50)
        private String orderNo;

        @Length(max = 100)
        private String account;

        @Length(max = 250)
        private String address;

        private String tel;

        private String email;

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

    public static class Invoice extends BasicModel {
        /**
         * 销货方纳税人识别号
         */
        @NotNull
        @Length(max = 20)
        private String taxpayerCode;

        /**
         * 销货方纳税人名称
         */
        @Length(max = 100)
        private String taxpayerName;

        /**
         * 销货方地址。如果填写则使用填写的信息，否则使用纳税人注册时预留的信息。
         */
        @Length(max = 79)
        private String taxpayerAddress;

        /**
         * 销货方电话
         */
        @Length(max = 20)
        private String taxpayerTel;

        /**
         * 销货方开户银行
         */
        @Length(max = 69)
        private String taxpayerBankName;

        /**
         * 销货方银行账号
         */
        @Length(max = 30)
        private String taxpayerBankAccount;

        /**
         * 购货方名称，即发票抬头
         */
        @NotNull
        @Length(max = 100)
        private String customerName;

        /**
         * 购货方纳税人识别号或者个人身份证号
         */
        @Length(max = 20)
        private String customerCode;

        /**
         * 购货方地址
         */
        @Length(max = 69)
        private String customerAddress;

        /**
         * 购货方电话
         */
        @Length(max = 20)
        private String customerTel;

        /**
         * 购货方开户银行
         */
        @Length(max = 69)
        private String customerBankName;

        /**
         * 购货方银行账号
         */
        @Length(max = 30)
        private String customerBankAccount;

        /**
         * 开票类型。p:电子增值税普通发票（默认） ps:电子收购发票 py：成品油
         */
        @Length(max = 2)
        private String invoiceType;

        /**
         * 店铺编号
         */
        @Length(max = 50)
        private String shopCode;

        /**
         * 店铺名称
         */
        @Length(max = 50)
        private String shopName;

        /**
         * 支付方式
         */
        @Length(max = 50)
        private String payType;

        /**
         * 支付流水号
         */
        @Length(max = 50)
        private String payBillNo;

        /**
         * 开票人
         */
        @Length(max = 8)
        private String drawer;

        /**
         * 收款人
         */
        @Length(max = 8)
        private String payee;

        /**
         * 复核人
         */
        @Length(max = 8)
        private String reviewer;

        /**
         * 税价合计金额。必须大于等于0.01元；必须等于发票明细合计金额；必须小于等于在税务局进行票种核定时确定的单张发票开票限额。
         */
        @NotNull
        private Double totalAmount;

        /**
         * 发票备注
         */
        @Length(max = 130)
        private String remark;

        public String getTaxpayerCode() {
            return taxpayerCode;
        }

        public void setTaxpayerCode(String taxpayerCode) {
            this.taxpayerCode = taxpayerCode;
        }

        public String getTaxpayerName() {
            return taxpayerName;
        }

        public void setTaxpayerName(String taxpayerName) {
            this.taxpayerName = taxpayerName;
        }

        public String getTaxpayerAddress() {
            return taxpayerAddress;
        }

        public void setTaxpayerAddress(String taxpayerAddress) {
            this.taxpayerAddress = taxpayerAddress;
        }

        public String getTaxpayerTel() {
            return taxpayerTel;
        }

        public void setTaxpayerTel(String taxpayerTel) {
            this.taxpayerTel = taxpayerTel;
        }

        public String getTaxpayerBankName() {
            return taxpayerBankName;
        }

        public void setTaxpayerBankName(String taxpayerBankName) {
            this.taxpayerBankName = taxpayerBankName;
        }

        public String getTaxpayerBankAccount() {
            return taxpayerBankAccount;
        }

        public void setTaxpayerBankAccount(String taxpayerBankAccount) {
            this.taxpayerBankAccount = taxpayerBankAccount;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public String getCustomerCode() {
            return customerCode;
        }

        public void setCustomerCode(String customerCode) {
            this.customerCode = customerCode;
        }

        public String getCustomerAddress() {
            return customerAddress;
        }

        public void setCustomerAddress(String customerAddress) {
            this.customerAddress = customerAddress;
        }

        public String getCustomerTel() {
            return customerTel;
        }

        public void setCustomerTel(String customerTel) {
            this.customerTel = customerTel;
        }

        public String getCustomerBankName() {
            return customerBankName;
        }

        public void setCustomerBankName(String customerBankName) {
            this.customerBankName = customerBankName;
        }

        public String getCustomerBankAccount() {
            return customerBankAccount;
        }

        public void setCustomerBankAccount(String customerBankAccount) {
            this.customerBankAccount = customerBankAccount;
        }

        public String getInvoiceType() {
            return invoiceType;
        }

        public void setInvoiceType(String invoiceType) {
            this.invoiceType = invoiceType;
        }

        public String getShopCode() {
            return shopCode;
        }

        public void setShopCode(String shopCode) {
            this.shopCode = shopCode;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public String getPayType() {
            return payType;
        }

        public void setPayType(String payType) {
            this.payType = payType;
        }

        public String getPayBillNo() {
            return payBillNo;
        }

        public void setPayBillNo(String payBillNo) {
            this.payBillNo = payBillNo;
        }

        public String getDrawer() {
            return drawer;
        }

        public void setDrawer(String drawer) {
            this.drawer = drawer;
        }

        public String getPayee() {
            return payee;
        }

        public void setPayee(String payee) {
            this.payee = payee;
        }

        public String getReviewer() {
            return reviewer;
        }

        public void setReviewer(String reviewer) {
            this.reviewer = reviewer;
        }

        public Double getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(Double totalAmount) {
            this.totalAmount = totalAmount;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }

    public static class Item extends BasicModel {
        /**
         * 发票行性质 0 正常行、1 折扣行、2 被折扣行
         */
        @NotNull
        @Length(max = 1)
        private String type;

        /**
         * 商品编码
         */
        @Length(max = 50)
        private String code;

        /**
         * 商品名称。可在每一行商品下加入折扣行,折扣行商品名称与被折扣商品名称一致,金额和税额栏以负数填写,税率与被折扣行商品税率相同,其它栏不填写。
         */
        @NotNull
        @Length(max = 90)
        private String name;

        /**
         * 规格型号
         */
        @Length(max = 40)
        private String spec;

        /**
         * 商品单价。必须等于amount/quantity的四舍五入值
         */
        private Double price;

        /**
         * 数量。必须大于等于0.000001
         */
        private Double quantity;

        /**
         * 单位
         */
        @Length(max = 20)
        private String uom;

        /**
         * 税率。只能为0、 0.03、0.04、0.06、0.10、0.11、0.16、0.17。
         */
        @NotNull
        private Double taxRate;

        /**
         * 税价合计金额
         */
        @NotNull
        private Double amount;

        /**
         * 商品分类编码。目前的分类编码为19位，不足19位的在后面补0。
         */
        @NotNull
        @Length(max = 50)
        private String catalogCode;

        /**
         * 优惠政策标识。0:不使用,1:使用。
         */
        @Length(max = 1)
        private String preferentialPolicyFlg;

        /**
         * 增值税特殊管理（当优惠政策标识为1时必填）。
         */
        @Length(max = 50)
        private String addedValueTaxFlg;

        /**
         * 零税率标识。1:免税,2:不征税,3:普通零税率。税率为零的情况下，如果不传，则默认为3:普通零税率。
         */
        @Length(max = 1)
        private String zeroTaxRateFlg;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSpec() {
            return spec;
        }

        public void setSpec(String spec) {
            this.spec = spec;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public Double getQuantity() {
            return quantity;
        }

        public void setQuantity(Double quantity) {
            this.quantity = quantity;
        }

        public String getUom() {
            return uom;
        }

        public void setUom(String uom) {
            this.uom = uom;
        }

        public Double getTaxRate() {
            return taxRate;
        }

        public void setTaxRate(Double taxRate) {
            this.taxRate = taxRate;
        }

        public Double getAmount() {
            return amount;
        }

        public void setAmount(Double amount) {
            this.amount = amount;
        }

        public String getCatalogCode() {
            return catalogCode;
        }

        public void setCatalogCode(String catalogCode) {
            this.catalogCode = catalogCode;
        }

        public String getPreferentialPolicyFlg() {
            return preferentialPolicyFlg;
        }

        public void setPreferentialPolicyFlg(String preferentialPolicyFlg) {
            this.preferentialPolicyFlg = preferentialPolicyFlg;
        }

        public String getAddedValueTaxFlg() {
            return addedValueTaxFlg;
        }

        public void setAddedValueTaxFlg(String addedValueTaxFlg) {
            this.addedValueTaxFlg = addedValueTaxFlg;
        }

        public String getZeroTaxRateFlg() {
            return zeroTaxRateFlg;
        }

        public void setZeroTaxRateFlg(String zeroTaxRateFlg) {
            this.zeroTaxRateFlg = zeroTaxRateFlg;
        }
    }

    public static class Notice extends BasicModel {
        /**
         * 通知类型。短信：sms；电子邮件：email。
         */
        @NotNull
        private String type;

        /**
         * 通知类型为短信时，必须为手机号码；通知类型为电子邮件时，必须为邮件地址。
         */
        @NotNull
        private String value;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
