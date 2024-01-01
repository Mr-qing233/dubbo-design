package org.example.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.example.vo.ResultEnum;
import org.example.vo.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService
public class LoginServiceImpl implements LoginService{
    @Autowired
    private UserRepository userRepository;

    /**
     * @param uid 用户id
     * @param password 用户密码
     * @return ResultJson
     */
    @Override
    public ResultJson<User> loginUser(String uid, String password) {
        User userByUid = userRepository.judgeUserPassword(uid,password);
        if (userByUid == null){
            return ResultJson.Error(ResultEnum.USERNOTEXISTORPWDERROR);
        }
        userByUid.setPassword(null);
        return ResultJson.Success(userByUid);
    }
}
