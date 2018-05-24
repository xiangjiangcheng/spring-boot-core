package com.xiang.core;

import com.xiang.core.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;
import utils.JsonUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoreApplicationTests {

	private Logger logger = LoggerFactory.getLogger(CoreApplicationTests.class);

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Test
	public void contextLoads() {
		stringRedisTemplate.opsForValue().set("redisTest", "毛桃一");
		String redisStr = stringRedisTemplate.opsForValue().get("redisTest");
		logger.info(redisStr);
	}


	/**
	 * 测试redis 对象转字符串
	 */
	@Test
	public void redisObjectTest() {
		User user = new User();
		user.setUserId("0000000000001");
		user.setAge(18);
		user.setName("毛桃一");
		String obj2String = JsonUtil.convertObj2String(user);
		stringRedisTemplate.opsForValue().set("user", obj2String);
		// 取出key = user
		String redisStr = stringRedisTemplate.opsForValue().get("user");
		if (!StringUtils.isEmpty(redisStr)) {
			// string转obj
			User userRedis = JsonUtil.convertString2Obj(redisStr, User.class);
			System.out.println(userRedis.toString());
		}
	}

}
