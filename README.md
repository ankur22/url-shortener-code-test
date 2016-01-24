# Url Shortener Code Test

We'd like you to create a URL shortening service.
- It should have a route where you can send a POST request with a URL in the body, which
returns a short URL.
- When you send a GET request to a previously returned URL, it should redirect to the
POSTed URL.
- We'd also like a simple frontend that can create and display shortened URLs without
reloading the page.
- For simplicity, don't worry about persisting the URLs between restarts (ie, we don't
need it to talk to an external database).

Use whatever languages and frameworks you are comfortable with. Don't worry about getting
the whole thing working flawlessly, this is more to see how you structure a program. Please
don't spend more than a few hours on it.

## Submission

Please fork this repository, write some code and update this README with a guide of how to
run it.

##Setup Instructions

Install maven:
 - sudo apt-get install maven
Install the latest versin of JDK 8:
 - from http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

##Run Instructions

To run the tests and check configuration of system:
 - mvn package
To run the app:
 - Navigate to the root directory of UrlShortner
 - in termainl type: mvn spring-boot:run
 - Open your browser and navigate to localhost:8080
 - To shut down the web application, in terminal type: Ctrl+C

##About the Project

###End points:
 - Homepage
     - Url: /
     - Type: GET
     - returns a web page

 - Shorten Url
     - Url: /shorten
     - Needs to be an AJAX call
     - Type: POST
     - Body: Url to shorten
     - Return: Shortened Url in body of response, status 201

 - Reroute to new route
     - Url: /{id}
     - Type: GET
     - Path param with id
     - Redirect to original Url

Base URL: http://localhost:8080/

###Backend Technology:
 - Spring Boot
 - JDK 8

###Frontend Technology:
 - Javascript
 - CSS
 - HTML