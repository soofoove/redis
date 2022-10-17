package base.datatypes;

import redis.clients.jedis.UnifiedJedis;

@SuppressWarnings("resource")
public class RedisLists {

    public static void main(String[] args) {
        UnifiedJedis client = new UnifiedJedis();
        client.del("key", "key1");

        //LPUSH key "left"
        client.lpush("key", "left");

        //RPUSH key "right"
        client.rpush("key", "right");

        //LSET key 0 "value"
        client.lset("key", 0, "value");

        //LINDEX key 0
        System.out.println(client.lindex("key", 0));

        //LPOP key
        System.out.println(client.lpop("key"));

        //RPOP key
        System.out.println(client.rpop("key"));

        //LLEN key
        System.out.println(client.llen("key"));

        //BLPOP key 60
        System.out.println(client.blpop(60, "key"));

        //BRPOP key 60
        System.out.println(client.brpop(60, "key"));
    }
}
