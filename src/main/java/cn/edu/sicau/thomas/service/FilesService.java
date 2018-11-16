/**
 * 
 */
package cn.edu.sicau.thomas.service;

import java.util.List;

import cn.edu.sicau.thomas.Utils.Page;
import cn.edu.sicau.thomas.pojo.FileInfor;
import cn.edu.sicau.thomas.pojo.Files;
import cn.edu.sicau.thomas.pojo.QueryBean;

/**
 * @author Thomas
 *
 */
public interface FilesService {
	//上传文件
	int insertFiles(Files files);
	
	/*//分页
	Page<FileInfor> findFilesPage(int pageSize, int currentRow);*/
	//查询小组名
		List<String> findGroupName();
		//根据搜索查询并分页文件信息
	Page<FileInfor>  findFilesPage(QueryBean queryBean);
	////根据id获得文件信息
	FileInfor getFileInfoById(Integer id);
	//更新文件信息
		int updateFileInfo(Files files);
		//删除文件信息
		int deleteFileInfo(Integer id);
		//更新文件浏览数
		int updatePageView(Integer id);
}
