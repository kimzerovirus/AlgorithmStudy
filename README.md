## 버블 정렬
> 데이터의 인접요소끼리 비교하고 스왑연산 <br/>
> 앞,뒤 비교 <br/>
- 버블 정렬은 하나의 배열에서 값을 바꾸는 식으로 동작하므로 공간 복잡도는 O(1)이다.
- 선택정렬과 마찬가지로 swap 할 때 필요한 임시변수 정도의 추가공간만 있으면 되므로 in-place 정렬이다.
- (n-1), (n-2) ... 1번 의 탐색이 필요하므로 시간복잡도는 O(n^2)이다.
- 버블 정렬은 중복된 키 값의 순서가 정렬 후에도 유지되므로 stable 정렬이다.
##### 구현
1. 비교 연산이 필요한 루프 범위 설정
2. 인접 데이터 끼리 비교
3. 비교 조건에 따라 스왑
4. 루프가 끝날 때까지 2~3 반복
5. 정렬 영역 재설정, 이전의 작업을 통해 정렬된 영역은 범위에서 제외
6. 비교 대상이 없을 때까지 1~5 반복
```
A : 정렬할 배열

for(i: 0 ~ A.length) {
    for(j: 0 ~ A.length - i) {
        정렬 조건 -> 스왑연산
    }
}
```
## 선택 정렬
> 대상에서 가장 크거나 작은 요소 찾아서 가장 앞의 데이터와 비교하고 스왑하는 연산
> 최댓값 또는 최솟값 요소를 찾아서 맨 앞과 비교
- 선택정렬은 하나의 배열에서 값을 바꾸는 식으로 동작하므로 공간 복잡도는 O(1) 이다. 기껏해야 swap 할때 임시변수 하나의 공간 정도가 더 필요하므로 선택 정렬은 in-place 정렬이다.
- 탐색은 (n-1)번, (n-2)번 ... 1번 진행되므로 시간복잡도는 O(n^2) 이다.
- 선택정렬은 중복된 키값이 순서대로 바뀌지 않을 수 있어 (예를 들어 {7,7,1}을 오름차순으로 선택정렬해보라) not-stable 하다.
##### 구현
1. 남은 정렬 부분에서 최솟값 or 최댓값 찾기
2. 남은 정렬 부분의 맨 앞 데이터와 선택된 요소 비교
3. 맨 앞 데이터 위치를 변경하고 index++, 남은 정렬 범위 축소
4. 전체 데이터 크기만큼 index 가 커질 때 까지 반복

## 삽입 정렬
> 이미 정렬된 영역에서 선택 데이터의 적절한 위치를 찾아 삽입하면서 정렬 <br/>
> 삽입 정렬은 두 번째 원소부터 시작하여 그 앞의 원소들과 비교하여 삽입할 위치를 지정한 후, 원소를 뒤로 옮기고 지정된 자리에 자료를 삽입하여 정렬
> O(n^2)
- 배열 내에서 교환하는 방식이므로 공간복잡도는 O(1)이다. 기껏해야 원소를 교환할 때 쓰일 임시변수 정도의 추가공간만 필요하므로 in-place 정렬이다.
- 평균과 최악의 시간복잡도는 O(n^2)이다.
- 삽입 정렬은 중복된 키 값의 순서가 정렬 후에도 유지되므로 stable 정렬이다.
- 선택 정렬이나 버블 정렬에 비해 상대적으로 빠르다.
##### 구현
1. 현재 index 에 있는 데이터 선택
2. 현재 선택한 데이터가 정렬된 데이터 범위에 삽입될 위치를 탐색 (이진 탐색 등 탐색 알고리즘을 사용해서 시간 단축 가능)
3. 삽입 위치부터 index 위치까지 shift 연산 수행
4. 삽입 위치에 현재 선택한 데이터를 삽입하고 index++
5. index 가 전체 데이터 크기 만큼 커질 때 까지 반복


