# My Book Tracker
This web app can keep the track of any book the user is reading or have already read out of over <b>~24 million</b> books stored in Database. 

It is a full stack web application that is built to be highly scalabe and highly availabe.

# Technologies Used
  <b>Application Tier:</b> <a href=https://spring.io/projects/spring-boot target="_blank">Spring Boot</a>
  
  <b>Database:</b> Apache Cassandra
  
  <b>Data Layer:</b> Spring Data Cassandra
  
  <b>Security:</b> Spring Security
  
  <b>View Layer:</b> Thymeleaf
  
  <b>Cover API</b> used to retrieve cover image of books is from <a>https://openlibrary.org/developers/api</a>
  
  
  
  


# spring-github-login-starter
Starter Spring Boot project for OAuth login with GitHub

Simple starter for a Spring Boot Web application with GitHub OAuth support.

Steps:
1. Create a GitHub App and get the Client ID and Client Secret values. (Specify callback URL as `http://localhost:8080/login/oauth2/code/github` for development, uncheck Web hooks)
2. Add those values in `application.yml`
3. Run the Spring Boot App. You should be able to login with GitHub

This is a super minimal app. Post login, you will be redirected back to the login page, but you can validate the authorized principal is created by accessing the `/user` API. 
