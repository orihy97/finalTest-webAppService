package com.mvc.common.filter;

import com.mvc.common.config.ConfigLocation;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class ContextConfigFilter implements Filter {

    public ContextConfigFilter() {
    }

    public void destroy() {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        /* DB 접속 설정 정보 파일의 경로 정보가 비어있는 경우 초기화 해준다. */
        if(ConfigLocation.CONNECTION_CONFIG_LOCATION == null) {
            String root = request.getServletContext().getRealPath("/");
            String connectionInfoPath = request.getServletContext().getInitParameter("connection-info");

            System.out.println("DB접속경로 설정 완료");
            ConfigLocation.CONNECTION_CONFIG_LOCATION = root + "/" + connectionInfoPath;
        }

        if(ConfigLocation.MAPPER_LOCATION == null) {
            String root = request.getServletContext().getRealPath("/");
            String mapperLocation = request.getServletContext().getInitParameter("mapper-location");

            System.out.println("매퍼 경로 설정 완료");
            ConfigLocation.MAPPER_LOCATION = root + "/" + mapperLocation;
        }

        /* 경로를 static에 저장하면 템플릿에서도 사용이 가능하다. */
        chain.doFilter(request, response);
    }

    public void init(FilterConfig fConfig) throws ServletException {

    }

}
