DROP TABLE IF EXISTS cluster;
CREATE TABLE cluster
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    tenant_id BIGINT NOT NULL COMMENT '商户ID',
    `name` VARCHAR(20) NOT NULL COMMENT '集群名称',
    `type` TINYINT NOT NULL COMMENT '集群类型，1-zookeeper 集群',
    created_time DATETIME DEFAULT NOW() NOT NULL COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '集群表';

DROP TABLE IF EXISTS zookeeper_node;
CREATE TABLE zookeeper_node
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    cluster_id BIGINT NOT NULL COMMENT '集群ID',
    host_name VARCHAR(20) NOT NULL COMMENT '主机名称',
    ip_address VARCHAR(20) NOT NULL COMMENT 'ip 地址',
    ssh_port INT NOT NULL COMMENT 'ssh 连接端口号',
    user_name VARCHAR(20) NOT NULL COMMENT '用户名',
    `password` VARCHAR(20) NOT NULL COMMENT '密码',
    zookeeper_home VARCHAR(255) NOT NULL COMMENT 'zookeeper 主目录',
    created_time DATETIME DEFAULT NOW() NOT NULL COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT 'zookeeper 节点';

DROP TABLE IF EXISTS kafka_node;
CREATE TABLE kafka_node
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    cluster_id BIGINT NOT NULL COMMENT '集群ID',
    host_name VARCHAR(20) NOT NULL COMMENT '主机名称',
    ip_address VARCHAR(20) NOT NULL COMMENT 'ip 地址',
    ssh_port INT NOT NULL COMMENT 'ssh 连接端口号',
    user_name VARCHAR(20) NOT NULL COMMENT '用户名',
    `password` VARCHAR(20) NOT NULL COMMENT '密码',
    kafka_home VARCHAR(255) NOT NULL COMMENT 'zookeeper 主目录',
    created_time DATETIME DEFAULT NOW() NOT NULL COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT 'kafka 节点';

DROP TABLE IF EXISTS `host`;
CREATE TABLE `host`
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    `type` INT NOT NULL COMMENT '主机类型，1-物理机，2-虚拟机',
    parent_id BIGINT NOT NULL COMMENT '宿主机id',
    `name` VARCHAR(20) NOT NULL COMMENT '主机名称',
    ip_address VARCHAR(20) NOT NULL COMMENT 'ip 地址',
    ssh_port INT NOT NULL COMMENT 'ssh 连接端口号',
    user_name VARCHAR(20) NOT NULL COMMENT '用户名',
    `password` VARCHAR(20) NOT NULL COMMENT '密码',
    disk_size INT NOT NULL COMMENT '硬盘大小，单位GB',
    cpu_core_quantity INT NOT NULL COMMENT 'CPU 核心数量',
    memory_size BIGINT NOT NULL COMMENT '内存大小，单位B',
    status TINYINT NOT NULL COMMENT '状态，1-运行中，2-已停止',
    created_time DATETIME DEFAULT NOW() NOT NULL COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '主机';

DROP TABLE IF EXISTS my_sql_configuration;
CREATE TABLE my_sql_configuration
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    `name` VARCHAR(200) NOT NULL COMMENT '名称',
    `value` VARCHAR(200) NOT NULL COMMENT '值',
    `type` VARCHAR(20) NOT NULL COMMENT 'mysqld, client',
    remark VARCHAR(255) NOT NULL COMMENT '备注',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT 'mysql 配置';

DROP TABLE IF EXISTS network_configuration;
CREATE TABLE network_configuration
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    `name` VARCHAR(50) NOT NULL COMMENT '配置名称',
    `value` VARCHAR(50) NOT NULL COMMENT '配置值',
    `comment` VARCHAR(255) NOT NULL COMMENT '注释',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建用户id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新user id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-为删除，1-已删除'
) COMMENT '饿了么回调信息';

