package com.zio.wj.controller;

import com.zio.wj.dao.UserDao;
import com.zio.wj.pojo.User;
import com.zio.wj.utils.ResultVOUtil;
import com.zio.wj.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDao userDao;

    @GetMapping("/{id}")
    public ResultVO<User> findById(@PathVariable("id") Integer id) {
        Optional<User> optional = userDao.findById(id);
        User user = optional.get();
        return ResultVOUtil.success(user);
    }

    /* JpaRepository的save()方法，若保存的实体类中的主键，在数据库中存在，做保存操作；反之，做更新操作。 */
    @PostMapping
    public ResultVO saveOrUpdate(@RequestBody User user) {
        System.out.println(user);
        userDao.save(user);
        return ResultVOUtil.success();
    }

    @DeleteMapping("/{id}")
    public ResultVO delete(@PathVariable("id") Integer id) {
        userDao.deleteById(id);
        return ResultVOUtil.success();
    }

}
