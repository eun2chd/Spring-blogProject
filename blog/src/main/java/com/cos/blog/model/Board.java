package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	  
	@Lob // 대용량 데이터 사용할때ㅑ 사용
	private String content; // 섬머노트 라이브러리 <html> 태그가 섞여서 디자인 된다.
	
	@ColumnDefault("0")
	private int count; // 조회수
	
	// Many = Board, User = One
	// Board 테이블의 userId 컬럼은 User 테이블의 Id를 참조하고 있다.!
	@ManyToOne(fetch = FetchType.EAGER) // Many = Many, User = one / 한명의 유저는 여러개의 게시글을 적을 수 있다.
	@JoinColumn(name = "userId")
	private User user; // DB는 오브젝트를 저장불가, FK, 자바는 오브젝트를 저장가능
	
	// Board 를 select 할때 reply 를 join 해서 값을 얻을려고 선언
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER) // mappedBy 연관관계 주인이 아니다. (난 FK 키가 아니에요) DB에 컬럼을 만들지 마세요
	private List<Reply> reply;

	@CreationTimestamp
	private Timestamp createDate;
	
	
}
