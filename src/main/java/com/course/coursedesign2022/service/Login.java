package com.course.coursedesign2022.service;

import com.course.coursedesign2022.mapper.userInfoMapper;
import com.course.coursedesign2022.pojo.userInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;

@Service
public class Login {
    @Autowired
    private userInfoMapper userInfoMapper;

    public boolean login(int id) {
        userInfo userInfo = userInfoMapper.selectByPrimaryKey(id);

        if (userInfo == null){
            return false;
        }

        String today = LocalDate.now().toString();

        if (!Objects.equals(userInfo.getLastlogindate(), today)) {
            userInfo.setLastlogindate(today);
            userInfo.setGrowscore(userInfo.getGrowscore() + 1);
            userInfo.setScoretotal(userInfo.getGrowscore() + userInfo.getExchangescore());
            userInfoMapper.updateByPrimaryKeySelective(userInfo);
        }
        System.out.println("login execute");
        return true;
    }
}
