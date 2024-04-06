package cn.sanxiaoxing.interceptor;

import cn.sanxiaoxing.dao.Result;
import cn.sanxiaoxing.utils.JwtUtils;
import com.alibaba.fastjson.JSONObject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: SanXiaoXing
 * @Date: 2024/04/06/22:23
 * @Description:
 */
@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 获取请求路径url
        String url = request.getRequestURI().toString();
        log.info("请求的url：{}", url);

        // 判断请求的url是否包含login，如果包含，说明是登录操作，放行
        if (url.contains("login")) {
            log.info("登录操作，放行。。。");
            return true;
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
            return false;
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
            return false;
        }

        //放行
        log.info("令牌放行");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
