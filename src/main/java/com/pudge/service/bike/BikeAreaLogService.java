package com.pudge.service.bike;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pudge.dao.bike.BikeAreaLogMapper;
import com.pudge.entity.bike.BikeAreaLog;

@Service
public class BikeAreaLogService {

	@Autowired
	private BikeAreaLogMapper bikeAreaLogMapper;
	
	public List<BikeAreaLog> getBikeAreaLog(BikeAreaLog bikeAreaLog) {
		return bikeAreaLogMapper.getBikeAreaLogList(bikeAreaLog);
	}
	
	public int insertBikeAreaLog(BikeAreaLog bikeAreaLog){
		return bikeAreaLogMapper.insertBikeAreaLog(bikeAreaLog);
	}

}
