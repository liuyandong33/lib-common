package build.dream.common.annotations;

import build.dream.common.notify.AlipayAsyncNotifyType;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AlipayAsyncNotify {
    AlipayAsyncNotifyType type();

    String uuidFieldName();
}
