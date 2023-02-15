package fwefw;

import org.msgpack.MessagePack;
import org.msgpack.packer.MessagePackPacker;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class test {

    public static void main(String[] args) {

//        TreeMap<String, String> map = new TreeMap<>();
        Map<String, String> map = new HashMap<>();

        map.put("2","");
        map.put("5","");
        map.put("7","");
        map.put("3","");
        map.put("2","");
        map.put("1","");

        System.out.println(map);

    }
}
