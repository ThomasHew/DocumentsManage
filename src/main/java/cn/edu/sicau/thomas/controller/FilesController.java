/**
 * 
 */
package cn.edu.sicau.thomas.controller;


import static org.hamcrest.CoreMatchers.nullValue;

import java.io.File;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.junit.runners.Parameterized.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.sun.org.apache.bcel.internal.generic.NEW;

import cn.edu.sicau.thomas.Utils.GetIp;
import cn.edu.sicau.thomas.Utils.Page;
import cn.edu.sicau.thomas.pojo.FileInfor;
import cn.edu.sicau.thomas.pojo.Files;
import cn.edu.sicau.thomas.pojo.QueryBean;
import cn.edu.sicau.thomas.pojo.Serach;
import cn.edu.sicau.thomas.pojo.User;
import cn.edu.sicau.thomas.service.FilesService;
import cn.edu.sicau.thomas.service.UserService;


/**
 * @author Thomas
 *
 */
@Controller
@RequestMapping("file")
@SessionAttributes("serach")
public class FilesController {
	@Autowired
	private FilesService filesService;
	//上传文件
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	private String uploadFile(HttpServletRequest request, @RequestParam("file") MultipartFile file,
			@RequestParam("fileDescription") String fileDescription ) {
				//获得当前用户名
		User user = (User)request.getSession().getAttribute("user");
		String userName = user.getUserName();
		//获得当前时间
		try {
			Date date = new Date();//获得系统时间. 
			String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			Timestamp timestamp = Timestamp.valueOf(nowTime);//把时间转换 
			
			System.out.println(timestamp);
		//获得当前ip
		String ip = GetIp.getIpAddr(request);
		// 如果文件不为空，写入上传路径
		String path = request.getServletContext().getRealPath("/upload");
		String fileName = file.getOriginalFilename();
		
		Files files = new Files(null,fileName, userName,ip,fileDescription,timestamp);
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		filesService.insertFiles(files);
		// 保存
		
			file.transferTo(targetFile);
			
		} catch (Exception e) {
			return "uploadfailure";
			
		}
			
		return "success";
		
	}
	//下载文件
	@RequestMapping("download")
	 public ResponseEntity<byte[]> download(HttpServletRequest request,
             @RequestParam("fileName") String fileName,
             Model model)throws Exception {
        //下载文件路径
        String path = request.getServletContext().getRealPath("/upload");
        File file = new File(path + File.separator + fileName);
        HttpHeaders headers = new HttpHeaders();  
        //下载显示的文件名，解决中文名称乱码问题  
        String downloadFielName = new String(fileName.getBytes("UTF-8"),"iso-8859-1");
        //通知浏览器以attachment（下载方式）
        headers.setContentDispositionFormData("attachment", downloadFielName); 
        //application/octet-stream ： 二进制流数据（最常见的文件下载）。
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
                headers, HttpStatus.CREATED);  
     }
	//查询条件
	 @RequestMapping("condition")
	 public String condition(Serach serach,ModelMap map) {
		 map.addAttribute("serach", serach);
		 return "manage_file";
	 }
	 
	 
	//分页及查询
	@RequestMapping("manage_file")
	public String Page(HttpServletRequest request, Model model,ModelMap map, QueryBean queryBean,Serach serach) {
		
		List<String> findGroupName = filesService.findGroupName();
		model.addAttribute("groupName",findGroupName);
		//若session中无serach，将serach放入session
		if (request.getSession().getAttribute("serach")==null) {
			request.getSession().setAttribute("serach", serach);
		}
		Serach serach1 =(Serach) request.getSession().getAttribute("serach");
		queryBean.setFileName(serach1.getFileName());
		queryBean.setGroupName(serach1.getGroupName());
		Page<FileInfor> pb = filesService.findFilesPage(queryBean);
		 request.setAttribute("pb", pb);
	
		return "manage_file";
		
	}
	//编辑文件信息
	@RequestMapping("edit")
	@ResponseBody
	public FileInfor edit(Integer id) {
		
		FileInfor fileInfoById = filesService.getFileInfoById(id);
		System.out.println(fileInfoById.getFileName());
		return fileInfoById;
		
	}
	//更新文件信息
	@RequestMapping("update")
	@ResponseBody
	public String update(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String fileName = request.getParameter("fileName");
		String fileDescription = request.getParameter("fileDescription");
		Files files = new Files();
		files.setId(id);
		files.setFileName(fileName);
		files.setFileDescription(fileDescription);
		System.out.println(files);
		String msg = "1";
		
		try {
			int updateFileInfo = filesService.updateFileInfo(files);
			System.out.println(updateFileInfo);
			msg = "0";
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return msg;
	}
	//删除文件信息
	@RequestMapping("delete")
	@ResponseBody
	public String delete(Integer id,String uploadUserName) {
		String msg = "1";
		try {
			filesService.deleteFileInfo(id);
		msg = "0";
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return msg;
	}
	//更新浏览数
	@RequestMapping("updatepageview")
	public void updatepageview(Integer id) {
	
		filesService.updatePageView(id);
		
		
	}
	
}
