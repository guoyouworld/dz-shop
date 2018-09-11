package com.dz.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections4.MapUtils;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dz.entity.FullUserInfo;
import com.dz.entity.UserInfo;
import com.dz.entity.UserVo;
import com.dz.utils.CharUtil;
import com.dz.utils.CommonUtil;
import com.dz.utils.ResourceUtil;
import com.dz.utils.StringUtils;
import com.dz.service.ApiUserService;
import com.dz.service.TokenService;


//@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class LoginController {
	protected Logger logger = Logger.getLogger(getClass());
	@Autowired
    protected HttpServletRequest request;
	@Autowired
    private RestTemplate restTemplate;
	@Autowired
    private TokenService tokenService;
	@Autowired
    private ApiUserService userService;
	
	
	@RequestMapping(value="/auth/login", method = RequestMethod.POST)
	@ResponseBody
	public String test(HttpServletRequest request ,Model model) {
		Object username = request.getParameter("username");
		Object password = request.getParameter("password");
		
		System.out.println(username);
		System.out.println(password);
		return "success";
	}
	@RequestMapping(value="/auth/login_by_weixin", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> login_by_weixin(HttpServletRequest request ,Model model,@RequestBody String param ) {
		//因为'Content-Type': 'application/json',，所以request.getParameter这种方式无法获取值
		//@RequestParam用来处理ContentType: 为 application/x-www-form-urlencoded编码的内容
		//@RequestBody该注解常用来处理Content-Type: 不是application/x-www-form-urlencoded编码的内容，例如application/json, application/xml等；
		
		//Object code = request.getParameter("code");
		//Object userInfo = request.getParameter("userInfo");
		
		//第一步：获取小程序传过来的参数code和userinfo
		JSONObject jsonParam =JSONObject.parseObject(param); 
		
		FullUserInfo fullUserInfo = null;
        String code = "";
        if (jsonParam.getString("code")!=null && !"".equals(jsonParam.getString("code"))) {
            code = jsonParam.getString("code");
        }
        if (null != jsonParam.get("userInfo")) {
            fullUserInfo = jsonParam.getObject("userInfo", FullUserInfo.class);
        }
        UserInfo userInfo = fullUserInfo.getUserInfo();
        //第二步:拼接微信服务器所需的url并访问，获取返回的openid
        String requestUrl = String.format(ResourceUtil.getConfigByName("wx.webAccessTokenhttps"),
                ResourceUtil.getConfigByName("wx.appId"),
                ResourceUtil.getConfigByName("wx.secret"),
                code);
        System.out.println("》》》组合token为：" + requestUrl);
        
        
        String res = restTemplate.getForObject(requestUrl, String.class);
        //res >>  {"session_key": "************+*******==","openid": "**************************"}
        JSONObject sessionData = JSON.parseObject(res);

        if (null == sessionData || StringUtils.isNullOrEmpty(sessionData.getString("openid"))) {
            return toResponsFail("登录失败");
        }
        //验证用户信息完整性
        String sha1 = CommonUtil.getSha1(fullUserInfo.getRawData() + sessionData.getString("session_key"));
        if (!fullUserInfo.getSignature().equals(sha1)) {
            return toResponsFail("登录失败");
        }
        
        //第三步:与本地服务交互，用户管理
        Date nowTime = new Date();
        UserVo userVo = userService.queryByOpenId(sessionData.getString("openid"));
        if (null == userVo) {
            userVo = new UserVo();
            userVo.setUsername("微信用户" + CharUtil.getRandomString(12));
            userVo.setPassword(sessionData.getString("openid"));
            userVo.setRegister_time(nowTime);
            userVo.setRegister_ip(this.getClientIp());
            userVo.setLast_login_ip(userVo.getRegister_ip());
            userVo.setLast_login_time(userVo.getRegister_time());
            userVo.setWeixin_openid(sessionData.getString("openid"));
            userVo.setAvatar(userInfo.getAvatarUrl());
            userVo.setGender(userInfo.getGender()); // //性别 0：未知、1：男、2：女
            userVo.setNickname(userInfo.getNickName());
            userService.save(userVo);
        } else {
            userVo.setLast_login_ip(this.getClientIp());
            userVo.setLast_login_time(nowTime);
            userService.update(userVo);
        }
        
        //第四步：创建token
        Map<String, Object> tokenMap = tokenService.createToken(userVo.getUserId());
        String token = MapUtils.getString(tokenMap, "token");

        if (null == userInfo || StringUtils.isNullOrEmpty(token)) {
            return toResponsFail("登录失败");
        }
        //第五步：返回结果
        Map<String, Object> resultObj = new HashMap<String, Object>();
        resultObj.put("token", token);
        resultObj.put("userInfo", userInfo);
        resultObj.put("userId", userVo.getUserId());
        return toResponsSuccess(resultObj);
        
        
	}
	
	public Map<String, Object> toResponsObject(int requestCode, String msg, Object data) {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("errno", requestCode);
        obj.put("errmsg", msg);
        if (data != null)
            obj.put("data", data);
        return obj;
    }

    public Map<String, Object> toResponsSuccess(Object data) {
        Map<String, Object> rp = toResponsObject(0, "执行成功", data);
        logger.info("response:" + rp);
        return rp;
    }

    public Map<String, Object> toResponsMsgSuccess(String msg) {
        return toResponsObject(0, msg, "");
    }

    public Map<String, Object> toResponsSuccessForSelect(Object data) {
        Map<String, Object> result = new HashMap<String, Object>(2);
        result.put("list", data);
        return toResponsObject(0, "执行成功", result);
    }

    public Map<String, Object> toResponsFail(String msg) {
        return toResponsObject(1, msg, null);
    }
    /**
     * 获取请求方IP
     *
     * @return 客户端Ip
     */
    public String getClientIp() {
        String xff = request.getHeader("x-forwarded-for");
        if (xff == null) {
            return "8.8.8.8";
        }
        return xff;
    }
}
