package com.HMERP.common.to;

import com.google.gson.Gson;

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
public class MessageBean {
    private String message;
    private String type;
    private String to;
    
    
    
    public static MessageBean convertMessage( String source ) {
    	MessageBean message = new MessageBean();
        Gson gson = new Gson();
        // 사용자가 보낸 json 타입의 정보를 자바 객체에 넣어준다.
        message = gson.fromJson(source, MessageBean.class);
         
        return message;
    }
    
    
    
}
