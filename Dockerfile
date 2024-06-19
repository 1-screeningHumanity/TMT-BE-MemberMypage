FROM openjdk:17
ENV TZ=Asia/Seoul
COPY build/libs/MemberMypageServer-0.0.1.jar MemberMypageServer.jar
ENTRYPOINT ["java", "-jar", "MemberMypageServer.jar"]