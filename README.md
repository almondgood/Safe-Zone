# Say-Help

## 프로젝트 개요
- 강의명 : IoT 데이터 수집 변환
- 강의 기간 : 2024/03/15(금) ~ 2024/04/29(월)
- 프로젝트 이름 : Say-Help
- 프로젝트 기간 : 2024/03/19(화) ~ 2024/03/31(일), 13일 간 제작

<br>

### 제작 개요
1. 최근 묻지마 살인 사건 등 범죄가 빈번하게 발생하면서 범죄 대응 수단의 필요성이 높아짐.
2. 범죄 대응 수단으로 안심 귀갓길 제도 등을 도입하였으나 실효성이 부족하고 보완해야 할 점이 많다는 의견이 있음.
3. 따라서 범죄 실현 가능성을 낮추기 위해 대응 방법을 늘리는 방향으로 방안을 모색함.

<br>

### 제작 목표
1. AI를 활용하여 음성에서 특정 단어 추출, 텍스트 변환
2. 마이크로 음성을 수신하여 특정 단어 감지 시 경보
3. 음성 감지부터 경찰 신고까지 자율적으로 동작
4. 데이터베이스에 신고 로그 저장

<br>


### 팀원
- 나준환
- 오현창
- 유재욱
- 정우택


<br><br>

# 시스템 구성도

![image](https://github.com/almondgood/6aa-Iot-System/assets/88735581/b2737dfb-499c-4c0d-aa4f-3c1bdf95e453)


<br><br>

# 시스템 구조

## 1. 허브 서버(Raspberry PI)
- 각 모듈로부터 메시지를 수신하고 전달하는 TCP/IP Socket 허브 서버 
- 인터넷에 연결되어 웹 서버에 기기 등록 요청 및 신고 요청 기능

|**Socket 초기화**|**명령 수신 / 사건 신고**|
|:---:|:---:|
|![image](https://github.com/almondgood/6aa-Iot-System/assets/88735581/9f24487e-e30c-4959-a2eb-08a2498dcd6e)|![image](https://github.com/almondgood/6aa-Iot-System/assets/88735581/c4560efb-1678-4143-ba9f-e54edf4dc498)|
|`iot_server.py`|`iot_server.py`|

<br>

|**단말기 등록**|**REST 웹 서버 연결**|
|:---:|:---:|
|![image](https://github.com/almondgood/6aa-Iot-System/assets/88735581/e09145c9-52c2-43b3-ab27-0f64e5d006cd)|![image](https://github.com/almondgood/6aa-Iot-System/assets/88735581/218b43c2-9d35-4f4a-9bd3-7a47be40ad2d)|
|`Safebox.py`|`Safebox.py`|

<br>

## 2. 감시 카메라(Arduino, Jetson Nano)
- Arduino - 사건 발생 방향으로 조명 방향 조정
    - GPIO를 사용한 DC모터 제어
- Jetson Nano - 마이크로 수음하여 STT AI 모델에 데이터 전달

|**단말기 등록**|**STT**|
|:---:|:---:|
|![image](https://github.com/almondgood/6aa-Iot-System/assets/88735581/e09145c9-52c2-43b3-ab27-0f64e5d006cd)|![image](https://github.com/almondgood/6aa-Iot-System/assets/88735581/87a58239-dd47-4999-b53c-3deefc1f2d66)|
|`Arduino`|`Jetson Nano`|

<br>

## 3. 웹 서버(Spring)
- 단말기를 관리하고, 단말기로부터 신고를 접수하는 웹서버
- 단말기 시리얼 번호와 위치의, 등록 요청을 받으면 단말기에 UUID 발급
- 단말기의 UUID를 확인하여 위치를 확정, 접수 로그 저장

|**단말기 등록 요청 시 수신할 데이터**|**신고 시 수신할 데이터**|
|:---:|:---:|
|![image](https://github.com/almondgood/6aa-Iot-System/assets/88735581/3fb0d0d9-0fe2-41c1-9cfd-29bf2862fc98)|![image](https://github.com/almondgood/6aa-Iot-System/assets/88735581/ee8a8a6b-d25f-4670-96a9-8a0b740c5e6f)|
|`Request DTO`|`Request DTO`|
|||
|**단말기 DB 등록**|**경찰 신고 문자 전송**|
|![image](https://github.com/almondgood/6aa-Iot-System/assets/88735581/9a98b893-ee7d-4b84-9796-8dfc8766e51e)|![image](https://github.com/almondgood/6aa-Iot-System/assets/88735581/1639c936-8b03-404d-b76d-8185f8d839f2)|
|`Service Layer`|`Service Layer`|

<br><br>

# 결론
## 기대 효과
- 사건 발생 위치를 추적 가능하게 되면서 검거율 증가
- 기존의 신고 방식보다 적극적으로 신고 가능
- 골목길과 같은 취약 지역의 안전을 강화하여 범죄율 감소

<br>

## 추후 예정
- 실제 경찰과 연계하여 신고 기능 추가
- AI 모델을 개량하여 음성 오감지율 최소화






