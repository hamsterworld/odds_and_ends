package concurrentmodificationexception.list;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        /**
         * iterator의 방식으로 순회중..
         *
         * remove 에서는 fastremove 를 순회하고있다.
         *
         *
         *
         *         modCount++;
         *         int numMoved = size - index - 1;
         *         if (numMoved > 0)
         *             System.arraycopy(elementData, index+1, elementData, index,
         *                              numMoved);
         *         elementData[--size] = null;
         *
         * 		ㅁㅁㅁㅁㅁ 이렇게있다면
         * 		ㅁㅁ*ㅁㅁ *쪽이 삭제된다면 삭제하고자하는 index + 1 부터 끝까지 싹다 복사한후 쫙 밀어넣는중이다.
         * 		ㅁㅁㅁㅁ 이렇게
         * 		여기서 데이터조작이 발생한다.
         * 		그리고 modCount 가 1증가한다. mobcount 는 iterator 를 맨처음 생산할때
         * 		다른 클래스변수인 expectedModCount 와 동기화된다.
         * 		Iterator<Integer> iterator = testlist.iterator();
         *
         * 		Itr 에서 확인해볼수있다.
         * 		int expectedModCount = modCount;
         * 		이 2개의 클래스변수로부터 리스트의 데이터 조작여부를 확인 하게되는것
         * 		조작매서드(add/remove)등을 사용하면 fastremove 에서도 나왔듯이
         * 		mobcount 가 증가되고 element 가 제거되고 난뒤 iterator 에서 next() 메소드로 다음 element를 가져오는 순간
         * 		ConcurrentModificationException 이 발생하는것이다.
         * 		next() 호출 -> checkForComodification()호출 modCount 비교 어 변경됫네? 에러
         * 		    private void checkForComodification() {
         * 				if (this.modCount != l.modCount)
         * 				throw new ConcurrentModificationException();
         *                        }
         *
         * 		이런것을 fail-fast 방식이라고도한다. 순차적접근에 실패했을때.
         *
         * 		해결방법
         * 		1. 한번 순회할때 원하는거 add,remove든지 도달하고 break하면 문제는 발생하지않는다.
         * 		2. iterator를 사용하지않는것.
         * 		3. concuurent Collection 을 사용해도 좋다.
         * 		4. 전체사이즈 - 1일때는 element 삭제가 발생하지않는데 그이유는
         * 		   remove후 남은 list element가 있는지 확인하기위해 hasNext()에서 size와 현재커서의 index를 확인했을때
         * 		   남아잇는 element가 없으므로 loop를 종료시키기때문.
         *
         * 		그러면 list자체를 조작하지말고 애초에 막아버려 그냥
         * 		대표적으로 java에는 unmodifiableList가 있다.
         * 		collection에 조작매서드를 가하는순간 UnsupportedOperationException이 발생한다.
         * 		그래서  ConcurrentModificationException는 발생하지않고
         * 		UnsupportedOperationException가 발생한다.
         *
         * 		그럼 불변컬렉션을사용하지만 데이터가 변경되려면 어떻게 해야할까?
         * 		람다를 이용해서 filter로 원하는 부분만 처리하고 불변으로 만들어버릴수있다.
         *
         * 		결론적으로는 enhanced for loop를 조심히 사용하자.
         * 		안전한 불변컬렉션을 사용하자.
         */
    }
}
