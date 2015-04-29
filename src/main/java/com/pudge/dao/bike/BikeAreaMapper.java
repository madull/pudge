package com.pudge.dao.bike;

import com.pudge.dao.SqlMapper;
import com.pudge.entity.bike.BikeArea;

import java.util.List;

import org.springframework.dao.DataAccessException;


public interface BikeAreaMapper extends SqlMapper{

	
	public int getBikeAreaCount(BikeArea bikeArea)throws DataAccessException;;
	
	public List<BikeArea> getBikeAreaList(BikeArea bikeArea)throws DataAccessException;;
	
	public BikeArea getBikeArea(BikeArea bikeArea)throws DataAccessException;;
	
    public int insertBikeArea(BikeArea bikeArea)throws DataAccessException;;
	
	public int updateBikeArea(BikeArea bikeArea)throws DataAccessException;;
	
	public int deleteBikeArea(String id)throws DataAccessException;;
	
	
	
}