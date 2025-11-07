package com.course.coursedesign2022.service;

import com.course.coursedesign2022.mapper.userInfoMapper;
import com.course.coursedesign2022.pojo.userInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResearchRecruitment {
    @Autowired
    private userInfoMapper userInfoMapper;

    public boolean researchRecruitment(int id) {
        userInfo userInfo = userInfoMapper.selectByPrimaryKey(id);

        if (userInfo == null) {
            return false;
        }

        Integer Exchange = userInfo.getExchangescore();
        Integer total = userInfo.getScoretotal();
        userInfo.setExchangescore(Exchange + 8);
        userInfo.setScoretotal(total + 8);
        userInfoMapper.updateByPrimaryKey(userInfo);

        System.out.println("researchRecruitment execute");
        return true;
    }
}
