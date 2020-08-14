package com.oscar.demo.service.lmpl;

import com.oscar.demo.mapper.BaseMapper;
import com.oscar.demo.mapper.WxUserMapper;
import com.oscar.demo.service.WxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WxUserServicelmpl extends BaseServiceImpl implements WxUserService {

    @Autowired
    WxUserMapper wxUserMapper;

    @Override
    public BaseMapper getMapper() {
        return wxUserMapper;
    }


}
