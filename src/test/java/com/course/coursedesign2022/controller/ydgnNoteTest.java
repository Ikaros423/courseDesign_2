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

import java.time.LocalDate;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ydgnNoteTest {
    static private Integer id;
    static private String url;

    @Inject
    private MockMvc mockMvc;

    @Autowired
    userInfoMapper userInfoMapper;

    public void printUser(int id) {
        userInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
        System.out.println(userInfo);
    }

    @BeforeAll
    public static void setupBeforeAll() throws Exception {
        id=1;
        url="/ydgnNote/" + id;
    }

    @BeforeEach
    public void setup() throws Exception {
        if (userInfoMapper.selectByPrimaryKey(id) != null) {
            userInfoMapper.deleteByPrimaryKey(id);
        }
        userInfo userInfo = new userInfo();
        userInfo.setId(id);
        userInfoMapper.insert(userInfo);
    }

    @Test
    public void testydgnNote_lessThanThreeMonths() throws Exception {
        userInfo userInfoOld = userInfoMapper.selectByPrimaryKey(id);
        userInfoOld.setYdgndate(LocalDate.now().toString());
        userInfoMapper.updateByPrimaryKeySelective(userInfoOld);
        printUser(id);

        RequestBuilder requestBuilder;
        requestBuilder = put(url);
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("ydgnNote updated")));

        userInfo userInfoNew = userInfoMapper.selectByPrimaryKey(id);
        assert (userInfoNew.getGrowscore() - userInfoOld.getGrowscore()) == 0;
        assert (userInfoNew.getScoretotal() - userInfoOld.getScoretotal()) == 0;
        printUser(id);
    }

    @Test
    public void testydgnNote_moreThanThreeMonth() throws Exception {
        userInfo userInfoOld = userInfoMapper.selectByPrimaryKey(id);
        userInfoOld.setYdgndate("2025-05-20");
        userInfoMapper.updateByPrimaryKey(userInfoOld);
        printUser(id);

        RequestBuilder requestBuilder;
        requestBuilder = put(url);
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("ydgnNote updated")));

        userInfo userInfoNew = userInfoMapper.selectByPrimaryKey(id);
        assert (userInfoNew.getGrowscore() - userInfoOld.getGrowscore()) == 2;
        assert (userInfoNew.getScoretotal() - userInfoOld.getScoretotal()) == 2;
        printUser(id);
    }
}
