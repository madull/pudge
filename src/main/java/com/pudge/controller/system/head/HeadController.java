package com.pudge.controller.system.head;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pudge.base.BaseController;



@Controller
@RequestMapping(value="/head")
public class HeadController extends BaseController {
	
	/**
	 * 获取头部信息
	 */
	@RequestMapping(value="/getUname")
	@ResponseBody
	public Object getList() {
		String a ="{list=[{PHONE=18788888888, LAST_LOGIN=2015-04-20 14:47:46, NAME=系统管理员, RIGHTS=1133671055321055258374707980945218933803269864762743594642571294, USER_ID=1, IP=0:0:0:0:0:0:0:1, EMAIL=admin@main.com, USERNAME=admin, STATUS=0, PASSWORD=de41b7fb99201d8334c23c014db35ecd92df81bc, SKIN=default, BZ=最高统治者, ROLE_ID=1, NUMBER=001}]}";
		return a;
	}

	
}
