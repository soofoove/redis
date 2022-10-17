package base.datatypes;

import java.util.stream.Collectors;

import redis.clients.jedis.UnifiedJedis;
import redis.clients.jedis.args.GeoUnit;
import redis.clients.jedis.resps.GeoRadiusResponse;

@SuppressWarnings("resource")
public class RedisGeospatial {

    public static void main(String[] args) {
        UnifiedJedis client = new UnifiedJedis();
        client.del("key", "key1");

        //GEOADD key 10.0 10.0 "car"
        client.geoadd("key", 10.0, 10.0, "car");

        //GEOADD key 15.0 15.0 "car1"
        client.geoadd("key", 15.0, 15.0, "car1");

        //GEOPOS key "car"
        System.out.println(client.geopos("key", "car"));

        //GEODIST key "car" "car1" km
        System.out.println(client.geodist("key", "car", "car1", GeoUnit.KM));

        //GEOSEARCH key FROMMEMBER "car" BYRADIUS 1000 km
        System.out.println(client.geosearch("key", "car", 1000, GeoUnit.KM)
                                 .stream()
                                 .map(GeoRadiusResponse::getMemberByString)
                                 .collect(Collectors.toList()));
    }
}