DROP TABLE IF EXISTS server;
CREATE TABLE server
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    host_name VARCHAR(20) NOT NULL COMMENT '主机名称',
    ip_address VARCHAR(20) NOT NULL COMMENT 'ip 地址',
    ssh_port INT NOT NULL COMMENT 'ssh 连接端口号',
    user_name VARCHAR(20) NOT NULL COMMENT '用户名',
    `password` VARCHAR(20) NOT NULL COMMENT '密码',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '服务器';

DROP TABLE IF EXISTS java_option;
CREATE TABLE java_option
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    service_id BIGINT NOT NULL COMMENT '服务ID',
    xms VARCHAR(20) NOT NULL COMMENT 'JVM启动时申请的初始Heap值，默认为操作系统物理内存的1/64但小于1G。默认当空余堆内存大于70%时，JVM会减小heap的大小到-Xms指定的大小，可通过-XX:MaxHeapFreeRation=来指定这个比列。Server端JVM最好将-Xms和-Xmx设为相同值，避免每次垃圾回收完成后JVM重新分配内存；开发测试机JVM可以保留默认值。(例如：-Xms4g)',
    xmx VARCHAR(20) NOT NULL COMMENT 'JVM可申请的最大Heap值，默认值为物理内存的1/4但小于1G，默认当空余堆内存小于40%时，JVM会增大Heap到-Xmx指定的大小，可通过-XX:MinHeapFreeRation=来指定这个比列。最佳设值应该视物理内存大小及计算机内其他内存开销而定。(例如：-Xmx4g)',
    xmn VARCHAR(20) NOT NULL COMMENT 'Java Heap Young区大小。整个堆大小=年轻代大小 + 年老代大小 + 持久代大小(相对于HotSpot 类型的虚拟机来说)。持久代一般固定大小为64m，所以增大年轻代后，将会减小年老代大小。此值对系统性能影响较大，Sun官方推荐配置为整个堆的3/8。(例如：-Xmn2g)',
    xss VARCHAR(20) NOT NULL COMMENT 'Java每个线程的Stack大小。JDK5.0以后每个线程堆栈大小为1M，以前每个线程堆栈大小为256K。根据应用的线程所需内存大小进行调整。在相同物理内存下，减小这个值能生成更多的线程。但是操作系统对一个进程内的线程数还是有限制的，不能无限生成，经验值在3000~5000左右。(例如：-Xss1024K)',
    xx_perm_size VARCHAR(20) NOT NULL COMMENT '持久代（方法区）的初始内存大小。（例如：-XX:PermSize=64m）',
    xx_max_perm_size VARCHAR(20) NOT NULL COMMENT '持久代（方法区）的最大内存大小。（例如：-XX:MaxPermSize=512m）',
    xx_use_serial_gc TINYINT NOT NULL COMMENT '串行（SerialGC）是jvm的默认GC方式，一般适用于小型应用和单处理器，算法比较简单，GC效率也较高，但可能会给应用带来停顿。',
    xx_use_parallel_gc TINYINT NOT NULL COMMENT '并行（ParallelGC）是指多个线程并行执行GC，一般适用于多处理器系统中，可以提高GC的效率，但算法复杂，系统消耗较大。（配合使用：-XX:ParallelGCThreads=8，并行收集器的线程数，此值最好配置与处理器数目相等）',
    xx_parallel_gc_threads VARCHAR(20) NOT NULL COMMENT '并行收集器的线程数，此值最好配置与处理器数目相等',
    xx_use_par_new_gc TINYINT NOT NULL COMMENT '设置年轻代为并行收集，JKD5.0以上，JVM会根据系统配置自行设置，所以无需设置此值。',
    xx_use_parallel_old_gc TINYINT NOT NULL COMMENT '设置年老代为并行收集，JKD6.0出现的参数选项。',
    xx_use_conc_mark_sweep_gc TINYINT NOT NULL COMMENT '并发（ConcMarkSweepGC）是指GC运行时，对应用程序运行几乎没有影响（也会造成停顿，不过很小而已），GC和app两者的线程在并发执行，这样可以最大限度不影响app的运行。',
    xx_use_cms_compact_at_full_collection TINYINT NOT NULL COMMENT '在Full GC的时候，对老年代进行压缩整理。因为CMS是不会移动内存的，因此非常容易产生内存碎片。因此增加这个参数就可以在FullGC后对内存进行压缩整理，消除内存碎片。当然这个操作也有一定缺点，就是会增加CPU开销与GC时间，所以可以通过-XX:CMSFullGCsBeforeCompaction=3 这个参数来控制多少次Full GC以后进行一次碎片整理。',
    xx_cms_initiating_occupancy_fraction VARCHAR(20) NOT NULL COMMENT '代表老年代使用空间达到80%后，就进行Full GC。CMS收集器在进行垃圾收集时，和应用程序一起工作，所以，不能等到老年代几乎完全被填满了再进行收集，这样会影响并发的应用线程的空间使用，从而再次触发不必要的Full GC。',
    xx_max_tenuring_threshold VARCHAR(20) NOT NULL COMMENT '垃圾的最大年龄，代表对象在Survivor区经过10次复制以后才进入老年代。如果设置为0，则年轻代对象不经过Survivor区，直接进入老年代。',
    xx_max_heap_free_ration VARCHAR(20) NOT NULL COMMENT '',
    xx_min_heap_free_ration VARCHAR(20) NOT NULL COMMENT '',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT = 'JVM内存参数';

