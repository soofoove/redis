package base.datatypes;

import redis.clients.jedis.UnifiedJedis;

@SuppressWarnings("resource")
public class RedisSets {

    public static void main(String[] args) {
        UnifiedJedis client = new UnifiedJedis();
        client.del("key", "key1");

        //SADD key "value"
        client.sadd("key", "value");

        //SSCAN key 0
        System.out.println(client.sscan("key", "0").getResult());

        //SISMEMBER key "value"
        System.out.println(client.sismember("key", "value"));

        //SREM key "value"
        client.srem("key", "value");

        //SPOP key
        System.out.println(client.spop("key"));

        //SADD key "value" "value1"
        client.sadd("key", "value", "value1");

        //SADD key1 "value-1" "value"
        client.sadd("key1", "value-1", "value");

        //SUNION key key1
        System.out.println(client.sunion("key", "key1"));

        //SINTER key key1
        System.out.println(client.sinter("key", "key1"));

        //SDIFF key key1
        System.out.println(client.sdiff("key", "key1"));
    }
}
