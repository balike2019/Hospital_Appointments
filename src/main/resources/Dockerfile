

# Use the Alpine base image with OpenJDK 8
FROM openjdk:17-alpine

# Expose port 8081
EXPOSE 8081



# Add the JAR file to the image
ADD ${JAR_FILE} docker-demo.jar

# Print the content of the current directory for debugging
RUN echo "**** Begin Contents of the current directory ****"
RUN ls -al
RUN echo "**** Finished Contents of the current directory ****"

# Print the content of the target directory for debugging
RUN echo "**** Begin Contents of the target directory ****"
RUN ls -al target
RUN echo "**** Finished Contents of the target directory ****"

# Print the content of the target directory again for debugging
RUN echo "**** Begin Contents of the target/ directory ****"
RUN ls -al target/
RUN echo "**** Finished Contents of the target/ directory ****"

# Set the entry point to run the JAR file
ENTRYPOINT ["java", "-jar", "/docker-demo.jar"]