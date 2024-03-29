# archi
과제

1.단순 Response API 개발
GET.
endpoint: localhost:8080/health
request: none
response: "1"

2.Open API 조회 개발
GET.
endpoint: localhost:8080/cylinder
request: none
response:
{
    "name": "[샘플] FLOOR COMPOSITION",
    "editor_asset": {
        "two_d": "https://resources.archisketch.com/product/YB0Njg-02923BC5C1A84C59/03-05-2022_05-41-12/2d/editor.png",
        "three_d": "https://resources.archisketch.com/product/YB0Njg-02923BC5C1A84C59/03-05-2022_05-41-12/3d/YB0Njg-02923BC5C1A84C59.gltf",
        "dxf_url": null,
        "decimate": "https://resources.archisketch.com/product/YB0Njg-02923BC5C1A84C59/03-05-2022_05-41-12/decimated/YB0Njg-02923BC5C1A84C59_decimated.gltf" 
    }
}

4.데이터 저장 API 개발
POST.
endpoint: localhost:8080/cylinder/info
request:
    {
        "user": "1234",
        "password": "afasdf"
    }
response:
    {
        "user": "1234",
        "password": "afasdf",
        "message": "Success"
    }

3.조회 API 개발
GET.
endpoint: localhost:8080/sigungu
request:
    Request Params: pidLocCode
    pidLocCode=1114000000
response:
    {
        "pid_loc_code": 1114000000,
        "level": 2,
        "depth1": "서울특별시",
        "depth2": "중구",
        "depth3": "none",
        "lt_lng": 126.96155,
        "lt_lat": 37.543857,
        "rb_lng": 127.026797,
        "rb_lat": 37.572022,
        "date_creation": "2018-08-24T15:16:31"
    }

5.데이터 구조화 및 API 개발
GET.
endpoint: localhost:8080/api/apartment/search?name=&roadAddress=&lotNumberAddress=&extensionType=&typePrefix=&sortOrder=
주의: name,roadAddress,lotNumberAddress에는 꼭 한가지 value가 들어가야함 -> 그리고 부가적으로 extensionType (BASIC,EXTENDED),typePrefix (ex)112B,112C일 경우 112로만 검색),sortOrder(asc,desc)
request:
    Request Params: name
    Request Params: roadAddress
    Request Params: lotNumberAddress
    Request Params: extensionType
    Request Params: typePrefix
    Request Params: sortOrder
response:
ex) name : 롯데캐슬리버파크시그니처
[
    {
        "id": 17,
        "exclusive_area": 59.97,
        "supplied_area": 84.84,
        "blueprint_image": "2222",
        "type": "84A",
        "extension_type": "BASIC",
        "apartment": {
            "id": 3,
            "name": "롯데캐슬리버파크시그니처",
            "created_at": "2024-03-29T00:15:26.837348",
            "updated_at": null
        },
        "created_at": "2024-03-30T00:15:26.837348",
        "updated_at": null
    },
    {
        "id": 18,
        "exclusive_area": 59.97,
        "supplied_area": 85.54,
        "blueprint_image": "2222",
        "type": "85B",
        "extension_type": "EXTENDED",
        "apartment": {
            "id": 3,
            "name": "롯데캐슬리버파크시그니처",
            "created_at": "2024-03-29T00:15:26.837348",
            "updated_at": null
        },
        "created_at": "2024-03-30T00:15:26.837348",
        "updated_at": null
    },
    {
        "id": 19,
        "exclusive_area": 84.98,
        "supplied_area": 111.85,
        "blueprint_image": "2222",
        "type": "111A",
        "extension_type": "BASIC",
        "apartment": {
            "id": 3,
            "name": "롯데캐슬리버파크시그니처",
            "created_at": "2024-03-29T00:15:26.837348",
            "updated_at": null
        },
        "created_at": "2024-03-30T00:15:26.837348",
        "updated_at": null
    },
    {
        "id": 20,
        "exclusive_area": 84.99,
        "supplied_area": 112.14,
        "blueprint_image": "2222",
        "type": "112B",
        "extension_type": "BASIC",
        "apartment": {
            "id": 3,
            "name": "롯데캐슬리버파크시그니처",
            "created_at": "2024-03-29T00:15:26.837348",
            "updated_at": null
        },
        "created_at": "2024-03-30T00:15:26.837348",
        "updated_at": null
    },
    {
        "id": 21,
        "exclusive_area": 84.89,
        "supplied_area": 112.94,
        "blueprint_image": "2222",
        "type": "112C",
        "extension_type": "BASIC",
        "apartment": {
            "id": 3,
            "name": "롯데캐슬리버파크시그니처",
            "created_at": "2024-03-29T00:15:26.837348",
            "updated_at": null
        },
        "created_at": "2024-03-30T00:15:26.837348",
        "updated_at": null
    },
    {
        "id": 22,
        "exclusive_area": 84.85,
        "supplied_area": 113.08,
        "blueprint_image": "2222",
        "type": "113D",
        "extension_type": "BASIC",
        "apartment": {
            "id": 3,
            "name": "롯데캐슬리버파크시그니처",
            "created_at": "2024-03-29T00:15:26.837348",
            "updated_at": null
        },
        "created_at": "2024-03-30T00:15:26.837348",
        "updated_at": null
    },
    {
        "id": 23,
        "exclusive_area": 101.98,
        "supplied_area": 129.80,
        "blueprint_image": "2222",
        "type": "129A",
        "extension_type": "BASIC",
        "apartment": {
            "id": 3,
            "name": "롯데캐슬리버파크시그니처",
            "created_at": "2024-03-29T00:15:26.837348",
            "updated_at": null
        },
        "created_at": "2024-03-30T00:15:26.837348",
        "updated_at": null
    },
    {
        "id": 24,
        "exclusive_area": 101.99,
        "supplied_area": 131.50,
        "blueprint_image": "2222",
        "type": "131B",
        "extension_type": "BASIC",
        "apartment": {
            "id": 3,
            "name": "롯데캐슬리버파크시그니처",
            "created_at": "2024-03-29T00:15:26.837348",
            "updated_at": null
        },
        "created_at": "2024-03-30T00:15:26.837348",
        "updated_at": null
    },
    {
        "id": 25,
        "exclusive_area": 122.47,
        "supplied_area": 162.00,
        "blueprint_image": "2222",
        "type": "162",
        "extension_type": "BASIC",
        "apartment": {
            "id": 3,
            "name": "롯데캐슬리버파크시그니처",
            "created_at": "2024-03-29T00:15:26.837348",
            "updated_at": null
        },
        "created_at": "2024-03-30T00:15:26.837348",
        "updated_at": null
    }
]