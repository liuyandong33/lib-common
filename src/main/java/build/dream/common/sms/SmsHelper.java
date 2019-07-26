package build.dream.common.sms;

public interface SmsHelper {
    /**
     * 发送验证码
     *
     * @param phoneNumber
     */
    void sendVerificationCode(String phoneNumber);

    /**
     * 验证验证码
     *
     * @param phoneNumber
     * @param code
     * @return
     */
    boolean verifyVerificationCode(String phoneNumber, String code);

    /**
     * 发送代理商账号
     *
     * @param phoneNumber
     * @param code
     * @param password
     */
    void sendAgentAccount(String phoneNumber, String code, String password);
}
