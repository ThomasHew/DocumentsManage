/**
 * 
 */
package cn.edu.sicau.thomas.pojo;

/**
 * @author Thomas
 *
 */
public class Serach {
	private String fileName;
	private String groupName;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	@Override
	public String toString() {
		return "Serach [fileName=" + fileName + ", groupName=" + groupName + "]";
	}
	
	
}
