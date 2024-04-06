package cn.sanxiaoxing.filter;

import cn.sanxiaoxing.dao.Result;
import cn.sanxiaoxing.utils.JwtUtils;
import com.alibaba.fastjson.JSONObject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * @Author: SanXiaoXing
 * @Date: 2024/04/06/21:52
 * @Description: 拦截器
 */
@Slf4j
@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 获取请求路径url
        String url = request.getRequestURI();
        log.info("请求的url：{}", url);

        // 判断请求的url是否包含login，如果包含，说明是登录操作，放行
        if (url.contains("login")) {
            log.info("登录操作，放行。。。");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        // 获取请求头中的令牌（token）
        String jwt = request.getHeader("token");

        // 判断令牌是否存在，如果不存在，返回错误结果(未登录)
        if( !StringUtils.hasLength(jwt) ){
            log.info("请求头token为空，返回未登录的信息");
            Result error = Result.error("NOT_LOGIN");

            // 手动转换对象中的json -----------> 阿里巴巴fastjson
            String noLogin = JSONObject.toJSONString(error);
            response.getWriter().write(noLogin);
            return;
        }

        // 解析token，如果解析失败，返回错误信息（未登录）
        try {
            JwtUtils.parseJwt(jwt);
        } catch (Exception e) { // jwt 解析失败
            e.printStackTrace();
            log.info("解析令牌失败，返回未登录的信息");
            Result error = Result.error("NOT_LOGIN");

            // 手动转换对象中的json -----------> 阿里巴巴fastjson
            String noLogin = JSONObject.toJSONString(error);
            response.getWriter().write(noLogin);
            return;
        }

        //放行
        log.info("令牌放行");
        filterChain.doFilter(servletRequest, servletResponse);

    }
}
