package com.demo.curd.validator;

import com.demo.curd.shared.domain.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Version
 * @Title: ValidateController
 * @Package: package com.example.demo.validator
 * @Description:
 * @Author: WenJie
 * @Date: 2017/8/16
 */
@RestController
public class ValidateController {
    @RequestMapping(value="testUser")
    public void testStudent(@Validated User user) {
    }

    @RequestMapping(value="testUser1")
    public void testStudent1(@Validated(User.NAME.class) User user) {
    }
}
