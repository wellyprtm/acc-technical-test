package id.co.acc.domain.securities;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.co.acc.domain.base.dtos.ApiResponse;
import id.co.acc.domain.exceptions.AuthorizationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RequestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException, AuthorizationException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;

        String contentTypeOptions = servletRequest.getHeader("X-Content-Type-Options");
        boolean isAuthorized = true;
        if (ObjectUtils.isEmpty(contentTypeOptions) || !contentTypeOptions.equals("nosniff")) {
            isAuthorized = false;
        }

        String xssProtection = servletRequest.getHeader("X-XSS-Protection");

        if (ObjectUtils.isEmpty(xssProtection) || !xssProtection.equals("1;mode=block")) {
            isAuthorized = false;
        }

        String strictTransportSecurity = servletRequest.getHeader("Strict-Transport-Security");

        if (ObjectUtils.isEmpty(strictTransportSecurity) || !strictTransportSecurity.equals("max-age=31536000; includeSubDomains; preload")) {
            isAuthorized = false;
        }

        String xFrameOptions = servletRequest.getHeader("X-Frame-Options");
        if (ObjectUtils.isEmpty(xFrameOptions) || !xFrameOptions.equals("SAMEORIGIN")) {
            isAuthorized = false;
        }

        if (isAuthorized) {
            chain.doFilter(request, response);
        } else {
            servletResponse.setStatus(HttpStatus.OK.value());
            servletResponse.setHeader(HttpHeaders.CONTENT_TYPE, "application/json;charset=UTF-8");
            writeErrorResponse(servletResponse, ApiResponse.error("F", "You do not have permission to access the API!"));
        }
    }

    private void writeErrorResponse(final HttpServletResponse response, final ApiResponse responseObj)
            throws IOException {
        final ObjectMapper mapper = new ObjectMapper();

        response.getWriter().write(mapper.writeValueAsString(responseObj));
        response.getWriter().close();
    }
}
