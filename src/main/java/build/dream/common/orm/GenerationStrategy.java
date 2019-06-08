package build.dream.common.orm;

public enum GenerationStrategy {
    /**
     * 自增主键
     */
    AUTO_INCREMENT,

    /**
     * 利用生成器生成主键
     */
    GENERATOR,

    /**
     * 利用mycat 全局序列生成主键
     */
    MYCATSEQ_GLOBAL
}
