package br.com.lojavinho.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/cliente/*")
public class AuthenticationClienteFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        if (isUserLoggedOnClient(httpServletRequest)) {

            chain.doFilter(servletRequest, response);

        } else {

            servletRequest.setAttribute("message", "user not authenticated!");

            servletRequest.getRequestDispatcher("/senhaCliente.jsp").forward(httpServletRequest, response);

        }
    }

    @Override
    public void destroy() {

    }

    private boolean isUserLoggedOnClient(HttpServletRequest httpServletRequest) {

        return httpServletRequest.getSession().getAttribute("logadoUsuarioCliente") != null;
    }
}