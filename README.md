## 1. 서비스 소개
<img src="https://user-images.githubusercontent.com/102223636/220829672-61f0b61a-7ea9-46af-b88f-e313ef027550.png" width="300" height="300"/>

* 서비스명 : 붕붕(BOONG-BOONG)
* 한줄 소개 : 어린이용 통학버스 탑승자 자동 관리 및 자녀 등하교 안심 서비스 <br>
* [🔗홍보 영상 URL](https://youtu.be/DHGc6q7RFUk) 

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
## 6. 서비스 화면
- 시연 순서 : 메인 화면 → 회원가입(학부모, 관리자) → 로그인(학부모, 관리자) → 관리자 등록 → 관리자 페이지 → 승하차 화면
1. 메인 화면<br>
<img src="https://user-images.githubusercontent.com/102223636/221101462-85cda464-138d-4775-b32f-7a69b1cf23c5.png" width="190" height="300"/>
2. 회원가입 (학부모, 관리자)<br>
<p>
<img src="https://user-images.githubusercontent.com/102223636/221101967-1095a632-871f-424d-9be9-81c3e4b72973.png" height="300"/>
<img src="https://user-images.githubusercontent.com/102223636/221102028-c367d4ee-61c4-416f-b401-bf967efb9e9c.png" height="300"/>
</p>
3. 로그인(학부모, 관리자)
<p>
<img src="https://user-images.githubusercontent.com/102223636/221122688-20ec5232-3e19-4154-9154-5468d01a5520.png" height="300"/>
<img src="https://user-images.githubusercontent.com/102223636/221122833-32e9f8f3-adba-4774-b504-ac2564bd5771.png" height="300"/>
</p>
4. 관리자 등록
<img src="https://user-images.githubusercontent.com/102223636/221122955-70d8deac-b050-485b-aff3-86e4de3e53be.png" height="300"/>
5. 관리자 페이지
<img src="https://user-images.githubusercontent.com/102223636/221123121-7c7a4fbd-a7ff-4a78-bb8e-fd21bcc0882a.png" height="300"/>
6. 승하차 화면
<p>
<img src="https://user-images.githubusercontent.com/102223636/221123298-93763eaf-b97b-4364-b4a1-0ca61300f2eb.png" height="300"/>
<img src="https://user-images.githubusercontent.com/102223636/221123421-bd15c452-a37a-47e7-84e1-58949d4e57bb.png" height="300"/>
</p>

---
## 7. 기대 효과 및 활용 분야
* 출발지부터 목적지까지 이동에서의 별도의 지속적인 모니터링 없이 자녀의 안전한 승하차를 알림받을 수 있다.
* 위급상황에 탑승자의 인적정보를 빠르게 확인함으로써 보다 신속하게 위치 파악, 도움 요청, 구조를 가능하게 할 수 있다.
* 사고 발생 시 버스에 부착된 QR코드를 통해 탑승자 정보를 알 수 있게 하여 구조 시 구조대원으로 하여금 탑승자 인적사항 파악과 구조를 용이하게 한다.
---
## 8. 기술 스택
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

## 9. 프로젝트 소감
<img src="https://user-images.githubusercontent.com/102223636/220970931-7c88e7cd-a3e3-47b4-b9c4-1710b568350a.png" width="650" height="300"/> <br>

* 이태곤 : AWS의 lightsail을 이용해서 서버를 배포함으로써 웹과의 통신 뿐만아니라 아두이노 보드와의 통신을 통해 값을 검증하고 클라이언트 화면에  결과 값을 응답해주는 전반적인 하드웨어와 소프트웨어 간의 소통, 협업을 배울 수 있었습니다.
* 이은지 :
* 유준호 : 임베디드 시스템 개발을 위한 아두이노 IDE와 리액트로 백엔드와의 통신 등을 구현해보며 단말 사이의 데이터 송/수신 방법을 경험해보고, 백/프론트 동시 협업 프로세스가 어떻게 진행되는 지 경험해볼 수 있었습니다.
* 여다영 : 이번 프로젝트를 통해 리엑트를 처음 다루어 봤는데 코드 재활용을 통해 코드를 보기 쉽게 표현할 수 있다는 점이 좋았다. 또, 프론트와 백의 API 통신을 처음 해봐서 신기했다.
