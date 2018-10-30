package kr.or.ddit.file.model;

public class FileVo {
	
	private Integer fileCode;
	private Integer postCode;
	private Integer fileAvailable;
	private String fileName;
	private String filePosition;
	
	public FileVo() {}
	
	public Integer getFileCode() {
		return fileCode;
	}
	public void setFileCode(Integer fileCode) {
		this.fileCode = fileCode;
	}
	public Integer getPostCode() {
		return postCode;
	}
	public void setPostCode(Integer postCode) {
		this.postCode = postCode;
	}
	public Integer getFileAvailable() {
		return fileAvailable;
	}
	public void setFileAvailable(Integer fileAvailable) {
		this.fileAvailable = fileAvailable;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePosition() {
		return filePosition;
	}
	public void setFilePosition(String filePosition) {
		this.filePosition = filePosition;
	}
	
	
	@Override
	public String toString() {
		return "FileVo [fileCode=" + fileCode + ", postCode=" + postCode
				+ ", fileAvailable=" + fileAvailable + ", fileName=" + fileName
				+ ", filePosition=" + filePosition + "]";
	}
	
	
	
	
}
