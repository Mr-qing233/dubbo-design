package org.example.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.example.entity.User;
import org.example.exception.ServiceException;
import org.example.repository.UserRepository;
import org.example.vo.ResultEnum;
import org.example.vo.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService
public class RegisterServiceImpl implements RegisterService{
    @Autowired
    private UserRepository userRepository;

    /**
     * @param uname 用户名
     * @return boolean
     */
    @Override
    public ResultJson<Boolean> existUser(String uname) {
        User userName = userRepository.findUserByUname(uname);
        if (userName!=null){
            return ResultJson.Error(ResultEnum.USERNAMEHASEXISTED);
        }
        return ResultJson.Success(true);
    }

    /**
     * @param user 用户实体
     * @return boolean
     */
    @Override
    public ResultJson<Boolean> registerUser(User user) {
        if(userRepository.newUser(user).equals(0)){
            return ResultJson.Error(ResultEnum.CREATEUSERFAILED);
        }
        return ResultJson.Success(true);
    }
}
