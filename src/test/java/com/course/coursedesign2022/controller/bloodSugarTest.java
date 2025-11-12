package com.course.coursedesign2022.controller;

import com.course.coursedesign2022.mapper.userInfoMapper;
import com.course.coursedesign2022.pojo.userInfo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import javax.inject.Inject;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class bloodSugarTest {
    static private Integer id;
    static private String url;


    @Inject
    private MockMvc mockMvc;

    @Autowired
    userInfoMapper userInfoMapper;

    public void printUser(Integer id){
        userInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
        System.out.println(userInfo);
    }

    @BeforeAll
    public static void setupBeforeAll() throws Exception{
        id=1;
        url="/bloodSugar/" + id;
    }

    @BeforeEach
    public void setup() throws Exception{
        if (userInfoMapper.selectByPrimaryKey(id) != null) {
            userInfoMapper.deleteByPrimaryKey(id);
        }
        userInfo userInfo = new userInfo();
        userInfo.setId(id);
        userInfoMapper.insert(userInfo);
    }

    @Test
    public void bloodSugarTest_lessThanThreeTimes() throws Exception{
        userInfo userInfoOld = userInfoMapper.selectByPrimaryKey(id);
        userInfoOld.setBloodsugarcount(2);
        if(userInfoOld.getBloodsugarcount()<3){
            userInfoMapper.updateByPrimaryKey(userInfoOld);
        };   //填写血糖记录次数小于三次
        printUser(id);

        RequestBuilder requestBuilder;
        requestBuilder = put(url);
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("bloodSugar updated")));

        userInfo userInfoNew = userInfoMapper.selectByPrimaryKey(id);
        assert (userInfoNew.getGrowscore()-userInfoOld.getGrowscore()) == 0;
        assert (userInfoNew.getScoretotal()-userInfoOld.getScoretotal()) == 0;
        printUser(id);
    }

    @Test
    public void bloodSugarTest_moreThanThreeTimes() throws Exception{
        userInfo userInfoOld = userInfoMapper.selectByPrimaryKey(id);
        userInfoOld.setBloodsugarcount(4);
        if(userInfoOld.getBloodsugarcount()>3){
            userInfoMapper.updateByPrimaryKey(userInfoOld);
        }; //填写血糖次数记录大于三次
        printUser(id);

        RequestBuilder requestBuilder;
        requestBuilder = put(url);
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("bloodSugar updated")));

        userInfo userInfoNew = userInfoMapper.selectByPrimaryKey(id);
        assert (userInfoNew.getGrowscore()+userInfoOld.getGrowscore()) == 1;
        assert (userInfoNew.getScoretotal() - userInfoOld.getScoretotal()) == 1;
        printUser(id);
    }
}

