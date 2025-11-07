package com.course.coursedesign2022.controller;

import com.course.coursedesign2022.mapper.userInfoMapper;
import com.course.coursedesign2022.pojo.userInfo;
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
public class bfzNoteTest {
    private Integer id;

    @Inject
    private MockMvc mockMvc;

    @Autowired
    userInfoMapper userInfoMapper;

    public void printUser(int id) {
        userInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
        System.out.println(userInfo);
    }

    @BeforeEach
    public void setup() throws Exception {
        this.id = 1;
        if (userInfoMapper.selectByPrimaryKey(id) != null) {
            userInfoMapper.deleteByPrimaryKey(id);
        }
        userInfo userInfo = new userInfo();
        userInfo.setId(id);
        userInfoMapper.insert(userInfo);
    }

    @Test
    public void testBfzNote_NotFilledThisYear() throws Exception {
        printUser(id);
        userInfo userInfoOld = userInfoMapper.selectByPrimaryKey(id);
        RequestBuilder requestBuilder;
        String url = "/bfzNote/" + id;
        requestBuilder = put(url);
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("bfzNote updated")));

        userInfo userInfoNew = userInfoMapper.selectByPrimaryKey(id);
        assert (userInfoNew.getGrowscore() - userInfoOld.getGrowscore()) == 3;
        assert (userInfoNew.getScoretotal() - userInfoOld.getScoretotal()) == 3;
        printUser(id);
    }

    @Test
    public void testBfzNote_FilledThisYear() throws Exception {
        userInfo userInfoOld = userInfoMapper.selectByPrimaryKey(id);
        userInfoOld.setBfzdate(String.valueOf(LocalDate.now().getYear())); // 设置今年记录过
        userInfoMapper.updateByPrimaryKey(userInfoOld);
        printUser(id);

        RequestBuilder requestBuilder;
        String url = "/bfzNote/" + id;
        requestBuilder = put(url);
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("bfzNote updated")));

        userInfo userInfoNew = userInfoMapper.selectByPrimaryKey(id);
        assert (userInfoNew.getGrowscore() - userInfoOld.getGrowscore()) == 0;
        assert (userInfoNew.getScoretotal() - userInfoOld.getScoretotal()) == 0;
        printUser(id);
    }
}
