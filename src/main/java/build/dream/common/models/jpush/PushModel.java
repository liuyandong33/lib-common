package build.dream.common.models.jpush;

import build.dream.common.models.BasicModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class PushModel extends BasicModel {
    private String platform;
    private Audience audience;
    private Notification notification;
    private Message message;
    @SerializedName(value = "sms_message", alternate = "smsMessage")
    private SmsMessage smsMessage;
    private Options options;
    private String cid;

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Audience getAudience() {
        return audience;
    }

    public void setAudience(Audience audience) {
        this.audience = audience;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public SmsMessage getSmsMessage() {
        return smsMessage;
    }

    public void setSmsMessage(SmsMessage smsMessage) {
        this.smsMessage = smsMessage;
    }

    public Options getOptions() {
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public static class Audience {
        private List<String> tag;
        private List<String> tagAnd;
        private List<String> tagNot;
        private List<String> alias;
        @SerializedName(value = "registration_id", alternate = "registrationId")
        private List<String> registrationId;
        private List<String> segment;
        private List<String> abtest;

        public List<String> getTag() {
            return tag;
        }

        public void setTag(List<String> tag) {
            this.tag = tag;
        }

        public List<String> getTagAnd() {
            return tagAnd;
        }

        public void setTagAnd(List<String> tagAnd) {
            this.tagAnd = tagAnd;
        }

        public List<String> getTagNot() {
            return tagNot;
        }

        public void setTagNot(List<String> tagNot) {
            this.tagNot = tagNot;
        }

        public List<String> getAlias() {
            return alias;
        }

        public void setAlias(List<String> alias) {
            this.alias = alias;
        }

        public List<String> getRegistrationId() {
            return registrationId;
        }

        public void setRegistrationId(List<String> registrationId) {
            this.registrationId = registrationId;
        }

        public List<String> getSegment() {
            return segment;
        }

        public void setSegment(List<String> segment) {
            this.segment = segment;
        }

        public List<String> getAbtest() {
            return abtest;
        }

        public void setAbtest(List<String> abtest) {
            this.abtest = abtest;
        }
    }

    public static class Notification {
        private String alert;
        public String getAlert() {
            return alert;
        }

        public void setAlert(String alert) {
            this.alert = alert;
        }

        private Android android;

        private Ios ios;

        @SerializedName(value = "winphone", alternate = "winPhone")
        private WinPhone winPhone;

        public Android getAndroid() {
            return android;
        }

        public void setAndroid(Android android) {
            this.android = android;
        }
    }

    public static class Android {
        private String title;
        @SerializedName(value = "builder_id", alternate = "builderId")
        private Integer builderId;
        private Integer priority;
        private String category;
        private Integer style;
        @SerializedName(value = "alert_type", alternate = "alertType")
        private Integer alertType;
        @SerializedName(value = "big_text", alternate = "bigText")
        private String bigText;
        private Map<String, Object> inbox;
        @SerializedName(value = "big_pic_path", alternate = "bigPicPath")
        private String bigPicPath;
        private Map<String, Object> extras;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Integer getBuilderId() {
            return builderId;
        }

        public void setBuilderId(Integer builderId) {
            this.builderId = builderId;
        }

        public Integer getPriority() {
            return priority;
        }

        public void setPriority(Integer priority) {
            this.priority = priority;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public Integer getStyle() {
            return style;
        }

        public void setStyle(Integer style) {
            this.style = style;
        }

        public Integer getAlertType() {
            return alertType;
        }

        public void setAlertType(Integer alertType) {
            this.alertType = alertType;
        }

        public String getBigText() {
            return bigText;
        }

        public void setBigText(String bigText) {
            this.bigText = bigText;
        }

        public Map<String, Object> getInbox() {
            return inbox;
        }

        public void setInbox(Map<String, Object> inbox) {
            this.inbox = inbox;
        }

        public String getBigPicPath() {
            return bigPicPath;
        }

        public void setBigPicPath(String bigPicPath) {
            this.bigPicPath = bigPicPath;
        }

        public Map<String, Object> getExtras() {
            return extras;
        }

        public void setExtras(Map<String, Object> extras) {
            this.extras = extras;
        }
    }

    public static class Ios {
        private String alert;
        private String sound;
        private String badge;
        @SerializedName(value = "content-available", alternate = "contentAvailable")
        private Boolean contentAvailable;
        @SerializedName(value = "mutable-content", alternate = "mutableContent")
        private Boolean mutableContent;
        private String category;
        Map<String, Object> extras;

        public String getAlert() {
            return alert;
        }

        public void setAlert(String alert) {
            this.alert = alert;
        }

        public String getSound() {
            return sound;
        }

        public void setSound(String sound) {
            this.sound = sound;
        }

        public String getBadge() {
            return badge;
        }

        public void setBadge(String badge) {
            this.badge = badge;
        }

        public Boolean getContentAvailable() {
            return contentAvailable;
        }

        public void setContentAvailable(Boolean contentAvailable) {
            this.contentAvailable = contentAvailable;
        }

        public Boolean getMutableContent() {
            return mutableContent;
        }

        public void setMutableContent(Boolean mutableContent) {
            this.mutableContent = mutableContent;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public Map<String, Object> getExtras() {
            return extras;
        }

        public void setExtras(Map<String, Object> extras) {
            this.extras = extras;
        }
    }

    private static class WinPhone {
        private String alert;
        private String title;
        @SerializedName(value = "_open_page", alternate = "openPage")
        private String openPage;
        private Map<String, Object> extras;

        public String getAlert() {
            return alert;
        }

        public void setAlert(String alert) {
            this.alert = alert;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getOpenPage() {
            return openPage;
        }

        public void setOpenPage(String openPage) {
            this.openPage = openPage;
        }

        public Map<String, Object> getExtras() {
            return extras;
        }

        public void setExtras(Map<String, Object> extras) {
            this.extras = extras;
        }
    }

    private static class Message {
        @SerializedName(value = "msg_content", alternate = "msgContent")
        private String msgContent;
        private String title;
        @SerializedName(value = "content_type", alternate = "contentType")
        private String contentType;
        Map<String, Object> extras;

        public String getMsgContent() {
            return msgContent;
        }

        public void setMsgContent(String msgContent) {
            this.msgContent = msgContent;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContentType() {
            return contentType;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
        }

        public Map<String, Object> getExtras() {
            return extras;
        }

        public void setExtras(Map<String, Object> extras) {
            this.extras = extras;
        }
    }

    private static class SmsMessage {
        private String content;
        @SerializedName(value = "delay_time", alternate = "delayTime")
        private Integer delayTime;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Integer getDelayTime() {
            return delayTime;
        }

        public void setDelayTime(Integer delayTime) {
            this.delayTime = delayTime;
        }
    }

    private static class Options {
        private Integer sendno;
        @SerializedName(value = "time_to_live", alternate = "timeToLive")
        private Integer timeToLive;
        @SerializedName(value = "override_msg_id", alternate = "overrideMsgId")
        private Long overrideMsgId;
        @SerializedName(value = "apns_production", alternate = "apnsProduction")
        private Boolean apnsProduction;
        @SerializedName(value = "apns_collapse_id", alternate = "apnsCollapseId")
        private String apnsCollapseId;
        @SerializedName(value = "big_push_duration", alternate = "bigPushDuration")
        private Integer bigPushDuration;

        public Integer getSendno() {
            return sendno;
        }

        public void setSendno(Integer sendno) {
            this.sendno = sendno;
        }

        public Integer getTimeToLive() {
            return timeToLive;
        }

        public void setTimeToLive(Integer timeToLive) {
            this.timeToLive = timeToLive;
        }

        public Long getOverrideMsgId() {
            return overrideMsgId;
        }

        public void setOverrideMsgId(Long overrideMsgId) {
            this.overrideMsgId = overrideMsgId;
        }

        public Boolean getApnsProduction() {
            return apnsProduction;
        }

        public void setApnsProduction(Boolean apnsProduction) {
            this.apnsProduction = apnsProduction;
        }

        public String getApnsCollapseId() {
            return apnsCollapseId;
        }

        public void setApnsCollapseId(String apnsCollapseId) {
            this.apnsCollapseId = apnsCollapseId;
        }

        public Integer getBigPushDuration() {
            return bigPushDuration;
        }

        public void setBigPushDuration(Integer bigPushDuration) {
            this.bigPushDuration = bigPushDuration;
        }
    }
}