## 퀵 정렬
> pivot 을 기준으로 pivot 보다 작은 요소들은 모두 pivot 의 왼쪽으로 옮기고 pivot 보다 큰 요소들은 모두 pivot 의 오른쪽으로 옮긴다.<br/>
> 기준점을 기준으로 옮기는 정렬
- 퀵정렬은 재귀적으로 정의되므로 재귀 호출에 따른 스택이 사용된다. 이때 스택의 깊이는 n개의 원소에 대해 logn에 비례하므로 공간복잡도는 O(nlogn)이다. 따라서 in-place 정렬이라고 하기 힘들지만, 실용적으로는 상대적으로 작은 메모리만을 사용하므로 흔히 in-place 정렬이라고 기술하기도 한다.
- 퀵정렬은 최악의 경우 pivot이 배열 내에서 가장 작은 값 또는 가장 큰 값으로 설정된다면 원소 n개에 대해서 n번, (n-1)번, (n-2)번...1번 의 비교가 필요하므로 시간 복잡도가 O(n^2) 된다.
- 하지만 평균 시간 복잡도는 O(nlogn)으로 매우 빠르다. pivot 값이 적절히 설정된다면 그 속도가 매우 빠르다. 따라서 pivot값을 잘 설정하는 것이 중요하다.
- 퀵 정렬은 중복된 키값이 순서대로 바뀌지 않을 수 있어 (예를 들어 {7,7,1}을 오름차순으로 퀵정렬해보라) not-stable 하다.
##### 구현
1. 데이터를 분할하는 pivot 을 설정
2. pivot 을 기준으로 pivot 보다 작은 요소들은 모두 pivot 의 왼쪽으로 옮기고 pivot 보다 큰 요소들은 모두 pivot 의 오른쪽으로 옮긴다.
3. pivot 을 제외한 왼쪽 리스트와 오른쪽 리스트를 다시 정렬한다.
   - 분할된 왼쪽 리스트와 오른쪽 리스트도 다시 pivot 을 정하고 pivot 을 기준으로 2개의 부분리스트로 나눈다.
   - 재귀를 사용하여 부분 리스트들이 더이상 분할이 불가능 할 때까지 반복한다.
    
## 병합 정렬
> 이미 정렬된 집합들을 하나로 병합하는 정렬
- 분할(Divide): 입력 배열을 같은 크기의 2개의 부분 배열로 분할한다.
- 정복(Conquer): 부분 배열을 정렬한다. 부분 배열의 크기가 충분히 작지 않으면 순환 호출 을 이용하여 다시 분할 정복 방법을 적용한다.
- 결합(Combine): 정렬된 부분 배열들을 하나의 배열에 합병한다.
##### 구현


## 기수 정렬
> 값을 비교하지 않고 데이터의 자릿수를 바탕으로 비교해 정렬
##### 구현

## 깊이 우선 탐색 DFS
> 시작 노드에서 출발하여 탐색할 한 쪽 분기 끝까지 탐색하고 다음 분기로 진행 
- 재귀함수로 구현
- 스택 이용
- 방문 리스트
```
n: 노드 개수
m: 에지 개수
A: 그래프 데이터 저장 - 인접 리스트 (2차원 배열)
V: 방문 리스트
for(n의 개수만큼 반복){
   A 인접 리스트 초기화
}

for(n의 개수만큼 반복){
   if(방문하지 않은 노드가 존재){
      연결 요소 개수++
      DFS()
   }
}

DFS {
   if(현재 노드 == 방문 노드) return
   V.add(현재 노드)
   for(i = 0 ~ 현재노드까지){
      if(현재 노드 != 방문 노드){
         DFS(i)
      }
   }
}
```

## 너비 우선 탐색 BFS
> 그래프 완전 탐색 방법 중 하나, 시작 노드에서 출발해 시작 노드를 기준으로 가까운 노드를 먼저 방문하며 탐색
- 선입선출
- Queue
- 방문리스트

[참고1](https://code-lab1.tistory.com)
[참고2](https://wikidocs.net/book/5895)