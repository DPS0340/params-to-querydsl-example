# params-to-querydsl-example

GetMapping 파라미터를 바로 QueryDSL predicate로 파싱하고, 이걸 통해 데이터를 가져오는 예제 코드가 거의 없어서 직접 만들었습니다.

## Sample queries

http://3.35.135.122:9095/cars

http://3.35.135.122:9095/company

http://3.35.135.122:9095/cars?name=모델%20X

```json
[
  {
    id: 6,
    name: "모델 X",
    company: {
      id: 6,
      name: "테슬라"
    }
  }
]
```

http://3.35.135.122:9095/cars?company.name=현대

```json
[
  {
    id: 1,
    name: "쏘나타",
    company: {
      id: 1,
      name: "현대"
    }
  }
]
```
