FROM oracle/graalvm-ce:19.3.1-java8 as graalvm
#FROM oracle/graalvm-ce:19.3.1-java11 as graalvm # For JDK 11
RUN gu install native-image

COPY . /home/app/kafka-listener
WORKDIR /home/app/kafka-listener

RUN native-image --no-server --static -cp target/kafka-listener-*.jar

FROM scratch
EXPOSE 8080
COPY --from=graalvm /home/app/kafka-listener/kafka-listener /app/kafka-listener
ENTRYPOINT ["/app/kafka-listener", "-Djava.library.path=/app"]
