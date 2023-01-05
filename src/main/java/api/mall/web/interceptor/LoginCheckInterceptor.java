package api.mall.web.interceptor;

import api.mall.web.login.SessionConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();



        HttpSession session = request.getSession();

        log.info("preHandle 인증 체크 인터셉터 실행 [{}][{}]", requestURI, session);

        if (session == null || session.getAttribute(SessionConst.LOGIN_MEMBER.getLoginMember()) == null) {
            log.info("preHandle 미인증 사용자 요청");
            //로그인으로 redirect
            response.sendRedirect("/login?redirectURL=" + requestURI);
            //더 이상 진행하지 않도록 return
            return false;
        }
        return true;
    }
}
