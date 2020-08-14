package com.oscar.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.oscar.demo.common.response.Result;
import com.oscar.demo.service.WxUserService;
import com.oscar.demo.utils.HttpUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.oscar.demo.entity.WxUser;
import com.oscar.demo.utils.RedisUtil;

import java.io.IOException;
import java.util.HashMap;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private WxUserService wxUserService;

    private static org.apache.log4j.Logger logger = Logger.getLogger(TestController.class);

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }


    @GetMapping("/getQrCode")
    @ResponseBody
    public Result getQrCode(@RequestParam(value = "name", defaultValue = "World") String name) throws IOException {
        String url = "";
        HashMap postData = new HashMap();
        postData.put("proxyIp", "");
        postData.put("proxyUserName", "");
        postData.put("proxyPassword", "");
        String sonObject = JSONObject.toJSONString(postData);
        HashMap headers = new HashMap();
        headers.put("Content-Type", "application/json");
        String response = HttpUtils.post(url, sonObject, headers);

        JSONObject resp = JSONObject.parseObject(response);

        if(resp.getObject("Code", String.class).equals("0")) {
            String uuid = resp.getJSONObject("Data").getObject("Uuid", String.class);
            logger.info("uuid = " + uuid  );
            redisUtil.set("uuid", uuid);
        }
        JSONObject result = new JSONObject();
        result.put("data", resp );
        return Result.SUCCESS(result);
    }

    @GetMapping("/findUser")
    @ResponseBody
    public Result findUser(@RequestParam(value = "id") Integer id){
        JSONObject result = new JSONObject();
        Object data = wxUserService.selectById(id);
        result.put("data", data );
        return Result.SUCCESS(result);
    }

    @PostMapping("/delUser")
    @ResponseBody
    public Result delUser(@RequestParam(value = "id") Integer id) {
        JSONObject result = new JSONObject();
        if(wxUserService.deleteById(id) != 1) {
            return Result.FAIL("delete error");
        }
        result.put("data", null );
        return Result.SUCCESS(result);
    }

    @PostMapping("/insertUser")
    @ResponseBody
    public Result insertUser(WxUser wxUser) {
        wxUser.setWxid("fenyiO");
        wxUser.setNickname("荔枝");
        wxUser.setMobile("18888888888");
        JSONObject result = new JSONObject();
        int inertId = wxUserService.insert(wxUser);
        result.put("data", inertId );
        return Result.SUCCESS(result);
    }


}
