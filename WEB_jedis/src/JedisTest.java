import com.redis.JedisUtils;
import redis.clients.jedis.Jedis;
public class JedisTest {
	public static void main(String[] args) {
		Jedis jedis = JedisUtils.getJedis();
		System.out.println(jedis.get("username"));
		jedis.set("password", "123456");
		System.out.println(jedis.get("password"));
	}
}
