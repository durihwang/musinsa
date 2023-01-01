# musinsa 재고 배송 시스템

# 설치 방법

## 빌드
```shell
 ./gradlew build
```

## 설치 및 실행
```shell
java -jar ./application/build/libs/application-1.0-SNAPSHOT.jar
```

# API

## 재고 현황 조회 API
### REQUEST
```shell
GET /product/prd-a?optionName=opt-aa HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Content-Length: 44

{
    "username" : "hwang",
    "age" : 20
}

GET /product/prd-a HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Content-Length: 44

{
    "username" : "hwang",
    "age" : 20
}
```
### RESPONSE
```shell
{
    "data": [
        {
            "productName": "prd-a",
            "optionName": "opt-aa",
            "quantity": 0
        }
    ]
}

{
    "data": [
        {
            "productName": "prd-a",
            "optionName": "opt-aa",
            "quantity": 0
        },
        {
            "productName": "prd-a",
            "optionName": "opt-ab",
            "quantity": 0
        }
    ]
}
```
## 재고 증가 처리 API
### REQUEST

### RESPONSE

## 재고 차감 처리 API
### REQUEST

### RESPONSE