package HashMap;

import java.util.LinkedList;

/**
 * collision 충돌이란?
 * 1.key 의 가지수는 무한데지만 hashcode 는 key 에 가지수에비하면 유한하다.
 * 그래서 다른 key 값이여도 같은 hashcode 가 생길수있다.
 *
 * 2.다른 hashcode 여도 같은 배열방도 한정되 있으므로 같은 방에 배정될수있다.
 *
 * 즉, 배열방에 겹쳐서 저장되는 경우를 collision 이라고 한다.
 */
public class HashTable {

    LinkedList<Node>[] data;

    public HashTable(int size) {
        this.data = new LinkedList[size];
    }

    int getHashCode(String key){
        int hashcode = 0;
        for(char c : key.toCharArray()){
            hashcode += c;
        }
        return hashcode;
    }

    int convertToIndex(int hashcode){
        return hashcode % data.length;
    }
    Node searchKey(LinkedList<Node> list,String key){
        if (list == null ) return null;
        for(Node node : list){
            if(node.key.equals(key)){
                return node;
            }
        }
        return null;
    }

    void put(String key,String value){
        int hashcode = getHashCode(key);
        int index = convertToIndex(hashcode);
        LinkedList<Node> list = data[index];

        if( list == null ){
            list = new LinkedList<>();
            data[index] = list;
        }

        Node node = searchKey(list, key);
        if(node == null){
            list.addLast(new Node(key,value));
        } else {
            node.value(value);
        }

    }

    String get(String key){
        int hashcode = getHashCode(key);
        int index = convertToIndex(hashcode);
        LinkedList<Node> list = data[index];
        Node node = searchKey(list, key);
        return node == null ? "Not Found" : node.value();
    }

}

class Test{
    public static void main(String[] args) {
        HashTable h = new HashTable(3);
        h.put("a","A");
        h.put("b","B");
        h.put("c","C");
        h.put("d","D");

        System.out.println(h.get("a"));
        System.out.println(h.get("b"));
        System.out.println(h.get("c"));
        System.out.println(h.get("d"));

    }
}

class Node{
    String key;
    String value;

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
    }
    String value(){
        return value;
    }

    void value(String value){
        this.value = value;
    }

}
