package com.pudge.dao.bike;

import com.pudge.dao.SqlMapper;
import com.pudge.entity.bike.BikeAreaLog;

import java.util.List;


public interface BikeAreaLogMapper extends SqlMapper{

    public int getBikeAreaLogCount(BikeAreaLog bikeAreaLog);
	
	public List<BikeAreaLog> getBikeAreaLogList(BikeAreaLog bikeAreaLog);
	
	public BikeAreaLog getBikeAreaLog(BikeAreaLog bikeAreaLog);
	
    public int insertBikeAreaLog(BikeAreaLog bikeAreaLog);
	
	public int updateBikeAreaLog(BikeAreaLog bikeAreaLog);
	
	public int deleteBikeAreaLog(String id);
}