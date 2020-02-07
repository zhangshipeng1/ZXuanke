package com.zsp.student.serviceimpl;

import com.zsp.student.entity.Frindpovo;
import com.zsp.student.mapping.FriendMapping;
import com.zsp.student.service.FrindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author：张世朋
 * @Date：Create in2019/20:32/2019/12/1
 * @logNmae：zsp
 * @DO:
 */
@Service
public class FrindServiceimpl implements FrindService {
    @Autowired
    FriendMapping friendMapping;

    @Override
    public List<Frindpovo> selectFrind(String username) {

        return friendMapping.selectFrinds(username);
    }
}
