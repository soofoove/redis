package base.datatypes;

import redis.clients.jedis.UnifiedJedis;

@SuppressWarnings("resource")
public class RedisString {

    public static void main(String[] args) throws InterruptedException {
        UnifiedJedis client = new UnifiedJedis();
        client.del("key", "key1");

        //SET key "value"
        client.set("key", "value");

        //APPEND key "123"
        client.append("key", "123");

        //GETSET key "value"
        System.out.println(client.getSet("key", "value"));

        //GETRANGE key 0 3
        System.out.println(client.getrange("key", 0, 3));

        //SETRANGE key 0 3
        client.setrange("key", 3, "e");

        //STRLEN key
        System.out.println(client.strlen("key"));

        //GETDEL key
        System.out.println(client.getDel("key"));

        //SET key 1 "value"
        client.setex("key", 1, "value");
        Thread.sleep(1000);
        System.out.println(client.get("key"));
    }

}
