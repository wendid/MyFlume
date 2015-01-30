package org.hanzhi.ps.tailor.user.service;


import org.hanzhi.ps.tailor.user.dao.UserDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("userService")
public class UserService {
    @Resource
    private UserDAO userDao;

    @Transactional
    public int userCount() {
        return userDao.getAllUser().size();
    }

    public UserDAO getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDAO userDao) {
        this.userDao = userDao;
    }

}
