package com.course.coursedesign2022.service;

import com.course.coursedesign2022.mapper.userInfoMapper;
import com.course.coursedesign2022.pojo.userInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BloodSugar {
    @Autowired
    userInfoMapper userInfoMapper;

    public boolean bloodSugar(Integer id) {
        userInfo userInfo = userInfoMapper.selectByPrimaryKey(id);

        if (userInfo == null) {
            return false;
        }
        Integer Grow = userInfo.getGrowscore();
        Integer total = userInfo.getScoretotal();

        //获得当前血糖次数，并更新血糖记录次数+1
        Integer bloodCount = userInfo.getBloodsugarcount();
        userInfo.setBloodsugarcount(++bloodCount);

        if(bloodCount > 3) {
            userInfo.setGrowscore(Grow + 1);
            userInfo.setScoretotal(total + 1);
            userInfoMapper.updateByPrimaryKeySelective(userInfo);
        }

        System.out.println("bloodSugar execute");
        return true;
    }


}
