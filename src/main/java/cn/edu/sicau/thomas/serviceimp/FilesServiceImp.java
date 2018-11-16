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
	//����ļ�
	public int insertFiles(Files files) {
		return filesMapper.insertFiles(files);
	}
	/*//��ѯ�ܼ�¼��
		@Override
	public int totalCount() {
		
		return filesMapper.totalCount();
	}*/
	
	//��ҳ����
	/*@Override
	public Page<FileInfor> findFilesPage(int pageSize, int currentPage) {
		System.out.println(pageSize+""+currentPage);
		int totalCount = filesMapper.totalCount();
		System.out.println(totalCount);
		int totalPage = (int) Math.ceil(totalCount*1.0/pageSize);
		System.out.println(totalPage);
		  int currentRow =  (currentPage-1)*pageSize;
		  System.out.println(currentRow);
		//��÷�ҳ�ļ���Ϣ
		 List<FileInfor> fileInfors = filesMapper.findFilesPage(pageSize, currentRow);
		for (FileInfor fileInfor : fileInfors) {
			System.out.println(fileInfor);
		}
	
		//��װpage����
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
		//�����ҳ����ʼ
		queryBean.setCurrentRow((Integer.parseInt(queryBean.getCurrentPage())-1)*queryBean.getPageSize());
		System.out.println(queryBean.getGroupName());
		//�ܼ�¼��
		Integer totalCount = filesMapper.totalCount(queryBean);
		//��ҳ��
		int totalPage = (int) Math.ceil(totalCount*1.0/queryBean.getPageSize());
		System.out.println(totalPage);
		// ��ѯÿҳ�����б�
		List<FileInfor> fileInfors = filesMapper.findFilesPage(queryBean);
		//��װpage
		Page<FileInfor> page = new Page<>(totalCount,Integer.parseInt(queryBean.getCurrentPage()),queryBean.getPageSize(),totalPage,fileInfors);
		
		return page;
	}
	
	//����id���� �ļ�
	@Override
	public FileInfor getFileInfoById(Integer id) {
	
		return filesMapper.getFileInfoById(id);
	}
	 
	@Override
	public int updateFileInfo(Files files) {
		
		return filesMapper.updateFileInfo(files);
	}
	//ɾ���ļ���Ϣ
	@Override
	public int deleteFileInfo(Integer id) {
		
		return filesMapper.deleteFileInfo(id);
	}

	//���������
	@Override
	public int updatePageView(Integer id) {
	
		return 	filesMapper.updatePageView(id);
	}

	
	
	
	

	

}
