package build.dream.common.models.jddj;

import javax.validation.constraints.NotNull;

public class UpdateSkuModel extends JDDJBasicModel {
    /**
     * 请求唯一编码
     */
    @NotNull
    private String traceId;

    /**
     * 商家skuId编码（商家skuId）
     */
    @NotNull
    private String outSkuId;
}
