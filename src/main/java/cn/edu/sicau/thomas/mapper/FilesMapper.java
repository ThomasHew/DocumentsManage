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
	//���ļ���Ϣд�����ݿ�
	int insertFiles(Files files);
	
	//��ѯ�ܼ�¼��
	int  totalCount(QueryBean queryBean);
	//����ҳ���ҳ��Ϣ��ѯ
	//List<FileInfor>  findFilesPage(@Param("pageSize") int pageSize,@Param("currentRow") int currentRow);
	//��ѯС����
	List<String> findGroupName();
	//����������ѯ����ҳ�ļ���Ϣ
	List<FileInfor>  findFilesPage(QueryBean queryBean);
	//����id����ļ���Ϣ
	FileInfor getFileInfoById(Integer id);
	//�����ļ���Ϣ
	int updateFileInfo(Files files);
	//ɾ���ļ���Ϣ
	int deleteFileInfo(Integer id);
	//�����ļ������
	int updatePageView(Integer id);
}
