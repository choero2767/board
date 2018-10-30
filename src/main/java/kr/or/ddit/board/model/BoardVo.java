package kr.or.ddit.board.model;

import java.util.Date;

public class BoardVo {
	
	private int boardCode; // 게시판 아이디
	private String userId; // 게시판 등록자
	private String boardName; // 게시판 이름
	private int boardAvailable; // 게시판 사용여부
	private Date boardDate; // 게시판 등록일시
	
	public int getBoardCode() {
		return boardCode;
	}
	public void setBoardCode(int boardCode) {
		this.boardCode = boardCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public int getBoardAvailable() {
		return boardAvailable;
	}
	public void setBoardAvailable(int boardAvailable) {
		this.boardAvailable = boardAvailable;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	
	@Override
	public String toString() {
		return "BoardVo [boardCode=" + boardCode + ", userId=" + userId
				+ ", boardName=" + boardName + ", boardAvailable="
				+ boardAvailable + ", boardDate=" + boardDate + "]";
	}
	
	
	
}
