package com.course.coursedesign2022.service;

import com.course.coursedesign2022.mapper.userInfoMapper;
import com.course.coursedesign2022.pojo.userInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;

@Service
public class YdgnNote {
    @Autowired
    userInfoMapper userInfoMapper;

    public boolean YdgnNote(int id ){
        userInfo userInfo = userInfoMapper.selectByPrimaryKey(id);

        if (userInfo==null){
            return false;
        }
        boolean flag = false;

        Integer Grow = userInfo.getGrowscore();
        Integer total = userInfo.getScoretotal();

        //获取当前的标准格式的时间
        String curMonth = LocalDate.now().toString();

        //获取填写监测胰岛功能时的日期
        String lastMonth = userInfo.getYdgndate();

        //积分逻辑,首次填写时lastMonth为空，加分，
        if( lastMonth == "" || userInfo.calculateMonths(lastMonth, curMonth) >= 3 ) {
            //更新日期
            userInfo.setYdgndate(curMonth);
            userInfo.setGrowscore(Grow+2);
            userInfo.setScoretotal(total+2);
        }
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
        System.out.println("bfzNote execute");
        return true;
    }
}
