/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : pudge

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2015-04-19 20:21:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bike_area
-- ----------------------------
DROP TABLE IF EXISTS `bike_area`;
CREATE TABLE `bike_area` (
  `bike_area_uid` varchar(64) COLLATE utf8_bin NOT NULL,
  `bike_area_no` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `bike_area_name` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `area_rent_num` int(11) DEFAULT NULL,
  `area_return_num` int(11) DEFAULT NULL,
  `service_time` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `area_on_duty` int(1) DEFAULT NULL,
  `area_location` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `service_phone` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `other_service` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `area_longitude` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `area_latitude` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `remark` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`bike_area_uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of bike_area
-- ----------------------------

-- ----------------------------
-- Table structure for bike_area_log
-- ----------------------------
DROP TABLE IF EXISTS `bike_area_log`;
CREATE TABLE `bike_area_log` (
  `bike_area_log_id` varchar(64) COLLATE utf8_bin NOT NULL,
  `bike_area_nos` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `bike_area_names` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `area_rent_nums` int(11) DEFAULT NULL,
  `area_return_nums` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`bike_area_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of bike_area_log
-- ----------------------------
