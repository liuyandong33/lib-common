package build.dream.common.models.weixin;

import build.dream.common.models.BasicModel;

import java.util.Map;

public class SendTemplateMessageModel extends BasicModel {
    private String openId;
    private String templateId;
    private String url;
    private Map<String, Object> miniProgram;
    private Map<String, Object> data;
    private String color;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, Object> getMiniProgram() {
        return miniProgram;
    }

    public void setMiniProgram(Map<String, Object> miniProgram) {
        this.miniProgram = miniProgram;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
