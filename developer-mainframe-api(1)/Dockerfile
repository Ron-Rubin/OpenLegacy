FROM amazoncorretto:17-al2023-headless
# MAINTAINER OpenLegacy <support@openlegacy.com>
# Constants
ENV JAR_FILE="developer-mainframe-api-1.0.0-SNAPSHOT.jar"
ENV APP_PATH="/usr/local"
# Copy your fat jar to the container
COPY "build/libs/$JAR_FILE" $APP_PATH/$JAR_FILE
COPY entrypoint.sh /
RUN chmod +x entrypoint.sh
# Use default user
USER 1000
# Launch the application
ENTRYPOINT ["./entrypoint.sh"]