package com.course.coursedesign2022.service;

import com.course.coursedesign2022.mapper.userInfoMapper;
import com.course.coursedesign2022.pojo.userInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExtendedActivity {
    @Autowired
    private userInfoMapper userInfoMapper;

    public boolean extendedActivity(int id) {
        userInfo userInfo = userInfoMapper.selectByPrimaryKey(id);

        if (userInfo == null) {
            return false;
        }

        userInfo.setExchangescore(userInfo.getExchangescore() + 5);
        userInfo.setScoretotal(userInfo.getGrowscore() + userInfo.getExchangescore());
        userInfoMapper.updateByPrimaryKeySelective(userInfo);

        System.out.println("extendedActivity execute");
        return true;
    }
}
