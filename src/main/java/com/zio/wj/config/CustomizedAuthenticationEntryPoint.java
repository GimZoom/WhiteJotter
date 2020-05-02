package com.zio.wj.config;

import com.alibaba.fastjson.JSON;
import com.zio.wj.enums.ResultCode;
import com.zio.wj.utils.ResultVOUtil;
import com.zio.wj.vo.ResultVO;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class CustomizedAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        ResultVO resultVO = ResultVOUtil.fail(ResultCode.USER_NOT_LOGIN);
        PrintWriter writer = response.getWriter();
        writer.write(JSON.toJSONString(resultVO));
        writer.flush();
        writer.close();
    }
}
