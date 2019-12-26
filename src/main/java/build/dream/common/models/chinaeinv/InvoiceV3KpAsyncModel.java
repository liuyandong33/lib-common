package build.dream.common.models.chinaeinv;

import build.dream.common.constants.Constants;
import build.dream.common.models.BasicModel;
import build.dream.common.utils.CustomDateUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class InvoiceV3KpAsyncModel extends BasicModel {
    @NotNull
    @Length(max = 50)
    private String serialNo;

    @NotNull
    @Length(max = 19)
    private String postTime = CustomDateUtils.format(new Date(), Constants.DEFAULT_DATE_PATTERN);

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
    }
}
