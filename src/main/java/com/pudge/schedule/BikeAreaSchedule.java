package com.pudge.schedule;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;

import com.pudge.service.bike.BikeAreaService;

/**
*
*----------Dragon be here!----------/
* 　　　┏┓　　　┏┓
* 　　┏┛┻━━━┛┻┓
* 　　┃　　　　　　　┃
* 　　┃　　　━　　　┃
* 　　┃　┳┛　┗┳　┃
* 　　┃　　　　　　　┃
* 　　┃　　　┻　　　┃
* 　　┃　　　　　　　┃
* 　　┗━┓　　　┏━┛
* 　　　　┃　　　┃神兽保佑
* 　　　　┃　　　┃代码无BUG！
* 　　　　┃　　　┗━━━┓
* 　　　　┃　　　　　　　┣┓
* 　　　　┃　　　　　　　┏┛
* 　　　　┗┓┓┏━┳┓┏┛
* 　　　　　┃┫┫　┃┫┫
* 　　　　　┗┻┛　┗┻┛
* ━━━━━━神兽出没━━━━━━
*/


/**
                  _ooOoo_
                 o8888888o
                 88" . "88
                 (| -_- |)
                 O\  =  /O
              ____/`---'\____
            .'  \\|     |//  `.
           /  \\|||  :  |||//  \
          /  _||||| -:- |||||-  \
          |   | \\\  -  /// |   |
          | \_|  ''\---/''  |   |
          \  .-\__  `-`  ___/-. /
        ___`. .'  /--.--\  `. . __
     ."" '<  `.___\_<|>_/___.'  >'"".
    | | :  ` - `.;`\ _ /`;.`/ - ` : | |
    \  \ `-.   \_ __\ /__ _/   .-` /  /
======`-.____`-.___\_____/___.-`____.-'======
                  `=---='
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
           佛祖保佑       永无BUG
**/

public class BikeAreaSchedule {
	
	@Autowired
	private BikeAreaService bikeAreaService; 
	
	@Autowired
	private TaskExecutor taskExecutor;
	
	private static final int total = 263;//总页数
	
	private static final int pagesize = 15;//单线程
	
	private static final int totalThread = total/pagesize+1;
	
	private static int page;
	
	public boolean execute(){
		
		
		final HashMap<String, String> paramMap = new HashMap<String,String>();
		
		for (int i = 1; i <=totalThread; i++) {
			page = i;
			final int pageEndRow;
			final int pageStartRow;
	        if (page * pagesize < total) {// 判断是否为最后一页
	        	pageEndRow = page * pagesize;
	        	pageStartRow = pageEndRow - pagesize;
	        } else {
	        	pageEndRow = total;
	        	pageStartRow = pagesize * (totalThread - 1);
	        }
	        System.out.println("start@@@"+pageStartRow+"###end:"+pageEndRow);
	        taskExecutor.execute(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						bikeAreaService.getBikeAreas(paramMap,pageStartRow, pageEndRow);
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
		return false;
	}

}
