package api.mall.web.login;

public enum SessionConst {

    LOGIN_MEMBER("loginMember");

    private String loginMember;

    public String getLoginMember() {
        return this.loginMember;
    }

    SessionConst(String loginMember) {
        this.loginMember = loginMember;
    }
}
