package base.datatypes;

import redis.clients.jedis.UnifiedJedis;

@SuppressWarnings("resource")
public class RedisSortedSets {

    public static void main(String[] args) {
        UnifiedJedis client = new UnifiedJedis();
        client.del("key", "key1");

        //ZADD key 0 "value1"
        client.zadd("key", 0, "value1");

        //ZADD key 1 "value2"
        client.zadd("key", 1, "value2");

        //ZRANK key "value2"
        System.out.println(client.zrank("key", "value2"));

        //ZPOPMAX key
        System.out.println(client.zpopmax("key"));

        //ZPOPMIN key
        System.out.println(client.zpopmin("key"));
    }

}
