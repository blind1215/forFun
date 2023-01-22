package com.example.filter.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/api/user/*")
public class GlobalFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //전처리 (httpRequest or httpresponse를 사용하면 이미 읽고 controller로 넘겨줄 데이터가 없어짐
        //그래서 현재 ContentCachingRequestWrapper,ContentCachingResponseWrapper 를 사용함
        ContentCachingRequestWrapper httpServletRequest = new ContentCachingRequestWrapper((HttpServletRequest)request);
        ContentCachingResponseWrapper httpServletResponse = new ContentCachingResponseWrapper((HttpServletResponse)response);



        chain.doFilter(httpServletRequest,httpServletResponse);

        String url = httpServletRequest.getRequestURI();
        //후처리
        //req
        String reqContent = new String(httpServletRequest.getContentAsByteArray());

        log.info("request url : {}, requestBody : {}" ,url,reqContent);

        String resContent = new String(httpServletResponse.getContentAsByteArray());
        int httpStatus = httpServletResponse.getStatus();

        //위에서 비어졌기때문에 꼭 마지막에 copyBodyToresponse 해줘야함
        httpServletResponse.copyBodyToResponse();
        log.info("response status : {}, responseBody : {} ",httpStatus , resContent);

    }
}