DROP TABLE IF EXISTS app;
CREATE TABLE app
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    name VARCHAR(50) NOT NULL COMMENT '应用名称',
    description VARCHAR(50) NOT NULL COMMENT '应用描述',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '应用表';

DROP TABLE IF EXISTS service;
CREATE TABLE service
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    app_id BIGINT NOT NULL COMMENT '应用ID',
    name VARCHAR(50) NOT NULL COMMENT '应用名称',
    program_name VARCHAR(50) NOT NULL COMMENT '程序名称',
    program_version VARCHAR(50) NOT NULL COMMENT '程序版本',
    health_check_path VARCHAR(255) NOT NULL COMMENT '健康检查路径',
    partitioned TINYINT NOT NULL COMMENT '是否分区',
    deployment_environment VARCHAR(255) NOT NULL COMMENT '部署环境，development-开发环境, test-测试环境, beta-beta环境, production-生成环境',
    partition_code VARCHAR(20) NOT NULL COMMENT '分区码',
    service_name VARCHAR(255) NOT NULL COMMENT '服务名称',
    zookeeper_connect_string VARCHAR(255) NOT NULL COMMENT 'zookeeper 连接字符串',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '服务表';

DROP TABLE IF EXISTS service_node;
CREATE TABLE service_node
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    service_id BIGINT NOT NULL COMMENT '服务id',
    host_id BIGINT NOT NULL COMMENT '主机ID',
    port INT NOT NULL COMMENT '端口号',
    status TINYINT NOT NULL COMMENT '状态，1-运行中，2-已停止',
    pid VARCHAR(20) NOT NULL COMMENT '进程ID',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '服务节点表';

DROP TABLE IF EXISTS snowflake_id_configuration;
CREATE TABLE snowflake_id_configuration
(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    worker_id INT NOT NULL COMMENT 'work id',
    data_center_id INT NOT NULL COMMENT 'data center id',
    ip_address VARCHAR(50) NOT NULL COMMENT 'IP地址',
    application_name VARCHAR(50) NOT NULL COMMENT '应用名称',
    created_time DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
    created_user_id BIGINT NOT NULL COMMENT '创建人id',
    updated_time DATETIME NOT NULL DEFAULT NOW() ON UPDATE NOW() COMMENT '最后更新时间',
    updated_user_id BIGINT NOT NULL COMMENT '最后更新人id',
    updated_remark VARCHAR(255) NOT NULL COMMENT '最后更新备注',
    deleted_time DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '删除时间，只有当 deleted = 1 时有意义，默认值为1970-01-01 00:00:00',
    deleted TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除，0-未删除，1-已删除'
) COMMENT '雪花ID配置';