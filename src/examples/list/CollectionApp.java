package examples.list;

import java.util.HashSet;
import java.util.Vector;

public class CollectionApp {

    /* Collection
       종류 : ArrayList, LinkedList, Vector, HashSet, TreeSet
       특징 : 순서를 가진다.
     */


    public static void main(String[] args){

        /* Vector

           Java 1.0 부터 현재까지 유지되어온 녀석
           List 와 다른점은 "동기화(내가 찜한건 남이 못씀)"
           Vector 는 무조껀 동기화를 한다.
           공유자원/복수사용자 문제가 없을 때, 성능저하 요소

           Vector는 성능이 구져서 동기화가 필요할 때는 아래 두가지를 쓴다.
           - Collection.synchronizedCollection(Collection c)
           - Map

         */

        Vector vt = new Vector(10);
        System.out.println(vt.capacity());

        vt.add("A");
        System.out.println(vt.get(0));


    }

}
