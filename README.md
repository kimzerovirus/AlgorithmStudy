# Kotlin-Datastructure

**연결 리스트**

![img](https://cphinf.pstatic.net/mooc/20210412_137/16182216780657zwCT_PNG/mceclip0.png)

 

**스택 & 큐**

![img](https://cphinf.pstatic.net/mooc/20210412_234/1618221720177BK2bF_PNG/mceclip1.png)

 

**체인 해시**

![img](https://cphinf.pstatic.net/mooc/20210412_58/16182217970322FWIt_PNG/mceclip2.png)

 

**트리**

![img](https://cphinf.pstatic.net/mooc/20210412_7/1618221911213bTf5e_PNG/mceclip3.png)

 

**정렬**

![img](https://cphinf.pstatic.net/mooc/20210412_223/1618221974817OOUwc_PNG/mceclip4.png)



## 시간 복잡도

> 항상 상수는 무시한다. (n == 2n == 50n != n^2 == 100n^2)<br/>
>
> 낮은 차수의 항은 무시한다. (n^3 + n^2 + 1 == n^3 + n + 1)<br/>
>
> 등호를 사용하여 표현하며 2n = O(n), 2n은 O(n)이라는 함수의 집합에 속한다는 뜻이다. 

- **log n** : 반복 문으로 무언가를 탐색하면서 반으로 나누거나 2를 곱하는 경우 (밑은 무시하고 그냥 log n 복잡도를 가진다고 표현한다. ex: trees)

- **n** : 각각의 요소마다 한 번씩 작업을 하는 경우 (ex: list)

- **n^2** : 모든 요소를 서로 비교하는 경우 (ex: bubble sort)

## 배열과 리스트의 차이점

배열은 요소를 지우면 지워진 요소의 자리가 null로 채워지지만 리스트는 한자리씩 앞으로 땡겨서 채운다

c 에는 리스트가 없다. 하지만 최근에 만들어진 언어인 자바스크립트나 파이썬의 배열은 리스트의 기능을 가지고 있다. 자바의 경우에는 배열과 리스트를 별도로 제공한다.

그렇다, 데이터 스트럭쳐는 언어마다 다르다!

### 리스트

코틀린에서는 `listof`로 불변 즉, 읽기 전용으로 밖에 사용 불가능하다. 따라서 `get`메서드는 사용 가능하나 `add`, `set`메서드는 지원하지 않는다. 물론 `mutableListof`도 별도로 제공한다. → 자바로 변환되면 `ArrayList`로 되는것 같다.

`ArrayList` mutableList로 크기가 자유롭고 삽입, 삭제, 조회 등 수정이 가능하다.

- 처음, 끝, 중간에 요소를 추가/삭제하는 기능
- 리스트의 데이터가 있는지를 체크하는 기능
- 리스트의 모든 데이터에 접근 할 수 있는 기능 

### ArrayList vs LinkedList

|            | 추가/삭제 | 인덱스 조회 |
| ---------- | --------- | ----------- |
| ArrayList  | 느림      | 빠름        |
| LinkedList | 빠름      | 느림        |

## ArrayList

- 배열을 이용한 리스트로 배열에 요소를 추가/삭제를 할 때마다 한칸씩 자리를 땡겼다가 벌렸다가 하면 된다. (**추가/삭제시 해당 요소의 뒷 부분이 전부 왔다갔다하므로 느려진다.**)
- 배열을 이용해서 만들었기 때문에 인덱스가 있어 인덱스로 쉽게 조회 가능하다.
- 기본 용량은 10으로 지정용량 또는 기본 용량 초과시 자동으로 1.5배로 크기를 증가시킨다.

## LinkedList

 - 각 노드가 데이터와 포인터를 가지고 한 줄로 연결되어 있는 방식이다.



## Map과 HashMap의 차이점

둘의 가장 큰 차이는 특정 키에 대한 값을 찾는 과정에서, HashMap 은 이름 그대로 Hash Table 을 이용해서 key-value 관계를 유지하며, Map 은 red-black tree 알고리즘을 이용한다.

### Map
- key - value 관계로 이루어진 데이터의 집합이다.
- 데이터의 순서는 유지되지 않는다.
- 키의 중복을 허락하지 않는다.

### HashMap
- Map Interface를 Implements 한 클래스이다.
- 중복을 허용하지 않는다.
- key - value 관계로 이루어진 데이터의 집합이다.
- key 또는 value 값으로써 null을 허용한다. 

### TreeMap
- 중복을 허용하지 않는다.
- key - value 관계로 이루어진 데이터의 집합이다.

- SortedMap을 상속하였다.
- key 값들에 대한 정렬이 이루어진다.

### HashTableMap
- key 또는 value 값으로써 null을 허용하지 않는다. 



###### 참고

[네이버 부스트코스 - 자바로 구현하고 배우는 자료구조](https://www.boostcourse.org/cs204/home) 
