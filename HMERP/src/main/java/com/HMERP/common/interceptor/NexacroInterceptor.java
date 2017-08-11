package com.HMERP.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.nexacro.xapi.data.PlatformData;
import com.nexacro.xapi.data.VariableList;
import com.nexacro.xapi.tx.HttpPlatformRequest;
import com.nexacro.xapi.tx.HttpPlatformResponse;
import com.nexacro.xapi.tx.PlatformType;
import com.seoul.his.common.util.NexacroLogger;


/**
 * @Package  com.seoul.his.common.interceptor
 * @Class    NexacroInterceptor.java
 * @Create   2016. 5. 22.
 * @Author   임행섭
 * @Description 넥사크로 PlatformData 처리 인터셉터 클래스
 *
 * @LastUpdated 
 *      Argument를 맵에 담는 코드 수정 : 2016. 5. 24. by 임행섭
 */

public class NexacroInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpPlatformRequest httpPlatformRequest = new HttpPlatformRequest(request);
        httpPlatformRequest.receiveData();

        PlatformData inData = httpPlatformRequest.getData();
        PlatformData outData = new PlatformData();

        request.setAttribute("inData", inData);
        request.setAttribute("outData", outData);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception exception) throws Exception {
        PlatformData outData = (PlatformData) request.getAttribute("outData");
        VariableList variableList = outData.getVariableList();

        if (exception != null) {
            exception.printStackTrace();
            variableList.add("ErrorCode", 0);
            variableList.add("ErrorMsg", "Transaction Failed");
        } else {
            variableList.add("ErrorCode", 1);
            variableList.add("ErrorMsg", "Transaction Success");
        }

        HttpPlatformResponse httpPlatformResponse = new HttpPlatformResponse(response, PlatformType.CONTENT_TYPE_XML, "UTF-8");
        //outData.setVariableList(variableList);
        httpPlatformResponse.setData(outData);
        NexacroLogger.debug(outData);

        httpPlatformResponse.sendData();
        outData = null;
        super.afterCompletion(request, response, handler, exception);
    }
}
