package com.dz.controller;

import java.io.File;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dz.entity.DzImageMain;
import com.dz.service.DzImageMainService;


@Controller
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class FileController {

	public static Logger logger = Logger.getLogger(FileController.class);
	@Autowired
	private DzImageMainService dService;;
	
	
	@RequestMapping("/in")
	public String test(Model model) {
		DzImageMain dzImageMainById = dService.getDzImageMainById("1");
		System.out.println(dzImageMainById);
		//dzImageMainById的imgUrl字段要与图片服务器的path匹配
		//若同一个tomcat图片不显示，就空起一个tomcat作为专用图片服务器
		//<Context path="upload" docBase="D:\\upload" reloadable="true" crossContext="true" />
		model.addAttribute("dzImageMainById",dzImageMainById);
		//图片服务器域名加端口
		model.addAttribute("imgHost","http://localhost:8521");
		return "uploadFile";
	}
    /*** 
     * 保存文件 
     * @param file 
     * @return 
     */  
    private boolean saveFile(MultipartFile file, String path) {  
        // 判断文件是否为空  
        if (!file.isEmpty()) {  
            try {  
                File filepath = new File(path);
                if (!filepath.exists()) 
                    filepath.mkdirs();
                // 文件保存路径  
                String savePath = path + file.getOriginalFilename();  
                // 转存文件  
                file.transferTo(new File(savePath));  
                return true;  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        return false;  
    }  

    @RequestMapping("/filesUpload")
    @ResponseBody
    public String filesUpload(@RequestParam("files") MultipartFile[] files) { 
        String path = "D:/upload/";
        //判断file数组不能为空并且长度大于0  
        if(files!=null&&files.length>0){  
            //循环获取file数组中得文件  
            for(int i = 0;i<files.length;i++){  
                MultipartFile file = files[i];  
                //保存文件  
                saveFile(file, path);
            }  
        }  
        
        
        // 重定向  
        return "Success";  
    }  
}
