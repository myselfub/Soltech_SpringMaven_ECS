# Soltech_SpringMaven_ECS
솔텍시스템-한국수자원공사 전력에너지 전주기 통합시스템 구축운영, eGovMaven, Websquare

- pom.xml 에러, Tomcat 에러, 404 에러 등 에러 발생 시
  1. 상단 메뉴바 Project-Clean
  2. Server의 Tomcat 우클릭 Clean, Server의 Tomcat 우클릭 Clean Tomcat Work Directory
  3. 프로젝트 우클릭 Run-Maven Clean
  4. 프로젝트 우클릭 Maven-Update Project(Force Update 체크)
  5. 프로젝트 우클릭 Run-Maven Install

- Server Properties 톰캣 변수 설정
  1. 톰캣 Run Configrations Arguments 수정. WAS 배포 시에는 Tomcat/conf/catalina.properties에 name=value만 기술한다. (WEBSQUARE_HOME=[WEBSQUARE_HOME])

     ```text
     -DWEBSQUARE_HOME="[WEBSQUARE_HOME]" -server -Xms1024m -Xmx4096m -XX:NewSize=512m -XX:MaxNewSize=4096m -XX:PermSize=1024m -XX:MaxPermSize=4096m -Djava.net.preferIPv4Stack=true -DURI_ENCODIG=UTF-8 -DMAX_HEADER_SIZE=2097152
     ```

     `-DWEBSQUARE_HOME`은 web.xml의 `${WEBSQUARE_HOME}`에서 사용한다.

  2. SQL Debug

     ```text
     -Dlog4jdbc.drivers=com.tmax.tibero.jdbc.TbDriver
     ```

- Log4j 취약점 Log4jShell 조치방안(2021.12.20)
  1. log4j를 2.15.0 이상으로 버전업한다. 단, JAVA 8이 필요하므로 2.13.0 이상 버전업도 가능하다.
     - 2.10.0 이상인 경우 Java 실행 인자 또는 환경 변수에 아래 값을 설정한다.

       ```text
       -Dlog4j2.formatMsgNoLookups=true
       LOG4J_FORMAT_MSG_NO_LOOKUPS=true
       ```

  2. 2.7.0 이상 사용 시 log4j 설정(log4j.xml 등)의 PatternLayout 속성에 있는 `%m` 부분을 `%m{nolookups}`로 교체한다.

     ECS는 PatternLayout 수정과 `org.apache.logging.log4j.core.lookup.JndiLookup.class` 파일 삭제를 완료했다.

     참고 사이트: https://effortguy.tistory.com/177

- SQL Console Debug
  1. `resources/log4jdbc.log4j2.properties`의 `#Debug` 참고

- Server Encoding, HttpHeaderSize 설정
  1. Tomcat server.xml에서 port가 8080인 `<Connector>`에 아래 속성을 추가한다.

     ```xml
     URIEncoding="UTF-8" maxHttpHeaderSize="2097152"
     ```

     또는

     ```xml
     URIEncoding="${URI_ENCODIG}" maxHttpHeaderSize="${MAX_HEADER_SIZE}"
     ```

- HTTPS 적용
  1. Tomcat server.xml의 기존 HTTP(port 8080)를 아래와 같이 수정한다.

     ```xml
     <Connector connectionTimeout="20000" port="8443" protocol="HTTP/1.1" redirectPort="8080" proxyPort="443" scheme="https" URIEncoding="${URI_ENCODIG}" maxHttpHeaderSize="${MAX_HEADER_SIZE}"/>
     ```

  2. SSL Connector는 아래 예시를 참고해 placeholder 기반으로 설정한다.

     ```xml
     <Connector port="8080" SSLEnabled="true" sslProtocol="TLS" scheme="https" secure="true" clientAuth="false" maxThreads="150"
       protocol="org.apache.coyote.http11.Http11Protocol"
       sslEnabledProtocols="TLSv1.1,TLSv1.2,TLSv1.3"
       keystoreFile="[KEYSTORE_PATH]" keystorePass="[KEYSTORE_PASSWORD]"
       keyAlias="[KEY_ALIAS]"
       SSLCertificateFile="[CERTIFICATE_PATH]"
       SSLCertificateKeyFile="[CERTIFICATE_KEY_PATH]"
       URIEncoding="${URI_ENCODIG}"
       maxHttpHeaderSize="${MAX_HEADER_SIZE}" />
     ```

- Tomcat Cache 기능 활성화
  1. server.xml의 Context를 아래와 같이 설정한다.

     ```xml
     <Context path="/ecs" docBase="ecs" reloadable="true" cachingAllowed="true" cacheMaxSize="100000" cacheTTL="300" />
     ```

- 다운로드 파일명 에러 시 `websquare_home/config/websquare.xml`을 UTF-8에서 ISO-8859-1로 변경한다.

- 톰캣 루트 페이지 설정 및 에러 화면 설정
  1. `Tomcat/webapps/ROOT/index.jsp`에 아래 내용을 추가한다.

     ```jsp
     location.href = "${pageContext.request.contextPath}/ecs";
     ```

  2. `Tomcat/webapps/ROOT/WEB-INF/views/common/serverError.jsp` 파일을 복사한다.
  3. Tomcat server.xml 가장 하단에 아래 내용을 추가한다.

     ```xml
     <Valve className="org.apache.catalina.valves.ErrorReportValve" showReport="false" showServerInfo="false" />
     ```

  4. Tomcat web.xml 가장 하단에 error-page 설정을 추가한다.

- Chrome DevTool에서 jQuery 사용 시 아래 코드를 입력한다.

  ```javascript
  var jq = document.createElement("script");
  jq.src = "https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js";
  document.getElementsByTagName("head")[0].appendChild(jq);
  jQuery.noConflict();
  ```
