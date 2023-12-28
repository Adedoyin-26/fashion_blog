FROM amazoncorretto:17
WORKDIR /app
COPY target/fashion_blog-0.0.1-SNAPSHOT.jar /app/
EXPOSE 8085
EXPOSE 5432
ENTRYPOINT ["java", "-jar","/app/fashion_blog-0.0.1-SNAPSHOT.jar"]