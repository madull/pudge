package com.pudge.util;

import java.util.HashMap;
import java.util.Map;

public class ResultUtils {
	public static final int RESULT_CODE_SUCCESS = 0;
	public static final int RESULT_CODE_FAIL = -1;

	/**
	 * @return {"resultCode" : resultCode , itemKey : item}
	 */
	public static Map<String, Object> success(int resultCode, String itemKey, Object item) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("resultCode", resultCode);
		map.put(itemKey, item);
		return map;
	}

	/**
	 * @return {"resultCode" : "0" , itemKey : item}
	 */
	public static Map<String, Object> success(String itemKey, Object item) {
		return success(RESULT_CODE_SUCCESS, itemKey, item);
	}

	/**
	 * @return {"resultCode" : resultCode}
	 */
	public static Map<String, Object> success(int resultCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("resultCode", resultCode);
		return map;
	}

	/**
	 * @return {"resultCode" : "0"}
	 */
	public static Map<String, Object> success() {
		return success(RESULT_CODE_SUCCESS);
	}

	/**
	 * @return {"resultCode" : resultCode , "errMsg" : message}
	 */
	public static Map<String, Object> fail(String resultCode, String message) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("resultCode", resultCode);
		map.put("errMsg", message);
		return map;
	}

	/**
	 * @return {"resultCode" : "1" , "errMsg" : message}
	 */
	public static Map<String, Object> fail(String message) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("resultCode", RESULT_CODE_FAIL);
		map.put("errMsg", message);
		return map;
	}
}
