package com.zsp.teacher.serviceimpl;

import com.zsp.teacher.entity.TbGonggao;
import com.zsp.teacher.mapping.GonggaoMaping;
import com.zsp.teacher.service.GonggaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @Author：张世朋
 * @Date：Create in2020/19:34/2020/2/6
 * @logNmae：zsp
 * @DO:
 */
@Service
public class GonggaoServiceimpl implements GonggaoService {
    @Autowired
    private GonggaoMaping gonggaoMaping;
    @Override
    public List<TbGonggao> getgonggao() {
      List<TbGonggao>  tbGonggaos= gonggaoMaping.getgonggaos();
      if(tbGonggaos!=null){
          Collections.sort(tbGonggaos);
          return tbGonggaos;

      }

        return null;
    }
}
