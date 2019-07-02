package com.example.demo.controller;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.DemoInfo;
import com.example.demo.service.DemoService;
import com.sjl.health.redisUtil.RedisUtil;

@RestController
@RequestMapping("/fcb/api/v1")
public class DemoController {    
	@Autowired
    private DemoService demoService;
    
	@Autowired
	private RedisUtil redisUtil;
	
    private final static Logger logger = LoggerFactory.getLogger(DemoController.class);


    @RequestMapping(value="/add",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public int add(@RequestBody DemoInfo userInfo){
        DemoInfo demoInfo = new DemoInfo();
        demoInfo.setUserName(userInfo.getUserName());
        demoInfo.setAddress(userInfo.getAddress());
        demoService.add(demoInfo);
		return 1;
    }
    
    @RequestMapping(value="/get",method=RequestMethod.GET)
    public void get() {
    	logger.info("logback Test");
    	logger.error("logback Error Test");
    	DemoInfo demo = new DemoInfo();
    	demo = demoService.get(1);
    	System.out.println(demo.getUserName());
    	System.out.println(demo.getAddress());
    }
    
    
    
    @RequestMapping(value="/getStr",method=RequestMethod.GET,produces="application/json")
    public String getString() {
    	String str = "{\r\n" + 
    			"  \"field_list\": [{\r\n" + 
    			"      \"field_name\": \"user_name\",\r\n" + 
    			"      \"field_desc\": \"用户姓名\",\r\n" + 
    			"      \"field_value\": \"\",\r\n" + 
    			"      \"field_size\": 20,\r\n" + 
    			"      \"field_type\": \"C0\",\r\n" + 
    			"      \"type\": \"TEXT\",\r\n" + 
    			"      \"check_rule\": \"this.user_name!=''\",\r\n" + 
    			"      \"check_tip\": \"用户姓名不能为空！\"\r\n" + 
    			"    },\r\n" + 
    			"    {\r\n" + 
    			"      \"field_name\": \"user_phone\",\r\n" + 
    			"      \"field_desc\": \"手机号码\",\r\n" + 
    			"      \"field_value\": \"\",\r\n" + 
    			"      \"field_size\": 18,\r\n" + 
    			"      \"field_type\": \"D0\",\r\n" + 
    			"      \"type\": \"TEXT\",\r\n" + 
    			"      \"check_rule\": \"this.user_phone!=''\",\r\n" + 
    			"      \"check_tip\": \"手机号码不能为空！\"\r\n" + 
    			"    },\r\n" + 
    			"    {\r\n" + 
    			"      \"field_name\": \"user_sex\",\r\n" + 
    			"      \"field_desc\": \"性别\",\r\n" + 
    			"      \"field_value\": \"F\",\r\n" + 
    			"      \"field_type\": \"C0\",\r\n" + 
    			"      \"type\": \"RADIO\",\r\n" + 
    			"      \"code_value\": [{\r\n" + 
    			"        \"code_no\": \"F\",\r\n" + 
    			"        \"code_val\": \"女\"\r\n" + 
    			"      }, {\r\n" + 
    			"        \"code_no\": \"M\",\r\n" + 
    			"        \"code_val\": \"男\"\r\n" + 
    			"      }],\r\n" + 
    			"      \"check_rule\": \"this.user_sex!=''\",\r\n" + 
    			"      \"check_tip\": \"性别不能为空！\"\r\n" + 
    			"    }\r\n" + 
    			"  ]\r\n" + 
    			"}";
    	System.out.println(str);
		return str;
    }
    
    //@RequestMapping(value="/menu_list",method=RequestMethod.GET,produces="application/json")
    public String menu_list(@Param("userId") String userId,@Param("id")String id) throws Exception {
    	String str = null;
    	if (userId == null || id == null) {
    		throw new Exception("请输入查询参数");
    	}
    	if (id.equals("1") && userId.equals("1")) {
    		str = "{\r\n" + 
        			"  \"err_code\":\"0000\",\r\n" + 
        			"  \"err_msg\" : \"\",\r\n" + 
        			"  \"menu_list\": [{\r\n" + 
        			"      \"flow_no\": \"0001\",\r\n" + 
        			"      \"flow_name\": \"功能1\",\r\n" + 
        			"      \"flow_type\": \"list\"\r\n" + 
        			"      \r\n" + 
        			"    },{\r\n" + 
        			"      \"flow_no\": \"0002\",\r\n" + 
        			"      \"flow_name\": \"功能2\",\r\n" + 
        			"      \"flow_type\": \"list\"\r\n" + 
        			"      \r\n" + 
        			"    },\r\n" + 
        			"	{\r\n" + 
        			"      \"flow_no\": \"0003\",\r\n" + 
        			"      \"flow_name\": \"功能3\",\r\n" + 
        			"      \"flow_type\": \"list\"\r\n" + 
        			"      \r\n" + 
        			"    },\r\n" + 
        			"	{\r\n" + 
        			"      \"flow_no\": \"0004\",\r\n" + 
        			"      \"flow_name\": \"功能4\",\r\n" + 
        			"      \"flow_type\": \"list\"\r\n" + 
        			"      \r\n" + 
        			"    },\r\n" + 
        			"	{\r\n" + 
        			"      \"flow_no\": \"0005\",\r\n" + 
        			"      \"flow_name\": \"功能5\",\r\n" + 
        			"      \"flow_type\": \"list\"\r\n" + 
        			"      \r\n" + 
        			"    }\r\n" + 
        			"  ]\r\n" + 
        			"}";
    	}
    	if (id.equals("2") && userId.equals("2")) {
    		str = "{\r\n" + 
        			"  \"err_code\":\"0000\",\r\n" + 
        			"  \"err_msg\" : \"\",\r\n" + 
        			"  \"menu_list\": [{\r\n" + 
        			"      \"flow_no\": \"0001\",\r\n" + 
        			"      \"flow_name\": \"中国\",\r\n" + 
        			"      \"flow_type\": \"list\"\r\n" + 
        			"      \r\n" + 
        			"    },{\r\n" + 
        			"      \"flow_no\": \"0002\",\r\n" + 
        			"      \"flow_name\": \"美国\",\r\n" + 
        			"      \"flow_type\": \"list\"\r\n" + 
        			"      \r\n" + 
        			"    },\r\n" + 
        			"	{\r\n" + 
        			"      \"flow_no\": \"0003\",\r\n" + 
        			"      \"flow_name\": \"英国\",\r\n" + 
        			"      \"flow_type\": \"list\"\r\n" + 
        			"      \r\n" + 
        			"    },\r\n" + 
        			"	{\r\n" + 
        			"      \"flow_no\": \"0004\",\r\n" + 
        			"      \"flow_name\": \"法国\",\r\n" + 
        			"      \"flow_type\": \"list\"\r\n" + 
        			"      \r\n" + 
        			"    },\r\n" + 
        			"	{\r\n" + 
        			"      \"flow_no\": \"0005\",\r\n" + 
        			"      \"flow_name\": \"日本\",\r\n" + 
        			"      \"flow_type\": \"list\"\r\n" + 
        			"      \r\n" + 
        			"    }\r\n" + 
        			"  ]\r\n" + 
        			"}";
    	}
    	
    	System.out.println(str);
		return str;
    }
    
    
    //@RequestMapping(value="/tab_list",method=RequestMethod.GET,produces="application/json")
    public String tab_list(@Param("userId") String userId,@Param("flowNo")String flowNo,@Param("id")String id) throws Exception {
    	String str = null;
    	if (userId == null || flowNo == null || id == null) {
    		throw new Exception("请输入查询参数");
    	}
    	if (userId.equals("1") && flowNo.equals("0001") && id.equals("1")) {
    		str = "{\r\n" + 
        			"  \"err_code\":\"0000\",\r\n" + 
        			"  \"err_msg\" : \"\",\r\n" + 
        			"  \"tab_list\": [{\r\n" + 
        			"      \"flow_point_id\": \"0001\",\r\n" + 
        			"      \"flow_point_name\": \"节点1\"\r\n" + 
        			"      \r\n" + 
        			"    },{\r\n" + 
        			"      \"flow_point_id\": \"0002\",\r\n" + 
        			"      \"flow_point_name\": \"节点2\"\r\n" + 
        			"      \r\n" + 
        			"    },\r\n" + 
        			"	{\r\n" + 
        			"      \"flow_point_id\": \"0003\",\r\n" + 
        			"      \"flow_point_name\": \"节点3\"\r\n" + 
        			"      \r\n" + 
        			"    },\r\n" + 
        			"	{\r\n" + 
        			"      \"flow_point_id\": \"0004\",\r\n" + 
        			"      \"flow_point_name\": \"节点4\"\r\n" + 
        			"      \r\n" + 
        			"    },\r\n" + 
        			"	{\r\n" + 
        			"      \"flow_point_id\": \"0005\",\r\n" + 
        			"      \"flow_point_name\": \"节点5\"\r\n" + 
        			"      \r\n" + 
        			"    }\r\n" + 
        			"  ]\r\n" + 
        			"}";
    	}
    	if (userId.equals("2") && flowNo.equals("0002") && id.equals("2")) {
    		str = "{\r\n" + 
        			"  \"err_code\":\"0000\",\r\n" + 
        			"  \"err_msg\" : \"\",\r\n" + 
        			"  \"tab_list\": [{\r\n" + 
        			"      \"flow_point_id\": \"0001\",\r\n" + 
        			"      \"flow_point_name\": \"广州\"\r\n" + 
        			"      \r\n" + 
        			"    },{\r\n" + 
        			"      \"flow_point_id\": \"0002\",\r\n" + 
        			"      \"flow_point_name\": \"深圳\"\r\n" + 
        			"      \r\n" + 
        			"    },\r\n" + 
        			"	{\r\n" + 
        			"      \"flow_point_id\": \"0003\",\r\n" + 
        			"      \"flow_point_name\": \"上海\"\r\n" + 
        			"      \r\n" + 
        			"    },\r\n" + 
        			"	{\r\n" + 
        			"      \"flow_point_id\": \"0004\",\r\n" + 
        			"      \"flow_point_name\": \"武汉\"\r\n" + 
        			"      \r\n" + 
        			"    },\r\n" + 
        			"	{\r\n" + 
        			"      \"flow_point_id\": \"0005\",\r\n" + 
        			"      \"flow_point_name\": \"广西\"\r\n" + 
        			"      \r\n" + 
        			"    }\r\n" + 
        			"  ]\r\n" + 
        			"}";
    	}
    	System.out.println(str);
		return str;
    }
    
    @RequestMapping(value="/getdata_list",method=RequestMethod.GET,produces="application/json")
	public String getdata_list(@Param("userId") String userId,@Param("flowNo")String flowNo,@Param("flowPointId")String flowPointId,@Param("pageNo")Integer pageNo,
						@Param("pageSize")Integer pageSize,@Param("params")String params,@Param("id")String id) throws Exception{
    	String str = null;
    	if (userId == null || flowNo == null || flowPointId == null || pageNo == null || pageSize == null || params == null || id == null ) {
    		throw new Exception("请输入查询参数");
    	}
    	if (userId.equals("1") && flowNo.equals("0001") && flowPointId.equals("0001") && pageNo.equals(1) && pageSize.equals(1) && 
    					params.equals("1") && id.equals("1")) {
    		str ="{\r\n" + 
    				"	\"err_code\": \"0000\",\r\n" + 
    				"	\"err_msg\": \"\",\r\n" + 
    				"	\"listSize\": 5,\r\n" + 
    				"	\"searchs\": [{\r\n" + 
    				"			\"field_name\": \"user_name\",\r\n" + 
    				"			\"field_desc\": \"用户姓名\",\r\n" + 
    				"			\"field_value\": \"\",\r\n" + 
    				"			\"field_size\": 20,\r\n" + 
    				"			\"field_type\": \"C0\",\r\n" + 
    				"			\"type\": \"TEXT\"\r\n" + 
    				"		},\r\n" + 
    				"		{\r\n" + 
    				"			\"field_name\": \"user_sex\",\r\n" + 
    				"			\"field_desc\": \"性别\",\r\n" + 
    				"			\"field_value\": \"F\",\r\n" + 
    				"			\"field_type\": \"C0\",\r\n" + 
    				"			\"type\": \"RADIO\",\r\n" + 
    				"			\"code_value\": [{\r\n" + 
    				"					\"code_no\": \"F\",\r\n" + 
    				"					\"code_val\": \"女女\"\r\n" + 
    				"				},\r\n" + 
    				"				{\r\n" + 
    				"					\"code_no\": \"M\",\r\n" + 
    				"					\"code_val\": \"男男\"\r\n" + 
    				"				}\r\n" + 
    				"			]\r\n" + 
    				"		}\r\n" + 
    				"	],\r\n" + 
    				"	\"columns\": [{\r\n" + 
    				"			\"field_name\": \"user_name\",\r\n" + 
    				"			\"field_desc\": \"用户的姓名\"\r\n" + 
    				"		},\r\n" + 
    				"		{\r\n" + 
    				"			\"field_name\": \"user_sex\",\r\n" + 
    				"			\"field_desc\": \"用户的性别\"\r\n" + 
    				"		},\r\n" + 
    				"		{\r\n" + 
    				"			\"field_name\": \"user_phone\",\r\n" + 
    				"			\"field_desc\": \"用户的手机号\"\r\n" + 
    				"		},\r\n" + 
    				"		{\r\n" + 
    				"			\"field_name\": \"user_address\",\r\n" + 
    				"			\"field_desc\": \"用户的住址\"\r\n" + 
    				"		},\r\n" + 
    				"		{\r\n" + 
    				"			\"field_name\": \"user_idenfy\",\r\n" + 
    				"			\"field_desc\": \"用户的身份\"\r\n" + 
    				"		}\r\n" + 
    				"	],\r\n" + 
    				"	\"datas\": [\r\n" + 
    				"\r\n" + 
    				"		[{\r\n" + 
    				"				\"field_name\": \"user_name\",\r\n" + 
    				"				\"field_value\": \"李四\"\r\n" + 
    				"			},\r\n" + 
    				"			{\r\n" + 
    				"				\"field_name\": \"user_sex\",\r\n" + 
    				"				\"field_value\": \"男\"\r\n" + 
    				"			}, {\r\n" + 
    				"				\"field_name\": \"user_phone\",\r\n" + 
    				"				\"field_value\": \"1304985769\"\r\n" + 
    				"			}, {\r\n" + 
    				"				\"field_name\": \"user_address\",\r\n" + 
    				"				\"field_value\": \"中国深圳\"\r\n" + 
    				"			}, {\r\n" + 
    				"				\"field_name\": \"user_idenfy\",\r\n" + 
    				"				\"field_value\": \"总经理\"\r\n" + 
    				"			}\r\n" + 
    				"		],\r\n" + 
    				"		[{\r\n" + 
    				"				\"field_name\": \"user_name\",\r\n" + 
    				"				\"field_value\": \"张三\"\r\n" + 
    				"			},\r\n" + 
    				"			{\r\n" + 
    				"				\"field_name\": \"user_sex\",\r\n" + 
    				"				\"field_value\": \"男\"\r\n" + 
    				"			}, {\r\n" + 
    				"				\"field_name\": \"user_phone\",\r\n" + 
    				"				\"field_value\": \"1304985769\"\r\n" + 
    				"			}, {\r\n" + 
    				"				\"field_name\": \"user_address\",\r\n" + 
    				"				\"field_value\": \"中国深圳\"\r\n" + 
    				"			}, {\r\n" + 
    				"				\"field_name\": \"user_idenfy\",\r\n" + 
    				"				\"field_value\": \"总经理\"\r\n" + 
    				"			}\r\n" + 
    				"		]\r\n" + 
    				"	],\r\n" + 
    				"	\"services\":[{\r\n" + 
    				"				\"service_point_id\":\"001\",\r\n" + 
    				"				\"service_name\":\"测量身高\",\r\n" + 
    				"				\"flow_batch_id\":\"1\",\r\n" + 
    				"				\"type\":\"1\"\r\n" + 
    				"	},\r\n" + 
    				"	{\r\n" + 
    				"				\"service_point_id\":\"002\",\r\n" + 
    				"				\"service_name\":\"测量体重\",\r\n" + 
    				"				\"flow_batch_id\":\"1\",\r\n" + 
    				"				\"type\":\"1\"\r\n" + 
    				"	},\r\n" + 
    				"	{\r\n" + 
    				"				\"service_point_id\":\"003\",\r\n" + 
    				"				\"service_name\":\"测量其他\",\r\n" + 
    				"				\"flow_batch_id\":\"1\",\r\n" + 
    				"				\"type\":\"1\"\r\n" + 
    				"	}]\r\n" + 
    				"}";
    	}
    	if (userId.equals("2") && flowNo.equals("0002") && flowPointId.equals("0002") && pageNo.equals(2) && pageSize.equals(2) 
    			&& params.equals("2") && id.equals("2")) {
    		str ="{\r\n" + 
    				"	\"err_code\": \"0000\",\r\n" + 
    				"	\"err_msg\": \"\",\r\n" + 
    				"	\"listSize\": 5,\r\n" + 
    				"	\"searchs\": [{\r\n" + 
    				"			\"field_name\": \"user_name\",\r\n" + 
    				"			\"field_desc\": \"用户姓名\",\r\n" + 
    				"			\"field_value\": \"\",\r\n" + 
    				"			\"field_size\": 20,\r\n" + 
    				"			\"field_type\": \"C0\",\r\n" + 
    				"			\"type\": \"TEXT\"\r\n" + 
    				"		},\r\n" + 
    				"		{\r\n" + 
    				"			\"field_name\": \"user_sex\",\r\n" + 
    				"			\"field_desc\": \"性别\",\r\n" + 
    				"			\"field_value\": \"F\",\r\n" + 
    				"			\"field_type\": \"C0\",\r\n" + 
    				"			\"type\": \"RADIO\",\r\n" + 
    				"			\"code_value\": [{\r\n" + 
    				"					\"code_no\": \"F\",\r\n" + 
    				"					\"code_val\": \"女女\"\r\n" + 
    				"				},\r\n" + 
    				"				{\r\n" + 
    				"					\"code_no\": \"M\",\r\n" + 
    				"					\"code_val\": \"男男\"\r\n" + 
    				"				}\r\n" + 
    				"			]\r\n" + 
    				"		}\r\n" + 
    				"	],\r\n" + 
    				"	\"columns\": [{\r\n" + 
    				"			\"field_name\": \"user_name\",\r\n" + 
    				"			\"field_desc\": \"用户的姓名\"\r\n" + 
    				"		},\r\n" + 
    				"		{\r\n" + 
    				"			\"field_name\": \"user_sex\",\r\n" + 
    				"			\"field_desc\": \"用户的性别\"\r\n" + 
    				"		},\r\n" + 
    				"		{\r\n" + 
    				"			\"field_name\": \"user_phone\",\r\n" + 
    				"			\"field_desc\": \"用户的手机号\"\r\n" + 
    				"		},\r\n" + 
    				"		{\r\n" + 
    				"			\"field_name\": \"user_address\",\r\n" + 
    				"			\"field_desc\": \"用户的住址\"\r\n" + 
    				"		},\r\n" + 
    				"		{\r\n" + 
    				"			\"field_name\": \"user_idenfy\",\r\n" + 
    				"			\"field_desc\": \"用户的身份\"\r\n" + 
    				"		}\r\n" + 
    				"	],\r\n" + 
    				"	\"datas\": [\r\n" + 
    				"\r\n" + 
    				"		[{\r\n" + 
    				"				\"field_name\": \"user_name\",\r\n" + 
    				"				\"field_value\": \"赵云\"\r\n" + 
    				"			},\r\n" + 
    				"			{\r\n" + 
    				"				\"field_name\": \"user_sex\",\r\n" + 
    				"				\"field_value\": \"男\"\r\n" + 
    				"			}, {\r\n" + 
    				"				\"field_name\": \"user_phone\",\r\n" + 
    				"				\"field_value\": \"1304985769\"\r\n" + 
    				"			}, {\r\n" + 
    				"				\"field_name\": \"user_address\",\r\n" + 
    				"				\"field_value\": \"中国深圳\"\r\n" + 
    				"			}, {\r\n" + 
    				"				\"field_name\": \"user_idenfy\",\r\n" + 
    				"				\"field_value\": \"总经理\"\r\n" + 
    				"			}\r\n" + 
    				"		],\r\n" + 
    				"		[{\r\n" + 
    				"				\"field_name\": \"user_name\",\r\n" + 
    				"				\"field_value\": \"张飞\"\r\n" + 
    				"			},\r\n" + 
    				"			{\r\n" + 
    				"				\"field_name\": \"user_sex\",\r\n" + 
    				"				\"field_value\": \"男\"\r\n" + 
    				"			}, {\r\n" + 
    				"				\"field_name\": \"user_phone\",\r\n" + 
    				"				\"field_value\": \"1304985769\"\r\n" + 
    				"			}, {\r\n" + 
    				"				\"field_name\": \"user_address\",\r\n" + 
    				"				\"field_value\": \"中国深圳\"\r\n" + 
    				"			}, {\r\n" + 
    				"				\"field_name\": \"user_idenfy\",\r\n" + 
    				"				\"field_value\": \"总经理\"\r\n" + 
    				"			}\r\n" + 
    				"		]\r\n" + 
    				"	],\r\n" + 
    				"	\"services\":[{\r\n" + 
    				"				\"service_point_id\":\"001\",\r\n" + 
    				"				\"service_name\":\"测量血脂\",\r\n" + 
    				"				\"flow_batch_id\":\"1\",\r\n" + 
    				"				\"type\":\"1\"\r\n" + 
    				"	},\r\n" + 
    				"	{\r\n" + 
    				"				\"service_point_id\":\"002\",\r\n" + 
    				"				\"service_name\":\"测量血糖\",\r\n" + 
    				"				\"flow_batch_id\":\"1\",\r\n" + 
    				"				\"type\":\"1\"\r\n" + 
    				"	},\r\n" + 
    				"	{\r\n" + 
    				"				\"service_point_id\":\"003\",\r\n" + 
    				"				\"service_name\":\"测量其他\",\r\n" + 
    				"				\"flow_batch_id\":\"1\",\r\n" + 
    				"				\"type\":\"1\"\r\n" + 
    				"	}]\r\n" + 
    				"}";
    	}
    	System.out.println(str);
		return str;
    }
    
    @RequestMapping(value="/form_show",method=RequestMethod.GET,produces="application/json")
    public String form_show(@Param("userId") String userId,@Param("flowNo")String flowNo,@Param("flowPointId")String flowPointId,@Param("showType")String showType,
    					@Param("id")String id, @Param("servicePointId")Integer servicePointId) throws Exception {
    	String str = null;
    	if (userId == null || flowNo == null || flowPointId == null || showType == null || id == null || servicePointId ==null) {
    		throw new Exception("请输入查询参数");
    	}
    	if (userId.equals("1") && flowNo.equals("0001") && flowPointId.equals("0001") && showType.equals("1") && id.equals("1") && servicePointId.equals(1)) {
    		str = "{\r\n" + 
    				"  \"err_code\" : \"0000\",\r\n" + 
    				"  \"err_msg\" : \"\",\r\n" + 
    				"  \"b_id\":\"1\",\r\n" + 
    				"  \"flow_no\" : \"0001\",\r\n" + 
    				"  \"flow_point_id\":\"0001\",\r\n" + 
    				"  \"service_point_id\":\"01\",\r\n" + 
    				"  \"field_list\": [{\r\n" + 
    				"      \"field_name\": \"user_name\",\r\n" + 
    				"      \"field_desc\": \"用户姓名\",\r\n" + 
    				"      \"field_value\": \"\",\r\n" + 
    				"      \"field_size\": 20,\r\n" + 
    				"      \"field_type\": \"C0\",\r\n" + 
    				"      \"type\": \"TEXT\",\r\n" + 
    				"      \"check_rule\": \"this.user_name!=''\",\r\n" + 
    				"      \"check_tip\": \"用户姓名不能为空！\",\r\n" + 
    				"	  \"is_show\":\"N\"\r\n" + 
    				"    },\r\n" + 
    				"    {\r\n" + 
    				"      \"field_name\": \"user_phone\",\r\n" + 
    				"      \"field_desc\": \"手机号码\",\r\n" + 
    				"      \"field_value\": \"\",\r\n" + 
    				"      \"field_size\": 18,\r\n" + 
    				"      \"field_type\": \"D0\",\r\n" + 
    				"      \"type\": \"TEXT\",\r\n" + 
    				"      \"check_rule\": \"this.user_phone!=''\",\r\n" + 
    				"      \"check_tip\": \"手机号码不能为空！\",\r\n" + 
    				"	  \"is_show\":\"Y\"\r\n" + 
    				"    },\r\n" + 
    				"    {\r\n" + 
    				"      \"field_name\": \"user_sex\",\r\n" + 
    				"      \"field_desc\": \"性别\",\r\n" + 
    				"      \"field_value\": \"F\",\r\n" + 
    				"      \"field_type\": \"C0\",\r\n" + 
    				"      \"type\": \"RADIO\",\r\n" + 
    				"      \"code_value\": [{\r\n" + 
    				"        \"code_no\": \"F\",\r\n" + 
    				"        \"code_val\": \"女\"\r\n" + 
    				"      }, {\r\n" + 
    				"        \"code_no\": \"M\",\r\n" + 
    				"        \"code_val\": \"男\"\r\n" + 
    				"      }],\r\n" + 
    				"      \"check_rule\": \"this.user_sex!=''\",\r\n" + 
    				"      \"check_tip\": \"性别不能为空！\"\r\n" + 
    				"    }\r\n" + 
    				"  ]\r\n" + 
    				"}";
    	}
    	if (userId.equals("2") && flowNo.equals("0002") && flowPointId.equals("0002") && showType.equals("2") && id.equals("2") && servicePointId.equals(2)) {
    		str = "{\r\n" + 
    				"  \"err_code\" : \"0000\",\r\n" + 
    				"  \"err_msg\" : \"\",\r\n" + 
    				"  \"b_id\":\"1\",\r\n" + 
    				"  \"flow_no\" : \"0001\",\r\n" + 
    				"  \"flow_point_id\":\"0001\",\r\n" + 
    				"  \"service_point_id\":\"01\",\r\n" + 
    				"  \"field_list\": [{\r\n" + 
    				"      \"field_name\": \"user_name\",\r\n" + 
    				"      \"field_desc\": \"用户姓名\",\r\n" + 
    				"      \"field_value\": \"\",\r\n" + 
    				"      \"field_size\": 20,\r\n" + 
    				"      \"field_type\": \"C0\",\r\n" + 
    				"      \"type\": \"TEXT\",\r\n" + 
    				"      \"check_rule\": \"this.user_name!=''\",\r\n" + 
    				"      \"check_tip\": \"用户姓名不为空！\",\r\n" + 
    				"	  \"is_show\":\"N\"\r\n" + 
    				"    },\r\n" + 
    				"    {\r\n" + 
    				"      \"field_name\": \"user_phone\",\r\n" + 
    				"      \"field_desc\": \"手机号\",\r\n" + 
    				"      \"field_value\": \"\",\r\n" + 
    				"      \"field_size\": 18,\r\n" + 
    				"      \"field_type\": \"D0\",\r\n" + 
    				"      \"type\": \"TEXT\",\r\n" + 
    				"      \"check_rule\": \"this.user_phone!=''\",\r\n" + 
    				"      \"check_tip\": \"手机号不能为空！\",\r\n" + 
    				"	  \"is_show\":\"Y\"\r\n" + 
    				"    },\r\n" + 
    				"    {\r\n" + 
    				"      \"field_name\": \"user_sex\",\r\n" + 
    				"      \"field_desc\": \"性别\",\r\n" + 
    				"      \"field_value\": \"F\",\r\n" + 
    				"      \"field_type\": \"C0\",\r\n" + 
    				"      \"type\": \"RADIO\",\r\n" + 
    				"      \"code_value\": [{\r\n" + 
    				"        \"code_no\": \"F\",\r\n" + 
    				"        \"code_val\": \"女女女\"\r\n" + 
    				"      }, {\r\n" + 
    				"        \"code_no\": \"M\",\r\n" + 
    				"        \"code_val\": \"男男男\"\r\n" + 
    				"      }],\r\n" + 
    				"      \"check_rule\": \"this.user_sex!=''\",\r\n" + 
    				"      \"check_tip\": \"性别不为空！\"\r\n" + 
    				"    }\r\n" + 
    				"  ]\r\n" + 
    				"}";
    	}
    	System.out.println(str);
		return str;
    }
}
