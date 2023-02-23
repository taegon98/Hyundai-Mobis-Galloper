## 1. 서비스 소개
<img src="https://user-images.githubusercontent.com/102223636/220829672-61f0b61a-7ea9-46af-b88f-e313ef027550.png" width="300" height="300"/>

* 서비스명 : 붕붕(BOONG-BOONG)
* 한줄 소개 : 어린이용 통학버스 탑승자 자동 관리 및 자녀 등하교 안심 서비스 <br>
* [🔗소개 영상 URL](https://www.notion.so/API-f49199c0d8fb492a9c6a16155d655ef1) 

---

## 2. 프로젝트 진행 기간
* 현대모비스 Mobility SW Hackathon <br>
* 개발 기간 : 2023.2.12 ~ 2023.2.22 (약 10일) <br>
* Contributor<br>
<a href="https://github.com/taegon98/Hyundai-Mobis_Galloper/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=taegon98/Hyundai-Mobis_Galloper" />
</a>
<a href="https://github.com/Leeeeunji/algorithms/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=Leeeeunji/algorithms" />
</a>
<a href="https://github.com/Yodayeong/TIL/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=Yodayeong/TIL" />
</a>
<a href="https://github.com/yoo0221/resume/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=yoo0221/resume" />
</a>

---

## 3. 서비스 기획 배경 및 목적
* 도로교통공단의 TAAS 교통사고분석시스템에 따르면, 매년 어린이 교통사고로 인해 만 명 가량의 사상자가 나오고 있다고 한다.<br>
이에 대한 대응책으로 여러 법안이 개정되는 등 많은 제도적인 개편이 이루어졌다.<br>
그러나 통학버스로 인해 발생하는 사고는 대부분 운전자의 사각지대에서 발생하거나, 부주의로 인한 사고이기에 제도적인 개편만으로는 큰 효과를 볼 수가 없는 것이 현실이다. <br>
이에 우리는, 어린이의 안전한 등하굣길을 보장해주는 완전자율 어린이 통학 모빌리티인 ‘붕붕’을 제안한다. 해당 모빌리티는 완전자율 모빌리티로, 지문인식을 통해 탑승자의 승하차를 인식하여 모바일 어플리케이션을 이용하여 보호자에게 안내한다. 또한 각 탑승자의 안전벨트 착용여부 등 차량 탑승시의 안전을 보장한다.<br>
* [🔗관련기사 바로가기](https://www.donga.com/news/Society/article/all/20220714/114441208/1)
---
## 4. 시스템 구성 및 아키텍처
### 애플리케이션 서비스
* Front-end : 통학버스 운전자, 또는 승차 어린이 담당 보호자가 어린이의 승하차여부를 관리할 UI 화면으로, 여러 메뉴 입력으로부터 Back-end API에 데이터를 전달함.
* Back-end : 통학버스 관리자의 계정과 대상 버스의 일련번호, 어린이와 학부모의 계정을 서버에 저장하여, 특정 어린이의 승하차 여부를 학부모의 모바일 알림으로 잘 전달할 수 있도록 함.<br>
* [🔗API 명세](https://www.notion.so/API-f49199c0d8fb492a9c6a16155d655ef1) 
### 통학버스
* 탑승자 인식 : 좌석마다 비치된 지문 센서에 탑승 후 지문을 인식하면 애플리케이션에 등록된 지문으로 본인을 확인하여 학부모에게 승차 알림이 전송되도록 함.
* 충돌 처리 시스템 : 정/측면 충돌 감지 센서가 큰 충격을 감지하면 버스 기사에게 긴급 알림을 전송하고, 버스기사가 일정 시간 응답이 없으면 탑승자의 학부모에게 긴급 알림 전송 및 긴급전화 발신
버스에 탑승자 인적정보를 확인할 수 있는 QR코드를 부착하여 응급상황 발생 시 버스 탑승인원을 빠르게 알 수 있도록 함.
---
## 5. 주요 기능
* 모빌리티에 탑승할 시 모든 탑승자를 대상으로 한 지문 인식을 통해 탑승자를 파악한다.
* 모바일 어플리케이션과 자율 주행 모빌리티 간의 연동을 통해 자녀 등하교 안심 서비스를 부모에게 제공한다.
* 자녀 등하교 안심 서비스
  - 자녀의 승하차 시 (지문 인식 시) 학부모에게 알림 발송
  - 충돌 감지 센서가 큰 충격을 감지할 시 버스 기사에게 긴급 알림을 전송하고, 버스기사가 일정 시간 (10초) 응답이 없으면 학부모에게 긴급 알림 전송 및 긴급전화 발신
  - 버스에 QR코드를 부착하여, 충돌 감지 시에만 해당 QR으로 탑승자 정보를 확인할 수 있도록 하여 구조대원으로 하여금 탑승자 확인을 더욱 용이하게 한다.
---
## 6. 기대 효과 및 활용 분야
* 출발지부터 목적지까지 이동에서의 별도의 지속적인 모니터링 없이 자녀의 안전한 승하차를 알림받을 수 있다.
* 위급상황에 탑승자의 인적정보를 빠르게 확인함으로써 보다 신속하게 위치 파악, 도움 요청, 구조를 가능하게 할 수 있다.
* 사고 발생 시 버스에 부착된 QR코드를 통해 탑승자 정보를 알 수 있게 하여 구조 시 구조대원으로 하여금 탑승자 인적사항 파악과 구조를 용이하게 한다.
---
## 7. 기술 스택
* Backend - Spring
  - Java 11
  - SpringBoot 2.7.7
  - DB : Maria db 10.2.32
  - IDE : Intellij IDE

* Frontend
  - React : 18.2.0
  - JavaScript
  - IDE : VScode

* CI/CD
  - AWS lightsail
  - AWS rds

* H/W - Arduino IDE
  - 보드
    - Arduino Uno R3
  - 모듈
    - esp8266(와이파이)
    - as608(지문 센서)
    - sw-18010P(충격센서)
* ERD
<img src="https://user-images.githubusercontent.com/102223636/220561244-ab2b870e-256d-4bb4-a829-6e69b08f2f00.png" width="350" height="300"/>

## 8. 프로젝트 소감
<img src="https://user-images.githubusercontent.com/102223636/220913209-7cfafbaf-9632-4323-817d-f41cbd04effe.png" width="350" height="300"/> <br>

* 이태곤 : AWS의 lightsail을 이용해서 서버를 배포함으로써 웹과의 통신 뿐만아니라 아두이노 보드와의 통신을 통해 값을 검증하고 클라이언트 화면에  결과 값을 응답해주는 전반적인 하드웨어와 소프트웨어 간의 소통, 협업을 배울 수 있었습니다.
* 이은지 :
* 유준호 : 임베디드 시스템 개발을 위한 아두이노 IDE와 리액트로 백엔드와의 통신 등을 구현해보며 단말 사이의 데이터 송/수신 방법을 경험해보고, 백/프론트 동시 협업 프로세스가 어떻게 진행되는 지 경험해볼 수 있었습니다.
* 여다영 :  
