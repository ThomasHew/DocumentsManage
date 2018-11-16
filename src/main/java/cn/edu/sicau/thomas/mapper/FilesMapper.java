/**
 * 
 */
package cn.edu.sicau.thomas.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import cn.edu.sicau.thomas.pojo.FileInfor;
import cn.edu.sicau.thomas.pojo.Files;
import cn.edu.sicau.thomas.pojo.QueryBean;

/**
 * @author Thomas
 *
 */
public interface FilesMapper {
	//将文件信息写入数据库
	int insertFiles(Files files);
	
	//查询总记录数
	int  totalCount(QueryBean queryBean);
	//根据页面分页信息查询
	//List<FileInfor>  findFilesPage(@Param("pageSize") int pageSize,@Param("currentRow") int currentRow);
	//查询小组名
	List<String> findGroupName();
	//根据搜索查询并分页文件信息
	List<FileInfor>  findFilesPage(QueryBean queryBean);
	//根据id获得文件信息
	FileInfor getFileInfoById(Integer id);
	//更新文件信息
	int updateFileInfo(Files files);
	//删除文件信息
	int deleteFileInfo(Integer id);
	//更新文件浏览数
	int updatePageView(Integer id);
}
