/**
 * 
 */
package cn.edu.sicau.thomas.pojo;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author Thomas
 *
 */
public class FileInfor {
	private Integer id;
	private String fileDescription;
	private String groupName;
	private String fileName;
	private String uploadIp;
	private String uploadUserName;
	private Date uploadTime;
	private Timestamp updateTime;
	private Integer pageView;
	@Override
	public String toString() {
		return "FileInfor [groupName=" + groupName + ", fileName=" + fileName + ", uploadIp=" + uploadIp
				+ ", uploadUserName=" + uploadUserName + ", uploadTime=" + uploadTime + ", updateTime=" + updateTime
				+ "]";
	}
	public Integer getPageView() {
		return pageView;
	}
	public void setPageView(Integer pageView) {
		this.pageView = pageView;
	}
	public String getFileDescription() {
		return fileDescription;
	}
	public void setFileDescription(String fileDescription) {
		this.fileDescription = fileDescription;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUploadIp() {
		return uploadIp;
	}
	public void setUploadIp(String uploadIp) {
		this.uploadIp = uploadIp;
	}
	public String getUploadUserName() {
		return uploadUserName;
	}
	public void setUploadUserName(String uploadUserName) {
		this.uploadUserName = uploadUserName;
	}
	public Date getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	
}
