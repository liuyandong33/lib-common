package build.dream.common.sms;

public interface SmsSender {
    /**
     * 发送验证码
     *
     * @param phoneNumber
     * @param code
     */
    void sendVerificationCode(String phoneNumber, String code);

    /**
     * 发送代理商账号
     *
     * @param phoneNumber
     * @param code
     * @param password
     */
    void sendAgentAccount(String phoneNumber, String code, String password);
}
