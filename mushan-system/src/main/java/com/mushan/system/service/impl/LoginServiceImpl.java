package com.mushan.system.service.impl;

import com.mushan.exception.UserNamePassWordException;
import com.mushan.system.service.LoginService;
import com.mushan.utlis.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public String login(Map<String, String> map) {
      String uuid =  map.containsKey("uuid")?map.get("uuid"):"";
      String username =  map.containsKey("username")?map.get("username"):"";
      String password =  map.containsKey("password")?map.get("password"):"";
      String code =  map.containsKey("code")?map.get("code"):"";

      if (StringUtils.isEmpty(username) | StringUtils.isEmpty(password)){
          throw new UserNamePassWordException();
      }

        return null;
    }
}
