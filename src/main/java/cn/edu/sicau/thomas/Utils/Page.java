/**
 * 
 */
package cn.edu.sicau.thomas.Utils;

import java.util.List;

import cn.edu.sicau.thomas.pojo.FileInfor;

/**
 * @author Thomas
 *
 */
public class Page<T> {
	//总记录数
	private int totalCount;
	//当前页码
	private int currentPage;
	//每页显示条数
	private int pageSize;
	//总页数
	private int totalPageCount;
	
	
	/**
	 * @param totalCount
	 * @param currentPage
	 * @param pageSize
	 * @param totalPageCount
	 * @param fileInfors
	 */
	public Page(int totalCount, int currentPage, int pageSize, int totalPageCount, List<FileInfor> fileInfors) {
		super();
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalPageCount = totalPageCount;
		this.fileInfors = fileInfors;
	}
	private List<FileInfor> fileInfors;
	public int getTotalCount() {
		return totalCount;
	}
	public List<FileInfor> getFileInfors() {
		return fileInfors;
	}
	public void setFileInfors(List<FileInfor> fileInfors) {
		this.fileInfors = fileInfors;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	
	

}
