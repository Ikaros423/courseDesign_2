package com.course.coursedesign2022.service;

import com.course.coursedesign2022.mapper.userInfoMapper;
import com.course.coursedesign2022.pojo.userInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FillInformation {
    @Autowired
    userInfoMapper userInfoMapper;

    public boolean fillInformation(int id){
        userInfo userInfo = userInfoMapper.selectByPrimaryKey(id);

        if (userInfo==null){
            return false;
        }

        if (userInfo.getFillinformationbefore()==0){
            userInfo.setFillinformationbefore(1);
            userInfo.setGrowscore(userInfo.getGrowscore()+2);
            userInfo.setScoretotal(userInfo.getGrowscore()+userInfo.getExchangescore());
            userInfoMapper.updateByPrimaryKey(userInfo);
        }
        System.out.println("fillInformation execute");
        return true;
    }
}
