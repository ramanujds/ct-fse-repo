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

### Install google chrome

```bash

sudo curl https://intoli.com/install-google-chrome.sh | bash
sudo mv /usr/bin/google-chrome-stable /usr/bin/google-chrome
google-chrome – version && which google-chrome

```

### Install Java

```bash
sudo apt install default-jdk



export JAVA_HOME=/opt/jdk1.8.0_282
export JRE_HOME=/opt/jdk1.8.0_282/jre
export PATH=$PATH:$JAVA_HOME/bin:$JRE_HOME/bin

```


### S3-Bucket Public Access Policy

```json
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "PublicReadGetObject",
            "Effect": "Allow",
            "Principal": "*",
            "Action": "s3:GetObject",
            "Resource": "arn:aws:s3:::cde20ij014-app/*"
        }
    ]
}

```


### Error Handling 

```java


@Controller
public class FoodAppController implements ErrorController {

	@Autowired
	RestTemplate rt;
	
	@Value("${cart-service.uri}")
	private String uri;
	
	
	
	@GetMapping("/get-food-info")
	public String getFoodInfo(@RequestParam("item-id") int itemId,@RequestParam("coupon-code") String couponCode, Model m) {
		try {
		CartDetails cartEntity=rt.getForObject(uri+"/cart/item/"+itemId+"/coupon/"+couponCode, CartDetails.class);
		
		}
		catch (HttpClientErrorException e) {
			m.addAttribute("code",e.getRawStatusCode());
			m.addAttribute("message", e.getStatusCode());
			return "error";
		}
		return "show-cart.jsp";
	}
	
	
	
	@PostMapping("/login")
	public String login(@ModelAttribute Credentials cred, HttpSession session) {
		AuthToken token=rt.postForObject("http://localhost:5000/public/authenticate/", cred, AuthToken.class);
		session.setAttribute("token", token.getJwtToken());
		return "home.jsp";
	}
	
	@Override
	public String getErrorPath() {
		
		return "error";
	}
	
	@GetMapping("/error")
	public String getErrorPage(HttpServletRequest request) {
		
		return "error.jsp";
	}
	
}


```


### Application.properties


```properties

server.port=7000
server.error.whitelabel.enabled=false


cart-service.uri = http://${cart-service-host:localhost}:${cart-service-host:localhost}

```
