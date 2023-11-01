package br.com.lojavinho.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/cliente/*")
public class AuthenticationClienteFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Método de inicialização do filtro (geralmente vazio).
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Método principal do filtro, aqui a lógica de autenticação é aplicada
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        if (isUserLoggedOnClient(httpServletRequest)) {
            // Se o usuário estiver autenticado, continua a cadeia de filtros
            chain.doFilter(servletRequest, response);

        } else {
            // Se o usuário não estiver autenticado, redireciona para a página de entrarCliente.jsp
            servletRequest.setAttribute("message", "user not authenticated!");

            servletRequest.getRequestDispatcher("/entrarCliente.jsp").forward(httpServletRequest, response);

        }
    }

    @Override
    public void destroy() {
        // Método chamado quando o filtro é destruído (geralmente vazio).
    }

    private boolean isUserLoggedOnClient(HttpServletRequest httpServletRequest) {
        // Verifica se o usuário está autenticado com base na presença de um atributo na sessão
        return httpServletRequest.getSession().getAttribute("logadoUsuarioCliente") != null;
    }
}