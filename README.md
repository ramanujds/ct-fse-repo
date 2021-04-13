# ct-fse-repo

## Instructions
* Use the following json values

```json

{
      
        "projectId": 252525,
        "projectTitle": "Ecom App",
        "stratDate": "1995-02-24",
        "trainees": [
        {
            "traineeId": 212121,
            "traineeName": "Rajesh",
            "email": "rajesh@gmail.com",
            "dob": "1995-02-24"
           
        },
         {
            "traineeId": 222222,
            "traineeName": "Mahesh",
            "email": "mahesh@gmail.com",
            "dob": "1995-02-24"
           
        }
    ]
       
    }

```

## SonarCube Steps

* Step 1 - Download Sonar Cube 

	* __set 'wrapper.java.command property' present in 'conf\wrapper.conf' value to 'java/bin path'__

* Step 2 - Extract and run StartSonar.bat

* Step 3 - Add Dependency to pom.xml

```xml

<dependency>
	<groupId>org.sonarsource.scanner.maven</groupId>
  		<artifactId>sonar-maven-plugin</artifactId>
    	<version>3.6.0.1398</version>
</dependency>

```


* Step 4 - Add global maven settings

- .m2/settings.xml

```xml

<settings>
    <pluginGroups>
        <pluginGroup>org.sonarsource.scanner.maven</pluginGroup>
    </pluginGroups>
    <profiles>
        <profile>
            <id>sonar</id>
            <activation>
                <activeByDefault>true</activeByDefault>
            </activation>
            <properties>
                <!-- Optional URL to server. Default value is http://localhost:9000 -->
                <sonar.host.url>
                  http://localhost:9000
                </sonar.host.url>
            </properties>
        </profile>
     </profiles>
</settings>

```

* Step 5 - Run as Maven Build with Goal as ** clean verify sonar:sonar -Dsonar.login=[token] **

* Step 6 - visit localhost:9000

## Important Docker Commands

```bash
docker run -d -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=mydb -e MYSQL_USER=docker -e MYSQL_PASSWORD=password -p 3308:3306 --name mysql mysql


docker network create cts-mysql-network

docker container run -p 5000:8080 -e RDS_HOSTNAME=mysql -e RDS_PORT=3306 -e RDS_USERNAME=docker -e RDS_PASSWORD=password -e RDS_DB_NAME=mydb --network=cts-mysql-network --name truyum truyum:0.0.1-SNAPSHOT


docker run -d -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=mydb -e MYSQL_USER=docker -e MYSQL_PASSWORD=password -p 3308:3306 --name mysql --volume mysql-db-volume:/var/lib/mysql --network=cts-mysql-network mysql

```
