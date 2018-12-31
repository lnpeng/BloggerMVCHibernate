# BloggerMVCHibernate
Blogs web application is a Spring MVC web app where a blogger can register, add a blog and see recent blogs.

# Description
`home.jsp`, `blogs.jsp`, `registerForm.jsp`, `profile.jsp` are **views** that welcome users, display recent blogs and provide forms to add a new blog and register themselves.

`HomeController`, `BlogsController` and `BloggerController` are **controllers** that handle requests and process forms. `HomeController`'s `home` method returns home view name. `BlogsController`'s `blogs` method uses a `BlogRepository` to retrieve recent blogs, places them on the **model** and returns view name; `saveBlog` method processes blog form and save a new blog to `BlogRepository`. `BloggerController` returns registration form's view name, processes the blogger registration form and save a new blogger to `BloggerRepository`, and redirects the request to a confirmation page. The view names are resolved by `InternalResourceViewResolver`.

`HibernateBlogRepository` and `HibernateBloggerRepository` are **Data Access Object (DAO)** that fetch a list of blogs, save a blog, query a blogger, and save a bloger via Hibernate. Hibernate is an open source persistence framework that provides not only basic object-relational mapping but also all the other features you would expect from a full-featured ORM tool, such as caching, lazy loading, eager fetching, and distributed caching.

The blogs database contains `blog` table with columns `id`, `message`, and `created_at`, `blogger` table with columns `id`, `username`, `password`, `first_name`, `last_name`, `email`. `Blogger` and `Blog` are the persistence entity classes mapped to database tables.

# Getting Started
## Prerequisites
- JDK 1.8
- Spring 4.3.10
- H2 Database 1.4.196
- JSTL 1.2
- Apache Commons Lang 3.1
- Hibernate 4.1.6.Final
- log4j 1.2.14
- slf4j 1.7.5

## Installing
- Create a local respository
```
git clone git@github.com:lnpeng/BloggerMVCHibernate.git
cd BloggerMVCHibernate
```
- Start Tomcat server
  - Switch to **Java EE perspective**
  - Click on **Servers** tab
  - Click on **No servers are available. Click this link to create a new server...**
  - Click **Tomcat Server** and **Next**
  - Select **Tomcat Installation Directory** and click **Finish**
  - You should see **Tomcat v8.5 Server at localhost [Stopped, Republish]** under **Servers** tab. Double click on it verify HTTP ports information. By default HTTP port is 8080.
  - Right click on **Server** and click **Start**
  
- Run the project on Tomcat server
  
## Running the tests
### Test the Blogs web application in Web Browser
- Launch the application from a web browser.
- Add blogs
![Blogs](https://github.com/lnpeng/BloggerMVCHibernate/blob/master/Screen%20Shot%202018-12-30%20at%207.19.31%20PM.png)

## Deployment
Deploy the project on [Tomcat](http://tomcat.apache.org/) server in Eclipse IDE.

# Build
- [Eclipse](https://www.eclipse.org/ide/) Dynamic Web Project
