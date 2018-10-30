package kr.or.ddit.post.model;

import java.util.Date;

public class PostVo {
	private int rnum;
	private int postCode; // 게시글 번호
	private int boardCode; // 게시판 Id
	private int postRefer; // 부모 게시글
	private String userId; // 작성자 회원
	private String postName; // 게시글 제목
	private String postCon; // 게시글 내용
	private int postAvailable; // 게시글 사용여부
	private Date postDate;
	private String postSeq;
	
	
	public PostVo() {
	}
	
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getPostCode() {
		return postCode;
	}
	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}
	public int getBoardCode() {
		return boardCode;
	}
	public void setBoardCode(int boardCode) {
		this.boardCode = boardCode;
	}
	public int getPostRefer() {
		return postRefer;
	}
	public void setPostRefer(int postRefer) {
		this.postRefer = postRefer;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public String getPostCon() {
		return postCon;
	}
	public void setPostCon(String postCon) {
		this.postCon = postCon;
	}
	public int getPostAvailable() {
		return postAvailable;
	}
	public void setPostAvailable(int postAvailable) {
		this.postAvailable = postAvailable;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public String getPostSeq() {
		return postSeq;
	}
	public void setPostSeq(String postSeq) {
		this.postSeq = postSeq;
	}
	
	
	@Override
	public String toString() {
		return "PostVo [rnum=" + rnum + ", postCode=" + postCode
				+ ", boardCode=" + boardCode + ", postRefer=" + postRefer
				+ ", userId=" + userId + ", postName=" + postName
				+ ", postCon=" + postCon + ", postAvailable=" + postAvailable
				+ ", postDate=" + postDate + ", postSeq=" + postSeq + "]";
	}
	
}
