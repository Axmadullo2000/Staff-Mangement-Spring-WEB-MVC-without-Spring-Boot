Staff Management CRUD Application 📋
A simple CRUD web application for managing staff members, built with pure Spring MVC (no Spring Boot), Thymeleaf for server-side templating, and an in-memory repository. This project demonstrates classic Spring MVC configuration and is packaged as a WAR for deployment on a servlet container like Apache Tomcat.
Ideal for learning core Spring MVC concepts without the conveniences of Spring Boot!
Features ✨

Add new staff (First Name, Last Name, Email)
View all staff in a responsive table
Update existing staff details
Delete staff with confirmation
Modern, mobile-friendly UI powered by Bootstrap 5 and Bootstrap Icons
In-memory storage (data resets on restart)

Screenshots 📸
(Add screenshots of your app here for better visualization on GitHub)

Home page: screenshots/index.png
Update page: screenshots/update.png

Example Views
Tech Stack 🛠️

Framework: Spring MVC 6.x (Spring 7.0.1)
Templating: Thymeleaf 3.1.3
View Styling: Bootstrap 5 (via CDN), Bootstrap Icons
Data Storage: In-memory ArrayList (custom repository)
Build Tool: Maven
Java Version: 17
Packaging: WAR (for external servlet container)
Annotations Processor: Lombok (optional, for reducing boilerplate)

Prerequisites 📋

Java 17 or higher
Maven 3.8+
Apache Tomcat 10+ (or any Jakarta EE 9+ compatible servlet container)
Download from: https://tomcat.apache.org/


Build & Deploy 🚀
1. Build the WAR file
   Bashmvn clean package
   This generates target/CRUD.war
2. Deploy to Tomcat

Copy target/CRUD.war to your Tomcat's webapps directory.
Start Tomcat:Bash# Navigate to Tomcat bin directory
cd /path/to/tomcat/bin
./startup.sh   # Linux/Mac
# or startup.bat on Windows
Tomcat will automatically deploy the app as http://localhost:8080/CRUD/

3. Access the Application
   Open in browser: http://localhost:8080/CRUD/
   Start adding and managing staff!
   Project Structure
   textsrc/
   ├── main/
   │   ├── java/com.pdp/          # Controllers, Entities, Repository, Config
   │   ├── resources/templates/   # Thymeleaf HTML files (index.html, update.html)
   │   └── webapp/WEB-INF/        # Optional web.xml (not needed for Servlet 3+)
   pom.xml                        # Dependencies and build config
   Future Improvements 💡

Replace in-memory repo with Spring Data JPA + H2/MySQL database
Add form validation (Bean Validation)
Integrate Spring Security
Migrate to Spring Boot for embedded server and auto-configuration

Contributing 🤝
Contributions are welcome! Fork, create a branch, commit changes, and open a Pull Request.
License 📄
MIT License – feel free to use and modify!
Made with ❤️ using classic Spring MVC. Star ⭐ if helpful!
