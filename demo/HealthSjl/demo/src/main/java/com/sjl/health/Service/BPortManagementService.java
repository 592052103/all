package com.sjl.health.Service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjl.health.entity.FUserData;
import com.sjl.health.entity.FlowPointColumnTitle;
import com.sjl.health.entity.FlowPointSearchMenu;
import com.sjl.health.entity.THealthDataDefine;
import com.sjl.health.mapper.FUserDataMapper;
import com.sjl.health.mapper.THealthDataDefineMapper;

@Service
public class BPortManagementService {
	
	@Autowired
	THealthDataDefineMapper tHealthDataDefineMapper;
	@Autowired
	FUserDataMapper fUserDataMapper;
	
    private final static Logger logger = LoggerFactory.getLogger(BPortManagementService.class);
	
	public List<FlowPointSearchMenu> getFlowPointFieldsSearchMenu(String flowNo,String flowPointId) throws Exception {
		List<THealthDataDefine> tHealthDataDefineList = new ArrayList<THealthDataDefine>();
		List<FlowPointSearchMenu> flowPointSearchMenuList = new ArrayList<FlowPointSearchMenu>();
		List<FlowPointColumnTitle> flowPointColumnTitleList = new ArrayList<FlowPointColumnTitle>();
		List<FUserData> fUserDataList = new ArrayList<FUserData>();
		List<FlowPointColumnTitle> flowPointColumnValueList = null;
		List<List<FlowPointColumnTitle>> flowPointColumnValueCollection = new ArrayList<List<FlowPointColumnTitle>>();
		String [] tHealthDataDefineArray = null;
		//定义table的Title值
		int flowPointColumnTitleSize = 0;
		if (flowNo == null || flowPointId == null) {
			logger.error("流程编码与流程Id不能为空");
			throw new Exception("流程编码与流程Id不能为空");
		}
		
		try {
			if (flowNo != null && flowPointId != null) {
				tHealthDataDefineList = tHealthDataDefineMapper.getFlowPointFieldsSearchMenu(flowNo, flowPointId);
			}
			//获取查询条件输入框
			if (tHealthDataDefineList != null && tHealthDataDefineList.size() > 0) {
				logger.info("getFlowPointFieldsSearchMenu is sucess.............");
				for (int i = 0; i < tHealthDataDefineList.size(); i ++) {
					FlowPointSearchMenu flowPointSearchMenuVO = new FlowPointSearchMenu();
					if (tHealthDataDefineList.get(i).getFieldName() != null) {
						flowPointSearchMenuVO.setFieldName(tHealthDataDefineList.get(i).getFieldName());
					}
					if (tHealthDataDefineList.get(i).getFieldDesc() != null) {
						flowPointSearchMenuVO.setFieldDesc(tHealthDataDefineList.get(i).getFieldDesc());
					}
					if (tHealthDataDefineList.get(i).getDefultValue() != null) {
						flowPointSearchMenuVO.setFieldValue(tHealthDataDefineList.get(i).getDefultValue());
					}
					if (tHealthDataDefineList.get(i).getFieldLenth() != null) {
						flowPointSearchMenuVO.setFieldSize(tHealthDataDefineList.get(i).getFieldLenth().toString());
					}
					if (tHealthDataDefineList.get(i).getFieldType() != null) {
						flowPointSearchMenuVO.setFieldType(tHealthDataDefineList.get(i).getFieldType());
					}
					if(tHealthDataDefineList.get(i).getCodeType() != null) {
						flowPointSearchMenuVO.setFieldType(tHealthDataDefineList.get(i).getCodeType());
					}
					flowPointSearchMenuList.add(flowPointSearchMenuVO);
				}
			}
			
			//获取列表Title信息
			if (flowNo != null && flowPointId != null) {
				tHealthDataDefineList = tHealthDataDefineMapper.getFlowPointFieldsTitle(flowNo, flowPointId);
			}
			if (tHealthDataDefineList != null && tHealthDataDefineList.size() > 0) {
				tHealthDataDefineArray = new String[tHealthDataDefineList.size()];
				//flowPointColumnTitleSize = tHealthDataDefineList.size();
				for(int i = 0; i < tHealthDataDefineList.size(); i ++) {
					FlowPointColumnTitle flowPointColumnTitleVO = new FlowPointColumnTitle();
					if (tHealthDataDefineList.get(i).getFieldDesc()	!= null) {
						flowPointColumnTitleVO.setFieldDesc(tHealthDataDefineList.get(i).getFieldDesc());
					}
					if(tHealthDataDefineList.get(i).getFieldName() != null) {
						//使用数组，记录FieldName值，做下面的数组位移判断
						tHealthDataDefineArray[i] = tHealthDataDefineList.get(i).getFieldName();
						flowPointColumnTitleVO.setFieldName(tHealthDataDefineList.get(i).getFieldName());
					}
					flowPointColumnTitleList.add(flowPointColumnTitleVO);
				}	
			}
			
			//获取列表信息对应的FlowPointFields值
			
			//获取列表值的信息
			if (tHealthDataDefineList != null && tHealthDataDefineList.size() > 0) {
				fUserDataList = fUserDataMapper.getFlowPointFieldsValue(tHealthDataDefineList);
			}
			if (fUserDataList != null && fUserDataList.size() > 0) {
				for (int i = 0; i < fUserDataList.size(); i ++) {
					FlowPointColumnTitle flowPointColumnTitleVO = null;
					//定义列表Tile的坐标
					int j = 0;
					if (fUserDataList.get(i).getFieldName().equals(tHealthDataDefineArray[j])) {
						flowPointColumnTitleVO = new FlowPointColumnTitle();
						flowPointColumnTitleVO.setFieldName(fUserDataList.get(i).getFieldName());
						flowPointColumnValueList.add(flowPointColumnTitleVO);
						j ++;
					}
					if (j == tHealthDataDefineList.size()) {
						
					}
					if (fUserDataList.get(i).getFieldName().equals(tHealthDataDefineArray[j])) {
						//flowPointColumnValueCollection
					}
					
				}
			}
			
			
		}catch(RuntimeException e) {
			e.printStackTrace();
		}		
		return flowPointSearchMenuList;
	}
	
	

}
