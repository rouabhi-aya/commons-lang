FROM maven:3.9-eclipse-temurin-21

WORKDIR /commons-lang

COPY . .

RUN mvn clean compile -DskipTests -Drat.skip=true

CMD ["mvn", "test", "-Drat.skip=true"]