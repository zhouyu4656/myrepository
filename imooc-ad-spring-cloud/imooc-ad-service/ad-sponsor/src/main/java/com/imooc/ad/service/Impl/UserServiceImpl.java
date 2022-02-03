package com.imooc.ad.service.Impl;

import com.imooc.ad.constant.Constants;
import com.imooc.ad.dao.AdUserRepository;
import com.imooc.ad.entity.AdUser;
import com.imooc.ad.exception.AdException;
import com.imooc.ad.service.IUserService;
import com.imooc.ad.utils.CommonUtils;
import com.imooc.ad.vo.CreateUserRequest;
import com.imooc.ad.vo.CreateUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private AdUserRepository adUserRepository;

    @Override
    @Transactional
    public CreateUserResponse createUser(CreateUserRequest request) throws AdException {

        if (!request.validate()){
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        AdUser adUser = adUserRepository.findByUsername(request.getUsername());
        if (null != adUser){
            throw new AdException(Constants.ErrorMsg.SAME_NAME_ERROR);
        }
        AdUser newAdUser = adUserRepository.saveAndFlush(new AdUser(request.getUsername(),
                CommonUtils.MD5(request.getUsername())));



        return new CreateUserResponse(newAdUser.getId(),
                newAdUser.getUsername(),
                newAdUser.getToken(),
                newAdUser.getCreateTime(),
                newAdUser.getUpdateTime());
    }
}
