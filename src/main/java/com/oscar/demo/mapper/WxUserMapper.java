package com.oscar.demo.mapper;

import com.oscar.demo.entity.WxUser;

public interface WxUserMapper extends BaseMapper<WxUser, String>{

    Object getWechatUser(Integer id);
}
