package com.HMERP.common.to;

import com.google.gson.Gson;

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
public class MessageBean {
    private String message;
    private String type;
    private String to;
    
    
    
    public static MessageBean convertMessage( String source ) {
    	MessageBean message = new MessageBean();
        Gson gson = new Gson();
        // ����ڰ� ���� json Ÿ���� ������ �ڹ� ��ü�� �־��ش�.
        message = gson.fromJson(source, MessageBean.class);
         
        return message;
    }
    
    
    
}
