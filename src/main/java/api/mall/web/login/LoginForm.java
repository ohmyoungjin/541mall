package api.mall.web.login;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginForm {

    private String loginId;

    private String password;

}
