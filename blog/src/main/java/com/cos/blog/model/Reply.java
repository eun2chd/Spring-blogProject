package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Reply {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 200)
	private String content;
	
	@ManyToOne // 하나의 게시글에는 여러개의 답변을 달수 있어야 한다.
	@JoinColumn(name = "boardId")
	private Board board;
	
	// Reply 테이블의 userId 컬럼은 User 테이블의 Id 를 참조하고 있다.
	@ManyToOne // 하나의 유저는 여러개의 답변을 달수 있다.
	@JoinColumn(name = "userId")
	private User user;
	
	@CreationTimestamp
	private Timestamp createDate;
	
}
