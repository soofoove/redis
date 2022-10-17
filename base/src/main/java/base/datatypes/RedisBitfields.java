package base.datatypes;

import redis.clients.jedis.UnifiedJedis;

@SuppressWarnings("resource")
public class RedisBitfields {

    public static void main(String[] args) {
        UnifiedJedis client = new UnifiedJedis();
        client.del("key", "key1");

        //BITFIELD key SET u2 0 1
        client.bitfield("key", "SET", "u2", "0", "1");

        //BITFIELD key GET u2 0
        System.out.println(client.bitfield("key", "GET", "u2", "0"));

        //BITFIELD key INCRBY u2 0 1
        client.bitfield("key", "INCRBY", "u2", "0", "1");

        //BITFIELD key GET u2 0
        System.out.println(client.bitfield("key", "GET", "u2", "0"));
    }
}
