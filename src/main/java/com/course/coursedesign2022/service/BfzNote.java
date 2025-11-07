package com.course.coursedesign2022.service;

import com.course.coursedesign2022.mapper.userInfoMapper;
import com.course.coursedesign2022.pojo.userInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;

@Service
public class BfzNote {
    @Autowired
    userInfoMapper userInfoMapper;

    public boolean bfzNote(int id) {
        userInfo userInfo = userInfoMapper.selectByPrimaryKey(id);

        if (userInfo==null){
            return false;
        }

        int year = LocalDate.now().getYear();
        String curYear = String.valueOf(year);

        if (!Objects.equals(userInfo.getBfzdate(), curYear)) {
            userInfo.setBfzdate(curYear);
            userInfo.setGrowscore(userInfo.getGrowscore() + 3);
            userInfo.setScoretotal(userInfo.getExchangescore() + userInfo.getGrowscore());
            userInfoMapper.updateByPrimaryKeySelective(userInfo);
        }
        System.out.println("bfzNote execute");
        return true;
    }
}
