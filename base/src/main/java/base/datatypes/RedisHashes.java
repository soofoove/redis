package base.datatypes;

import java.util.Map;

import redis.clients.jedis.UnifiedJedis;

@SuppressWarnings("resource")
public class RedisHashes {

    public static void main(String[] args) {
        UnifiedJedis client = new UnifiedJedis();
        client.del("key", "key1");

        //HSET key field1 value1 field2 value2
        client.hset("key", Map.of("field1", "value1", "field2", "value2"));

        //HGET key field1
        System.out.println(client.hget("key", "field1"));

        //HGETALL key
        System.out.println(client.hgetAll("key"));

        //HKEYS key
        System.out.println(client.hkeys("key"));

        //HVALS key
        System.out.println(client.hvals("key"));
    }

}
