# Web-backend-comento


## 1주차

### JDK 1.8 설치

JDK 다운로드( 1.8 버전 )   

환경변수 : 새로 만들기 클릭 후 '변수 이름 : JAVA_HOME', '변수값 : jdk 위치 디렉토리'로 설정   

Path 변수 편집 : %JAVA_HOME%\bin으로 경로 추가   

cmd 창 : javac 실행하여 동작하는지 확인   

### Eclipse, Spring 다운로드 및 설치   

- Eclipse IDE for Java EE developers 설치 (아이콘 모양에서 Java EE IDE)   
설치 완료 후 Eclipse.ini(eclipse 설치 경로에 존재)의 하단의 -vm C:\Program Files\Java\jdk1.8.0_221\bin\javaw.exe 추가   

- 인코딩 셋팅   
Preferences - Workspace - Text file encoding = Other : UTF-8   
Preferences - Web - JSP Files - Encoding : ISO 10646/Unicode(UTF-8)   

- Spring 설치   
Help > Eclipse MarketPlace에서 STS 검색   
Spring Tools 3 Add-On for Spring Tools 4.3.9.10-CI 설치   

### 톰캣 설정

Tomcat 9버전 다운로드 및 설치(경로 : eclipse와 동일)   

Window > preferences > server > Runtime Environment > ADD 클릭 후 Apache Tomcat v9.0 클릭 후 Next 

Name 설정 및 Browse에서 Tomcat의 경로 설정 후 Finish   

Eclipse 창에 Server 표시 : Window > Show View > Servers 클릭   

### Hello World 출력

스프링 프로젝트 생성 (File > New > Other, Spring > Spring Legacy Project)   

프로젝트 이름 작성 및 Spring MVC Project를 설정 후 Next 버튼 클릭, 패키지명 설정 후 Finish   

스프링 프로젝트 개발에 필요한 라이브러리를 Maven을 이용해 다운로드   

eclipse 프로젝트에서 최하단의 pom.xml에서 스프링 버전/JDK 버전 수정 (jkd 1.8, 스프링은 5.1.8, maven-compiler는 3.7.0)   

서버 세팅 : Servers 영역 New > Server 클릭 후 Server name 설정후 Next 클릭 후 해당 서버로 구동할 프로젝트를 우측 configured로 추가한 후 Finish   

localhost:8080/프로젝트명/ 으로 접속하면 Hello world가 정상적으로 실행된다   

### mariaDB, mySql WorkBench 설치 및 샘플 DB 구축

mariadb msi 다운로드 및 설치   

mysql workbench 설치   

Connections를 클릭하고 설정한 패스워드를 입력한 후 OK 클릭   

Create Shema 아이콘을 클릭하고 나온 Schema 내용을 설정 (Name : Theater, charset/Collation:utf8,utf8_bin)한 후 apply 클릭   

스키마 밑의 Tables 우측을 클릭하여 Create Table을 클릭하여 movie 테이블 생성 후 colum 설정   

좌측 상단 메뉴에서 SQL Script 메뉴 클릭 후 INSERT SQL문을 작성하여 실행(번개표시 아이콘)하여 데이터 삽입   

### 스프링, Mariadb, MyBatis 연동, 데이터 조회

pom.xml 수정 : mariadb, mybatis 관련 dependency 추가, log4jdbc-log4j2-jdbc4.1은 로그를 남기기 위한 라이브러리   

root-context.xml 수정 : 웹 이외의 부분을 셋팅하기 위해 존재  

datasource는 db연결 정보로 "로컬주소/스키마"로 이루어져있고, ID와 패스워드를 입력 (대표적인 것이 mybatis, mariadb)   

로그를 확인하기 위해 log4jdb를 property에 추가   

sqlsessionfactoryBean은 mariadb 설정기능을 사용하도록 세팅하고 mapperLocation 즉 sql 문을 mybatis/sql 경로에 있는 xml파일로 한다고 명시    

SqlSessionTemplate는 트랜잭션 관리와 쓰레드 처리, DB연결 및 종료를 관리하는 영역    

