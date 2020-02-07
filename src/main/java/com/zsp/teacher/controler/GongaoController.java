package com.zsp.teacher.controler;

import com.zsp.teacher.entity.TbGonggao;
import com.zsp.teacher.service.GonggaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author：张世朋
 * @Date：Create in2020/18:51/2020/2/6
 * @logNmae：zsp
 * @DO:
 */
@Controller
@RequestMapping("/gonggao")
public class GongaoController {
    @Autowired
    private GonggaoService gonggaoService;
    @ResponseBody
    @RequestMapping("/getgonggao.action")
    public List<TbGonggao> getgonggao(){
      List<TbGonggao> gonggaos=gonggaoService.getgonggao();

      return gonggaos;
    }
}
