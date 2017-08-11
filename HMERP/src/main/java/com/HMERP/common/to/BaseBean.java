package com.HMERP.common.to;

import lombok.Getter;
import lombok.Setter;

/**
 * @Package  com.erp46.his.common.to
 * @Class    BaseBean.java
 * @Create   2016. 5. 22.
 * @Author   godseop
 * @Description ��� TO(Transfer Object)�� �θ�, ���°��� �����ڵ�, �����޼����� �����Ѵ�
 */
@Getter
@Setter
public class BaseBean {
    private String status = "normal";
    private String errorCode;
    private String errorMsg;
}