![image](https://user-images.githubusercontent.com/32132152/109479817-251d8a80-7abe-11eb-91b7-5dad49f210d2.png)

위의 그림과 같은 구조로 파일 생성   

그 후 자바 코드 작성   

Tomcat을 더블 클릭하고 URL 설정 부분의 path를 "/내용"에서 "/"로 변경하면 localhost:8080으로 바로 첫페이지 구동 가능   

![image](https://user-images.githubusercontent.com/32132152/109476576-6d3aae00-7aba-11eb-9be9-e8a590e4bc7b.png)

## 2주차

### API 가이드 문서 초안 작성

API 가이드 문서는 데이터를 어떻게 주고 받을 지에 대한 개발자간의 소통이다.   

클라이언트(프론트엔드)개발자가 서버에 어떤 값을 넘기면 어떤 데이터를 응답해줄지에 대한 내용을 정의한다.   

경우에따라 해당 데이터를 어떤 식으로 활용할 지 예시를 함께 작성하기도 한다. 그리고 어떤 데이터 포맷으로 응답할 지에 대한 예시도 문서로 함께 작성한다.   

어떤 URL로 어떤 파라미터를 넘겼을 때 어떤 응답이 오는지 확인 할 수 있다. 

해당 문서에서는 pathVariable 방식으로 응답을 요청하고, JSON 포맷으로 데이터를 응답하는 게 특징이다.  

그리고 API의 특징은 HTTP 통신으로 이루어지고 있다는 점이다.   

참고 : https://blog.naver.com/dktmrorl/222072210416 , https://not-null.tistory.com/26 , https://velog.io/@surim014/JSON%EC%9D%B4%EB%9E%80-%EB%AC%B4%EC%97%87%EC%9D%B8%EA%B0%80    
## 3주차   
    
### 스프링부트로 개발 환경 설정    
   
프로젝트 생성   
File > New > Project > Spring Boot > Spring Starter Project   
Type : Maven, Java Version : 8   
group : com.devfun    
artifact : settingweb_boot   
dependencies : Spring Boot DevTools, Mybatis Framework, Spring Web   
    
Pom.xml 수정     
부트 버전은 2.2.2.RELEASE로 변경    
    
application.properties 수정 (src/main/resources)    
port, contextpaht, view, db 등 각종 설정을 한 곳에서 진행    
suffix에 jsp를 줌으로써 /WEB-INF/views 아래에 jsp 파일로 자동으로 맵핑해주도록 한다.    
    
test.jsp와 settingTest.java로 기본 테스트 진행    
    
### 통계(SW활용현황) API를 위한 DB, Table 생성    
    
mysql workbench에서 DB, Table 생성문을 이용하여 DB, Table을 생성    
데이터는 임의로 넣어 사용    
    
### 스프링부트, Mybatis, mariadb 연동
     
mybatis 설정 (MybatisConfig.java) : MapperScan 어노테이션을 활용하여 스캔할 패키지를 입력      
     
mapper 작성 (StatisticMapper.java, statisticMapper.xml) : statisticMapper.xml 안에 쿼리 정의      
    
Service 작성 (StatisticService.java, StatisticServiceImol.java) : JSON을 만들기 위해 HashMap 형태로 Return. Hash Map에 값을 year, is_success, 쿼리로 가져온 cnt 값으로 json 값을 만든다.      
     
URL : http://localhost:8031/sqlyearStatistic?year=20    
조회하는 URL임으로 GET으로 조회를 하여 url에 parameter를 입력     
그 결과로 json 구조의 값이 나옴 확인 가능       

### SW 활용 현황 통계 API 구축을 위한 SQL 작성
월별 접속자 수      
일자별 접속자 수       
평균 하루 로그인 수      
부서별 월별 로그인 수      
           
## 4주차

### API 완성 및 API 가이드 보완

월별 접속자 수      
일자별 접속자 수      
평균 하루 로그인 수     
부서별 월별 로그인 수    

위의 API를 완성한 후, API 가이드 초안을 보완하여 API 가이드 완성        
        
![image](https://user-images.githubusercontent.com/32132152/111955305-abad1100-8b2c-11eb-8552-9e9522efdc94.png)
