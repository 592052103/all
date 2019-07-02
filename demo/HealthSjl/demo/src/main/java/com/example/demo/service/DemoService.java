package com.example.demo.service;

import com.example.demo.entity.DemoInfo;
import com.example.demo.mapper.DemoInfoMapper;
import com.sjl.health.Service.BPortManagementService;
import com.sjl.health.redisUtil.RedisUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DemoService {
    @Autowired
    private DemoInfoMapper demoInfoMapper;
    
    @Autowired
    private RedisUtil redisUtil;
    
    private final static Logger logger = LoggerFactory.getLogger(BPortManagementService.class);

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void add(DemoInfo demoInfo){
    	redisUtil.set(demoInfo.getUserName(), demoInfo.getAddress());
    	logger.info(redisUtil.get(demoInfo.getUserName()).toString());
        demoInfoMapper.insert(demoInfo);
    }
    
    public DemoInfo get(Integer id) {
    	return demoInfoMapper.selectByPrimaryKey(id);
    }
}
