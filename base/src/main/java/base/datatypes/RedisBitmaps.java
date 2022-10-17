package base.datatypes;

import redis.clients.jedis.UnifiedJedis;
import redis.clients.jedis.args.BitOP;

@SuppressWarnings("resource")
public class RedisBitmaps {

    public static void main(String[] args) {
        UnifiedJedis client = new UnifiedJedis();
        client.del("key", "key1");

        //SETBIT key 0 1
        client.setbit("key", 0, true);

        //SETBIT key1 0 1
        client.setbit("key1", 0, false);

        //GETBIT key 0
        System.out.println(client.getbit("key", 0));

        //BITOP AND result key key1
        client.bitop(BitOP.AND, "result", "key", "key1");
        System.out.println(client.getbit("result", 0));

        //BITOP OR result key key1
        client.bitop(BitOP.OR, "result", "key", "key1");
        System.out.println(client.getbit("result", 0));

        //BITOP XOR result key key1
        client.bitop(BitOP.XOR, "result", "key", "key1");
        System.out.println(client.getbit("result", 0));

        //BITOP NOT result key key1
        client.bitop(BitOP.NOT, "result", "key");
        System.out.println(client.getbit("result", 0));
    }

}
