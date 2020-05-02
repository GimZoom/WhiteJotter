package com.zio.wj.config;

import com.alibaba.fastjson.JSON;
import com.zio.wj.utils.ResultVOUtil;
import com.zio.wj.vo.ResultVO;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class CustomizedLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        ResultVO resultVO = ResultVOUtil.success();
        PrintWriter writer = httpServletResponse.getWriter();
        String resultString = JSON.toJSONString(resultVO);
        writer.write(resultString);
        writer.flush();
        writer.close();
    }
}
