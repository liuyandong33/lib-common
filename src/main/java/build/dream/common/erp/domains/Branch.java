package build.dream.common.erp.domains;

import java.math.BigInteger;
import java.util.Date;

public class Branch {
    private BigInteger id;
    private String code;
    private String name;
    private Integer type;
    private Integer status;
    private Date createTime;
    private BigInteger createUserId;
    private Date lastUpdateTime;
    private BigInteger lastUpdateUserId;
    private boolean deleted;
}
