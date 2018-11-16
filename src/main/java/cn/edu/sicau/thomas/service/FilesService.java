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
	//�ϴ��ļ�
	int insertFiles(Files files);
	
	/*//��ҳ
	Page<FileInfor> findFilesPage(int pageSize, int currentRow);*/
	//��ѯС����
		List<String> findGroupName();
		//����������ѯ����ҳ�ļ���Ϣ
	Page<FileInfor>  findFilesPage(QueryBean queryBean);
	////����id����ļ���Ϣ
	FileInfor getFileInfoById(Integer id);
	//�����ļ���Ϣ
		int updateFileInfo(Files files);
		//ɾ���ļ���Ϣ
		int deleteFileInfo(Integer id);
		//�����ļ������
		int updatePageView(Integer id);
}
