package api.mall.web.controller;

import lombok.Data;

@Data
public class MemberForm {

    private String userId;

    private String password;

    private String name;
}
