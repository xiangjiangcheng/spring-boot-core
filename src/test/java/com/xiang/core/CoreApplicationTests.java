package com.xiang.core;

import com.xiang.core.entity.User;
import com.xiang.core.model.Rkey;
import com.xiang.core.model.RkeyInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
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
	@Autowired
	private RedisTemplate redisTemplate;

	/**
	 * 测试spring boot 自己封装的操作redis的类：StringRedisTemplate
	 * 参考博客：https://www.jianshu.com/p/7bf5dc61ca06
	 *
	 * redisTemplate.opsForValue();//操作字符串
	 * redisTemplate.opsForHash();//操作hash
	 * redisTemplate.opsForList();//操作list
	 * redisTemplate.opsForSet();//操作set
	 * redisTemplate.opsForZSet();//操作有序set
	 */
	@Test
	public void contextLoads() {
		stringRedisTemplate.opsForValue().set("redisTest", "毛桃一");
		String redisStr = stringRedisTemplate.opsForValue().get("redisTest");
		logger.info(redisStr);
	}


	/**
	 * 测试redis 对象转字符串 + 解析字符串
	 * redis:String类型
	 */
	@Test
	public void redisStringTest() {
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

	/**
	 * redis:Hash类型
	 *
	 * todo 使用 RedisTemplate这个类hash存放时，不知道为什么，key,value的前面会多出一段字符串: 如: \xAC\xED\x00\x05t\x00\x16user_info_with_student
	 */
	@Test
	public void redisHashTest() {
		User user = new User();
		user.setUserId("0000000000002");
		user.setAge(19);
		user.setName("毛桃二");
		String obj2String = JsonUtil.convertObj2String(user);
		stringRedisTemplate.opsForHash().put(Rkey.USER_INFO_WITH_STUDENT, RkeyInfo.KEY_PREFIX_HASH + "00000000000021", obj2String);

//		redisTemplate.opsForHash().put(Rkey.USER_INFO_WITH_STUDENT, RkeyInfo.KEY_PREFIX_HASH + "00000000000021", obj2String);
	}

}
