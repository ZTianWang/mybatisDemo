package com.wnwn.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wnwn.po.UserInfo;

public interface UserInfoMapper {
	
	/**
	 * 查询记录
	 * 接口方法名必须与userinfo.xml中的<select>的id一致!!!
	 * 形参类型必须与映射文件中的<select>的parameterType一致!!!
	 * @param user 查询条件
	 * @return
	 */
	public List<UserInfo> selectUser(UserInfo user);

	/*通过id查询*/
	public UserInfo selectOneUser(Integer userId);
	
	/*添加记录
	 * 返回执行行数*/
	public int addUser(UserInfo user);
	
	/*修改记录*/
	public int updateUser(UserInfo user);
	
	/*删除记录*/
	public int deleteUser(Integer userId);
	
	/*动态sql查询*/
	public List<UserInfo> selectUserDynamic(UserInfo user);
	
	public List<UserInfo> selectUserDynamic1(UserInfo user);
	
	public List<UserInfo> selectUserDynamic2(UserInfo user);
	
	/*迭代查询 (foreach元素)*/
	public List<UserInfo> selectByIdList(UserInfo user);
	
	/*动态修改*/
	public int updateUserDynamic(UserInfo user);
	
	
	/**
	 * 多种类型参数传递方式
	 */
	/*通过常量传递
	 * 传递多个参数必须使用@param与#{}中的值向对应*/
	public List<UserInfo> selectUserByConstant(@Param("userName")String userName,@Param("userSex")String userSex);
	
	/*通过实体传递*/
	public List<UserInfo> selectUserByEntity(UserInfo user);
	
	/*通过map传递*/
	public List<UserInfo> selectUserByMap(Map<String, Object> map);
	
}
