/**
 * 
 */
package cn.edu.sicau.thomas.pojo;

/**
 * @author Thomas
 *
 */
public class QueryBean {
	
	private String fileName;
	private String groupName;
	
	private Integer pageSize = 10;
	private Integer currentRow;
	private String currentPage = "1";
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
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getCurrentRow() {
		return currentRow;
	}
	public void setCurrentRow(Integer currentRow) {
		this.currentRow = currentRow;
	}
	public String getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	
	

}
