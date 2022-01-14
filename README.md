# 스프링 MVC 1
    0. Web Server, WAS(웹서버 기능 포함) - HTTP 기반으로 동작!
      * 분리 사용 이유: 서버 과부화, 정적 리소스(이미지,CSS,JS), WAS 장애시 오류 화면 노출, 효율적인 자원 관리(정적,동적) 
      - Client -> Web Server -> WAS -> DB
      - 웹서버(Apache): 정적(Resources) 
      - WAS(Tomcat): 동적(Application Logic) + Web Server, HTTP 응답 처리, 서블릿 컨테이너
    1.서블릿
      - Request, Response 객체를 새로 만들어서 Servlet 객체 호출
      - HttpServletRequest: HTTP 요청 정보
      - HttpServletResponse: HTTP 응답 정보
      - 'JSP' -> 'Servlet'으로 변환 되어서 사용
      - 멀티 쓰레드 지원
    2.동시 요청 - 멀티 쓰레드
      - Java Main() 실행하면 main이라는 쓰레드가 실행
      - 요청 마다 쓰레드 생성 방식 단점: 쓰레드 생성에 제한이 없어 자원에 한계와 서버 다운, 생성 비용이 큼
      - 쓰레드 풀: 필요한 쓰레드를 풀에 보관, 쓰레드 최대치가 설정되어있어 기존 요청은 안정 보장, 'max thread 튜닝'
      - 대응 방안: 서버 증설(클라우드) -> WAS 튜닝
      - Tool: 아파치 ab, 제이미터
    3.HTML, HTTP API, SSR, CSR
      - 정적 리소스(정적)
      - HTML 페이지(동적)
      - HTTP API: JSON 데이터 통신, 웹 클라이언트(React.js, Vue.js)
      - 서버 사이드 렌더링: 서버단에서 동적으로 HTML 생성 -> 웹 브라우저 전달, (JSP, 타임리프)
      - 클라이언트 사이드 렌더링: JS를 사용해 웹 브라우저에서 동적으로 HTML 생성 (React, Vue.js) - 구글 지도
    4.자바 웹 기술 역사
      - 애노테이션 기발의 스프링 MVC 등장 -> @Controller
      - 스프링 부트의 등장 ->  WAS 내장
      - Spring MVC >>> Spring WebFlux(함수형 프로그래밍, 비동기 처리)
    5.프로젝트 생성
      - Java11, War, Gradle, Spring-Web, Lombok , Postman
      - @ServletComponentScan // 서블릿 자동 등록
    6.Hello 서블릿
      - HelloServlet -> webapp/basic/index.html <- Welcome Page
    7.HttpServletRequest - 개요
      - 임시 저장소: request.setAttribute(key, value) <-> request.getAttribute(key)
      - 세션 관리: requset.getSession(create: true)
    8.HttpServletRequest - 기본 사용법
    9.HTTP 요청 데이터 - 개요
