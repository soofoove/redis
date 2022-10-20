package cluster;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

@SuppressWarnings("resource")
public class Main {

    public static void main(String[] args) {
        final Set<HostAndPort> nodes = new HashSet<>();
        final String host = "<Your IP here>";
        nodes.add(new HostAndPort(host, 6373));
        nodes.add(new HostAndPort(host, 6374));
        nodes.add(new HostAndPort(host, 6375));
        nodes.add(new HostAndPort(host, 6376));
        nodes.add(new HostAndPort(host, 6377));
        nodes.add(new HostAndPort(host, 6378));

        JedisCluster jedisCluster = new JedisCluster(nodes);

        jedisCluster.set("key", "value");
        System.out.println(jedisCluster.get("key"));
    }
}