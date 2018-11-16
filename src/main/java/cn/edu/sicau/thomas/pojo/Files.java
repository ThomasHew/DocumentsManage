/**
 * 
 */
package cn.edu.sicau.thomas.pojo;

import java.util.Date;

/**
 * @author Thomas
 *
 */
public class Files {
	private Integer Id;
	private String fileName;
	
	private String uploadUserName;
	private String uploadIp;
	private String fileDescription;
	private Date uploadTime;
	private Integer pageView;
	public Integer getPageView() {
		return pageView;
	}
	public void setPageView(Integer pageView) {
		this.pageView = pageView;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUploadUserName() {
		return uploadUserName;
	}
	public void setUploadUserName(String uploadUserName) {
		this.uploadUserName = uploadUserName;
	}
	public String getUploadIp() {
		return uploadIp;
	}
	public void setUploadIp(String uploadIp) {
		this.uploadIp = uploadIp;
	}
	public String getFileDescription() {
		return fileDescription;
	}
	public void setFileDescription(String fileDescription) {
		this.fileDescription = fileDescription;
	}
	public Date getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}
	
	
	/**
	 * 
	 */
	public Files() {
		super();
		
	}
	/**
	 * @param fileName
	 * @param uploadUserName
	 * @param uploadIp
	 * @param fileDescription
	 * @param uploadTime
	 */
	public Files(Integer Id,String fileName, String uploadUserName, String uploadIp, String fileDescription) {
		super();
		this.Id = Id;
		this.fileName = fileName;
		this.uploadUserName = uploadUserName;
		this.uploadIp = uploadIp;
		this.fileDescription = fileDescription;
		
	}
	/**
	 * @param id
	 * @param fileName
	 * @param uploadUserName
	 * @param uploadIp
	 * @param fileDescription
	 * @param uploadTime
	 */
	public Files(Integer id, String fileName, String uploadUserName, String uploadIp, String fileDescription,
			Date uploadTime) {
		super();
		Id = id;
		this.fileName = fileName;
		this.uploadUserName = uploadUserName;
		this.uploadIp = uploadIp;
		this.fileDescription = fileDescription;
		this.uploadTime = uploadTime;
	}
	@Override
	public String toString() {
		return "Files [fileName=" + fileName + ", uploadUserName=" + uploadUserName + ", uploadIp=" + uploadIp
				+ ", fileDescription=" + fileDescription + ", uploadTime=" + uploadTime + "]";
	}
	
	

}
