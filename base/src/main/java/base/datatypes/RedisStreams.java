package base.datatypes;

import static redis.clients.jedis.StreamEntryID.NEW_ENTRY;
import static redis.clients.jedis.params.XReadParams.xReadParams;

import java.util.Map;

import redis.clients.jedis.StreamEntryID;
import redis.clients.jedis.UnifiedJedis;

@SuppressWarnings("resource")
public class RedisStreams {

    public static void main(String[] args) {
        UnifiedJedis client = new UnifiedJedis();
        client.del("key", "key1");

        //XADD key * field value
        client.xadd("key", NEW_ENTRY, Map.of("field", "value"));

        //XADD key * field1 value1
        client.xadd("key", NEW_ENTRY, Map.of("field1", "value1"));

        //XREAD STREAMS key 0-0
        System.out.println(client.xread(xReadParams(), Map.of("key", new StreamEntryID())));

        //XTRIM key MAXLEN q
        client.xtrim("key", 1, false);

        //XLEN key
        System.out.println(client.xlen("key"));
    }
}
