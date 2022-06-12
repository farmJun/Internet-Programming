package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.domain.User;

@Mapper
public interface UserMapper {

	/*
	 * private String studentName;
	 * 
	 * private int studentNumber;
	 * 
	 * private String phoneNumber;
	 * 
	 * private String emailAddress;
	 */
	
	@Select("select * from user")
	@Results({
		@Result(property = "id", column="id",javaType = Long.class),
        @Result(property = "studentName", column="student_name",javaType = String.class),
        @Result(property = "studentNumber", column = "student_number",javaType = Integer.class),
        @Result(property = "phoneNumber", column = "phone_number",javaType = String.class),
        @Result(property = "emailAddress", column = "email_address",javaType = String.class)
	})
	public List<User> findAll();
	
	@Select("select * from user where id = #{id}")
	@Results({
		@Result(property = "id", column="id",javaType = Long.class),
        @Result(property = "studentName", column="student_name",javaType = String.class),
        @Result(property = "studentNumber", column = "student_number",javaType = Integer.class),
        @Result(property = "phoneNumber", column = "phone_number",javaType = String.class),
        @Result(property = "emailAddress", column = "email_address",javaType = String.class)
	})
	public User findUserById(long id);
	   
	
	@Insert("INSERT INTO user(student_name, student_number, phone_number, email_address) VALUES "
			+ "(#{studentName},#{studentNumber},#{phoneNumber}, #{emailAddress})")
	public void save(User user) ;
	
	
	
	@Update("update user set student_name=#{studentName, jdbcType=CHAR}," 
			+ "student_number=#{studentNumber, jdbcType=CHAR},"
			+ "phone_number=#{phoneNumber, jdbcType=BIGINT}, "
			+ "email_address=#{emailAddress, jdbcType=CHAR}"
			+ "where id=#{id}")
	public void edit(User user);
	
	
	@Delete("DELETE FROM user WHERE id = #{id}")
	public void delete(long id);

}
