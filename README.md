roostrap
========

> Twitter Bootstrap Integrated Skin and User Interface Framework for Spring Roo 

Portions Copyright @ [Bhagya Nirmaan Silva]

Visit http://about.me/bhagyas

<3

Cheers.

Requirements
------------
- [Spring Roo 1.2.3]
- [Apache Maven 3.x]
- SpringSource Tool Suite (STS) Optional

Getting Started
--------------
1. Clone the project from github or download and extract.
 - `git clone https://github.com/bhagyas/roostrap.git`
2. Run the following command on your command prompt/terminal/shell.
 - `mvn tomcat:run`
3. Run the Spring Roo shell at the root and continue with customizing the code.
 - `roo`

Deploying on Google AppEngine
-------

1. Create a project in the Google AppEngine dashboard.
2. Get an application identifier. (eg: xyz)
3. Change the application identifier `<application/>` in the `src/main/WEB-INF/appengine-web.xml` to the created application identifier.
 - `<application>xyz</application>`
4. Run the following command in your shell.
 - `mvn gae:deploy`
5. Follow the instructions along the Maven plugin.
6. Visit `http://xyz.appspot.com` to view your application running!

Running the local development server with Google AppEngine
----------

1. Run the following command in the project root.
- `mvn gae:run`


Running in Tomcat
----------------

Since RooStrap is configured to use Google AppEngine, you need to change your persistence setup if you plan to change your persistence layer.

eg: You can change your persistence layer to Hibernate and a HYPERSONIC PERSISTENT database by running the following Roo command.
`persistence setup --database HYPERSONIC_PERSISTENT --provider HIBERNATE `


Update History
--------

**27 January 2013**
 - RooStrap demo running on Google AppEngine now available on http://roostrap.appspot.com

**26 January 2013**
 - Added support for Google AppEngine and a demonstration branch.
 - Added support for Google AppEngine Java SDK - 1.7.4 (Latest)
 - Added `maven-gae-plugin-repo` repository to `pom.xml`
 - Added `maven-gae-plugin` as a plugin to `pom.xml`
 - For more information on entity mapping on AppEngine please refer to [https://developers.google.com/appengine/docs/java/datastore/jdo/relationships#Unowned_Relationships]
 
**25 January 2013**
 - RooStrap updated to Spring Roo 1.2.3 and the following updated to the latest generally available (GA) versions: 
 - Bootstrap 2.2.0 from Twitter
 - JQuery 1.9.0 
 - [Select2] Integrated (Bootstrap DropDown with auto complete features)

**23 August 2012**
 - Initial release with Spring Roo 1.2.2 Support

Support or Contact
--

If you discover any issues, please report them over at github - or simply fork the project, fix it and then do a pull request. =)

With love.

[Select2]:http://ivaynberg.github.com/select2/
[Bhagya Nirmaan Silva]:http://about.me/bhagyas
[Spring Roo 1.2.3]:http://www.springsource.org/spring-roo
[Apache Maven 3.x]:http://maven.apache.org