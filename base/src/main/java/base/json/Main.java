package base.json;

import redis.clients.jedis.UnifiedJedis;
import redis.clients.jedis.json.Path;

@SuppressWarnings("resource")
public class Main {

    public static void main(String[] args) {
        UnifiedJedis client = new UnifiedJedis();

        final var student = new Student("First", "Last");
        client.jsonSet("student", Path.ROOT_PATH, student);

        System.out.println(client.jsonGet("student"));
    }
}