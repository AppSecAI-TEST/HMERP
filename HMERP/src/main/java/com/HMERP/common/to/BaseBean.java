package com.HMERP.common.to;

import lombok.Getter;
import lombok.Setter;

/**
 * @Package  com.erp46.his.common.to
 * @Class    BaseBean.java
 * @Create   2016. 5. 22.
 * @Author   godseop
 * @Description 모든 TO(Transfer Object)의 부모, 상태값과 에러코드, 에러메세지를 저장한다
 */
@Getter
@Setter
public class BaseBean {
    private String status = "normal";
    private String errorCode;
    private String errorMsg;
}
