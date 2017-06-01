package com.zw.entity;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/5/31.
 */
public class LoginUserVo {
    private static HashMap<String, UserVo> loginUserMap = new HashMap<String, UserVo>();
    private static LoginUserVo loginUserVo;

    public static LoginUserVo getVo(){

        if(loginUserVo == null){
            loginUserVo = new LoginUserVo();
        }
        return loginUserVo;
    }

    public static HashMap<String, UserVo> getLoginUserMap() {
        return loginUserMap;
    }
}
