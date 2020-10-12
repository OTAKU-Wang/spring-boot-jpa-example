package com.neo.test;

import com.neo.model.Company;
import com.neo.model.User;
import com.neo.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserCompanyTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSave() {
        User user = new User();
        user.setAge(3)
                .setPassword("3")
                .setUserName("3");
        Company inspur = new Company();
        inspur.setAddress("山东省济南市浪潮路3306")
                .setName("浪潮软件")
                .setPhoneNum("186666666");
        user.setWorkCompanies(Collections.singletonList(inspur));
        userRepository.save(user);
    }
    @Test
    @Transactional
    public void testUpdate(){
        User user = userRepository.findAllByUserName("2").orElse(new User());
//        Company alibaba = new Company();
//        alibaba.setAddress("杭州余杭西溪园区")
//                .setName("阿里巴巴集团")
//                .setPhoneNum("186666666");
//        user.getWorkCompanies().add(alibaba);
        user.setWorkCompanies(null);
        userRepository.save(user);
    }
    @Test
    @Transactional
    public void testFind(){
        User user = userRepository.findById("1d401015-2143-4117-b776-5736648c7e6f").orElse(new User());
        System.out.println(user);
    }
}
