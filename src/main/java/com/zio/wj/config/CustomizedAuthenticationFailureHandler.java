package com.zio.wj.config;

import com.alibaba.fastjson.JSON;
import com.zio.wj.enums.ResultCode;
import com.zio.wj.utils.ResultVOUtil;
import com.zio.wj.vo.ResultVO;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class CustomizedAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        System.out.println("failure");
        ResultVO respBean = null;
        if (e instanceof BadCredentialsException) {
            respBean = ResultVOUtil.fail(ResultCode.USER_CREDENTIALS_ERROR);
        } else if (e instanceof UsernameNotFoundException) {
            respBean = ResultVOUtil.fail(ResultCode.USER_ACCOUNT_NOT_EXIST);
        } else if (e instanceof LockedException) {
            respBean = ResultVOUtil.fail(ResultCode.USER_ACCOUNT_LOCKED);
        } else if (e instanceof CredentialsExpiredException) {
            respBean = ResultVOUtil.fail(ResultCode.USER_CREDENTIALS_EXPIRED);
        } else if (e instanceof AccountExpiredException) {
            respBean = ResultVOUtil.fail(ResultCode.USER_ACCOUNT_EXPIRED);
        } else if (e instanceof DisabledException) {
            respBean = ResultVOUtil.fail(ResultCode.USER_ACCOUNT_DISABLE);
        } else {
            respBean = ResultVOUtil.fail(ResultCode.COMMON_FAIL);
        }
        String resultString = JSON.toJSONString(respBean);
        PrintWriter writer = httpServletResponse.getWriter();
        writer.write(resultString);
        writer.flush();
        writer.close();
    }
}
