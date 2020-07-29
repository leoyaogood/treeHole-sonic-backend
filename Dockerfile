FROM java:8
#把jar包靠上去,命名为app.jar
COPY *.jar /app.jar

CMD ["-----server.port=8001"]
#暴露你的端口
EXPOSE 8001
#执行jar命令,启动app.jar
ENTRYPOINT ["java","jar","/app.jar"]
#部署到docker时,只需传Dockerfile和jar即可