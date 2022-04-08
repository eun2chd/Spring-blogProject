package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// ORM -> Java(다른언어) Object -> 테이블로 매핑해줌

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity // User 클래스가 Mysql에 테이블이 생성된다.
// @DynamicInsert // 필드가 null 인 컬럼은 제외시키고 insert 한다.
public class User {
	
	@Id // Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 너버링 전략을 따라감.
	private int id; // 시퀀스, auto-increment
	
	@Column(nullable = false, length = 30)
	private String username;
	
	@Column(nullable = false, length = 100) // -> 비밀번호 암호화때문에 길이 넉넉하게(해쉬)
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
//	@ColumnDefault("'user'")
//  DB는 RoleType 이 없다.
	@Enumerated(EnumType.STRING)
	private RoleType role; // Enum 을 쓰는게 좋다. (주어진 범위 내에서 지정가능 ex : 남,여, / admin,user,manger,
	
	@CreationTimestamp // 시간이 자동입력됨
	private Timestamp createDate;	
}
