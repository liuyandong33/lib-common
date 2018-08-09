package build.dream.common.models.weixin;

import build.dream.common.constants.Constants;
import build.dream.common.constraints.InList;
import build.dream.common.models.BasicModel;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.collections.CollectionUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

public class AdvancedInfoModel extends BasicModel {
    @SerializedName(value = "use_condition", alternate = "useCondition")
    private UseCondition useCondition;

    @SerializedName(value = "abstract", alternate = "abstractInfo")
    private AbstractInfo abstractInfo;

    @SerializedName(value = "text_image_list", alternate = "textImageList")
    private List<TextImage> textImageList;

    @SerializedName(value = "business_service", alternate = "businessService")
    private List<String> businessService;

    @SerializedName(value = "time_limit", alternate = "timeLimits")
    private List<TimeLimit> timeLimits;

    public UseCondition getUseCondition() {
        return useCondition;
    }

    public void setUseCondition(UseCondition useCondition) {
        this.useCondition = useCondition;
    }

    public AbstractInfo getAbstractInfo() {
        return abstractInfo;
    }

    public void setAbstractInfo(AbstractInfo abstractInfo) {
        this.abstractInfo = abstractInfo;
    }

    public List<TextImage> getTextImageList() {
        return textImageList;
    }

    public void setTextImageList(List<TextImage> textImageList) {
        this.textImageList = textImageList;
    }

    public List<String> getBusinessService() {
        return businessService;
    }

    public void setBusinessService(List<String> businessService) {
        this.businessService = businessService;
    }

    public List<TimeLimit> getTimeLimits() {
        return timeLimits;
    }

    public void setTimeLimits(List<TimeLimit> timeLimits) {
        this.timeLimits = timeLimits;
    }

    @Override
    public void validateAndThrow() {
        super.validateAndThrow();
        if (useCondition != null) {
            useCondition.validateAndThrow();
        }
        if (abstractInfo != null) {
            abstractInfo.validateAndThrow();
        }
        if (CollectionUtils.isNotEmpty(textImageList)) {
            for (TextImage textImage : textImageList) {
                textImage.validateAndThrow();
            }
        }
        if (CollectionUtils.isNotEmpty(timeLimits)) {
            for (TimeLimit timeLimit : timeLimits) {
                timeLimit.validateAndThrow();
            }
        }
    }

    public static class UseCondition extends BasicModel {
        @Length(max = 512)
        @SerializedName(value = "accept_category", alternate = "acceptCategory")
        private String acceptCategory;

        @Length(max = 512)
        @SerializedName(value = "reject_category", alternate = "rejectCategory")
        private String rejectCategory;

        @SerializedName(value = "least_cost", alternate = "leastCost")
        private Integer leastCost;

        @Length(max = 512)
        @SerializedName(value = "object_use_for", alternate = "objectUseFor")
        private String objectUseFor;

        @SerializedName(value = "can_use_with_other_discount", alternate = "canUseWithOtherDiscount")
        private Boolean canUseWithOtherDiscount;

        public String getAcceptCategory() {
            return acceptCategory;
        }

        public void setAcceptCategory(String acceptCategory) {
            this.acceptCategory = acceptCategory;
        }

        public String getRejectCategory() {
            return rejectCategory;
        }

        public void setRejectCategory(String rejectCategory) {
            this.rejectCategory = rejectCategory;
        }

        public Integer getLeastCost() {
            return leastCost;
        }

        public void setLeastCost(Integer leastCost) {
            this.leastCost = leastCost;
        }

        public String getObjectUseFor() {
            return objectUseFor;
        }

        public void setObjectUseFor(String objectUseFor) {
            this.objectUseFor = objectUseFor;
        }

        public Boolean getCanUseWithOtherDiscount() {
            return canUseWithOtherDiscount;
        }

        public void setCanUseWithOtherDiscount(Boolean canUseWithOtherDiscount) {
            this.canUseWithOtherDiscount = canUseWithOtherDiscount;
        }
    }

    public static class AbstractInfo extends BasicModel {
        @Length(max = 24)
        @SerializedName(value = "abstract")
        private String abstractInfo;

        @Length(max = 128)
        @SerializedName(value = "icon_url_list", alternate = "iconUrlList")
        private String iconUrlList;

        public String getAbstractInfo() {
            return abstractInfo;
        }

        public void setAbstractInfo(String abstractInfo) {
            this.abstractInfo = abstractInfo;
        }

        public String getIconUrlList() {
            return iconUrlList;
        }

        public void setIconUrlList(String iconUrlList) {
            this.iconUrlList = iconUrlList;
        }
    }

    public static class TextImage extends BasicModel {
        @Length(max = 128)
        @SerializedName(value = "image_url", alternate = "imageUrl")
        private String imageUrl;

        @Length(max = 512)
        private String text;

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    public static class TimeLimit extends BasicModel {
        @InList(value = {Constants.MONDAY, Constants.TUESDAY, Constants.WEDNESDAY, Constants.THURSDAY, Constants.FRIDAY, Constants.SATURDAY, Constants.SUNDAY})
        private String type;

        @Min(value = 0)
        @Max(value = 23)
        @SerializedName(value = "begin_hour", alternate = "beginHour")
        private Integer beginHour;

        @Min(value = 0)
        @Max(value = 59)
        @SerializedName(value = "begin_minute", alternate = "beginMinute")
        private Integer beginMinute;

        @Min(value = 0)
        @Max(value = 23)
        @SerializedName(value = "end_hour", alternate = "endHour")
        private Integer endHour;

        @Min(value = 0)
        @Max(value = 59)
        @SerializedName(value = "end_minute", alternate = "endMinute")
        private Integer endMinute;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Integer getBeginHour() {
            return beginHour;
        }

        public void setBeginHour(Integer beginHour) {
            this.beginHour = beginHour;
        }

        public Integer getBeginMinute() {
            return beginMinute;
        }

        public void setBeginMinute(Integer beginMinute) {
            this.beginMinute = beginMinute;
        }

        public Integer getEndHour() {
            return endHour;
        }

        public void setEndHour(Integer endHour) {
            this.endHour = endHour;
        }

        public Integer getEndMinute() {
            return endMinute;
        }

        public void setEndMinute(Integer endMinute) {
            this.endMinute = endMinute;
        }
    }
}
