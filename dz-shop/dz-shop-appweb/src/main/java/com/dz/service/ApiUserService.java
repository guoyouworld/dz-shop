package com.dz.service;

import com.dz.dao.ApiUserLevelMapper;
import com.dz.dao.ApiUserMapper;
import com.dz.entity.SmsLogVo;
import com.dz.entity.UserLevelVo;
import com.dz.entity.UserVo;
import com.dz.utils.RRException;
import com.dz.validator.Assert;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class ApiUserService {
    @Autowired
    private ApiUserMapper userDao;
    @Autowired
    private ApiUserLevelMapper userLevelDao;

    public UserVo queryObject(Long userId) {
        return userDao.queryObject(userId);
    }

    public UserVo queryByOpenId(String openId) {
        return userDao.queryByOpenId(openId);
    }

    public List<UserVo> queryList(Map<String, Object> map) {
        return userDao.queryList(map);
    }

    public int queryTotal(Map<String, Object> map) {
        return userDao.queryTotal(map);
    }

    public void save(String mobile, String password) {
        UserVo user = new UserVo();
        user.setMobile(mobile);
        user.setUsername(mobile);
        user.setPassword(DigestUtils.sha256Hex(password));
        user.setRegister_time(new Date());
        userDao.save(user);
    }

    public void save(UserVo userVo) {
        userDao.save(userVo);
    }

    public void update(UserVo user) {
        userDao.update(user);
    }

    public void delete(Long userId) {
        userDao.delete(userId);
    }

    public void deleteBatch(Long[] userIds) {
        userDao.deleteBatch(userIds);
    }

    public UserVo queryByMobile(String mobile) {
        return userDao.queryByMobile(mobile);
    }

    public long login(String mobile, String password) {
        UserVo user = queryByMobile(mobile);
        Assert.isNull(user, "手机号或密码错误");

        //密码错误
        if (!user.getPassword().equals(DigestUtils.sha256Hex(password))) {
            throw new RRException("手机号或密码错误");
        }

        return user.getUserId();
    }

    public SmsLogVo querySmsCodeByUserId(Long user_id) {
        return userDao.querySmsCodeByUserId(user_id);
    }


    public int saveSmsCodeLog(SmsLogVo smsLogVo) {
        return userDao.saveSmsCodeLog(smsLogVo);
    }

    public String getUserLevel(UserVo loginUser) {
        String result = "普通用户";
        UserLevelVo userLevelVo = userLevelDao.queryObject(loginUser.getUser_level_id());
        if (null != userLevelVo) {
            result = userLevelVo.getName();
        }
        return result;
    }
}
