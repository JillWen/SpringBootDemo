package com.demo.curd.server.controller;

import com.demo.curd.server.service.IUserService;
import com.demo.curd.shared.domain.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
@Slf4j
public class RestApiController {
    @Autowired
    IUserService userService;

    /**
     * 查询所有用户
     *
     * @return
     */
    @ApiOperation(value = "查询所有用户")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> listAllUsers() {
        List<User> users = userService.findAllUsers();
        return users;
    }

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") int id) {
        log.info("Fetching User with id {}", id);
        User user = userService.findById(id);
        if (user == null) {
            log.error("User with id {} not found.", id);
        }
        return user;
    }

    /**
     * 新建一个用户
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createUser(@ModelAttribute User user) {
        //除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数/RequestBody ?
        log.info("Creating User : {}", user);
        User exitUser = new User();
        exitUser.setId(user.getId());
        if (userService.isUserExist(exitUser)) {
            log.error("Unable to create. A User with id {} already exist", exitUser.getId());
        }
        userService.saveUser(user);
        return "success";
    }

    /**
     * 根据id更新用户信息
     *
     * @param id
     * @param user
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateUser(@PathVariable("id") int id, @ModelAttribute User user) {
        //RequestBody
        log.info("Updating User with id {}", id);

        User currentUser = userService.findById(id);

        if (currentUser == null) {
            log.error("Unable to update. User with id {} not found.", id);
            return "fail";
        }
        currentUser.setName(user.getName());
        currentUser.setAge(user.getAge());
        userService.updateUser(currentUser);
        return "success";
    }

    /**
     * 根据id删除用户
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") int id) {
        log.info("Fetching & Deleting User with id {}", id);

        User user = userService.findById(id);
        if (user == null) {
            log.error("Unable to delete. User with id {} not found.", id);
            return "fail";
        }
        userService.deleteUserById(id);
        return "success";
    }


    /**
     * 删除所有用户
     *
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public String deleteAllUsers() {
        log.info("Deleting All Users");

        userService.deleteAllUsers();
        return "success";
    }

}
