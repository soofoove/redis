package base;

import redis.clients.jedis.Jedis;

@SuppressWarnings("resource")
public class Main {

    public static void main(String[] args) {
        Jedis jedisCluster = new Jedis();

        jedisCluster.set("key1", "value1");
        System.out.println(jedisCluster.get("key1"));
    }
}