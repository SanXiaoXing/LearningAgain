package cn.sanxiaoxing.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * @Author: SanXiaoXing
 * @Date: 2024/04/06/21:34
 * @Description: Filter拦截测试
 */

@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {
    @Override //初始化方法，只调用一次
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override //拦截方法，每次请求都会调用
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截到了请求");
        //放行
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override //销毁方法，只调用一次
    public void destroy() {
        Filter.super.destroy();
    }
}
