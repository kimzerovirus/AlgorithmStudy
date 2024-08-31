## How to build and run kotlin?

컴파일하기
```shell
kotlinc Test.kt
```

컴파일을 실행하면 `TestKt.class`라는 이름의 바이트 코드 파일을 생성한다.

```shell
java TestKt
```

java 기본 디스어셈블러인 javap를 통해 살펴보기
```shell
javap -c TestKt.class
```

디컴파일하기
```shell
java -jar cfr-0.152.jar TestKt.class
```