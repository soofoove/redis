package base.datatypes;

import redis.clients.jedis.UnifiedJedis;

@SuppressWarnings("resource")
public class RedisHyperLogLog {

    public static void main(String[] args) {
        UnifiedJedis client = new UnifiedJedis();
        client.del("key", "key1");

        //PFADD key "123" "321" "123" "321" "456"
        client.pfadd("key", "123", "321", "123", "321", "456");

        //PFCOUNT key
        System.out.println(client.pfcount("key"));
    }

}
