/**
 * 
 */
package cn.edu.sicau.thomas.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sicau.thomas.Utils.Page;
import cn.edu.sicau.thomas.mapper.FilesMapper;
import cn.edu.sicau.thomas.pojo.FileInfor;
import cn.edu.sicau.thomas.pojo.Files;
import cn.edu.sicau.thomas.pojo.QueryBean;
import cn.edu.sicau.thomas.service.FilesService;

/**
 * @author Thomas
 *
 */
@Service
public class FilesServiceImp implements FilesService {

	@Autowired
	private FilesMapper filesMapper;
	@Override
	//添加文件
	public int insertFiles(Files files) {
		return filesMapper.insertFiles(files);
	}
	/*//查询总记录数
		@Override
	public int totalCount() {
		
		return filesMapper.totalCount();
	}*/
	
	//分页操作
	/*@Override
	public Page<FileInfor> findFilesPage(int pageSize, int currentPage) {
		System.out.println(pageSize+""+currentPage);
		int totalCount = filesMapper.totalCount();
		System.out.println(totalCount);
		int totalPage = (int) Math.ceil(totalCount*1.0/pageSize);
		System.out.println(totalPage);
		  int currentRow =  (currentPage-1)*pageSize;
		  System.out.println(currentRow);
		//获得分页文件信息
		 List<FileInfor> fileInfors = filesMapper.findFilesPage(pageSize, currentRow);
		for (FileInfor fileInfor : fileInfors) {
			System.out.println(fileInfor);
		}
	
		//封装page对象
		Page<FileInfor> page = new Page<>();
		page.setCurrentPage(currentPage);
		page.setFileInfors(fileInfors);
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setTotalPageCount(totalPage);
		return page;
	}*/
	
	@Override
	public List<String> findGroupName() {
		
		return filesMapper.findGroupName();
	}

	@Override
	public Page<FileInfor> findFilesPage(QueryBean queryBean) {
		//计算分页数开始
		queryBean.setCurrentRow((Integer.parseInt(queryBean.getCurrentPage())-1)*queryBean.getPageSize());
		System.out.println(queryBean.getGroupName());
		//总记录数
		Integer totalCount = filesMapper.totalCount(queryBean);
		//总页数
		int totalPage = (int) Math.ceil(totalCount*1.0/queryBean.getPageSize());
		System.out.println(totalPage);
		// 查询每页数据列表
		List<FileInfor> fileInfors = filesMapper.findFilesPage(queryBean);
		//封装page
		Page<FileInfor> page = new Page<>(totalCount,Integer.parseInt(queryBean.getCurrentPage()),queryBean.getPageSize(),totalPage,fileInfors);
		
		return page;
	}
	
	//根据id查找 文件
	@Override
	public FileInfor getFileInfoById(Integer id) {
	
		return filesMapper.getFileInfoById(id);
	}
	 
	@Override
	public int updateFileInfo(Files files) {
		
		return filesMapper.updateFileInfo(files);
	}
	//删除文件信息
	@Override
	public int deleteFileInfo(Integer id) {
		
		return filesMapper.deleteFileInfo(id);
	}

	//更新浏览数
	@Override
	public int updatePageView(Integer id) {
	
		return 	filesMapper.updatePageView(id);
	}

	
	
	
	

	

}
