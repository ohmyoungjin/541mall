package api.mall.web.interceptor;

import api.mall.web.jwt.AuthorizationExtractor;
import api.mall.web.jwt.JwtTokenProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
public class BearerAuthInterceptor implements HandlerInterceptor {


    private AuthorizationExtractor authorizationExtractor;
    private JwtTokenProvider jwoTokenProvider;
}
