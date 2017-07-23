package com.wnwn.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wnwn.po.UserInfo;

/**
 * 使用注解的方式操作
 * 可不用配置映射文件xml !!
 * @author apple
 */

public interface UserInfoWithAnnotateMapper {
	
	/*将查找内容放到HashMap中
	 * 不推荐*/
	@Select(value={"select * from user_info"})
	public List<HashMap> getUserHashListWA();

	@Select(value={"select * from user_info"})
	/*@Results配置结果集名称映射*/
	@Results({@Result(property="userId",column="user_id"),
		@Result(property="userName",column="user_name"),
		@Result(property="userSex",column="user_sex")
	})
	public List<UserInfo> getUserListWA();
	
	@Select("select * from user_info where user_id=#{userId} and user_name=#{userName}")
	@Results({@Result(property="userId",column="user_id"),
		@Result(property="userName",column="user_name"),
		@Result(property="userSex",column="user_sex")
	})
	/*传递多个参数必须使用@param与#{}中的值向对应*/
	public UserInfo selectOneUser(@Param("userId")Integer userId,@Param("userName")String userName);
	
	@Insert("insert into user_info (user_name,user_sex) values(#{userName},#{userSex})")
	public int addUser(UserInfo user);
	
	@Update("update user_info set user_name = #{userName},user_sex=#{userSex} where user_id = #{userId}")
	public int updateUser(UserInfo user);
	
	@Delete("delete from user_info where user_id = #{userId}")
	public int deleteUser(Integer userId);
	
}
