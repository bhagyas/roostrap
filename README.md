roostrap 
========

> Twitter Bootstrap Integrated Skin and User Interface Framework for Spring Roo 

Portions Copyright @ [Bhagya Nirmaan Silva]

Visit http://about.me/bhagyas

<3

Cheers.

Build Status
------------
[![Build Status](https://travis-ci.org/bhagyas/roostrap.png?branch=master)](https://travis-ci.org/bhagyas/roostrap)

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
 - `mvn appengine:devserver`
3. Run the Spring Roo shell at the root and continue with customizing the code.
 - `roo`

Deploying on Google AppEngine
-------

1. Create a project in the Google AppEngine dashboard.
2. Get an application identifier. (eg: xyz)
3. Change the application identifier `<application/>` in the `src/main/WEB-INF/appengine-web.xml` to the created application identifier.
 - `<application>xyz</application>`
4. Run the following command in your shell.
 - `mvn appengine:update`
5. Follow the instructions along the Maven plugin.
6. Visit `http://xyz.appspot.com` to view your application running!

Running the local development server with Google AppEngine (default)
----------

1. Run the following command in the project root.
- `mvn appengine:devserver`


Running in Tomcat
----------------

Since RooStrap is configured to use Google AppEngine, you need to change your persistence setup if you plan to change your persistence layer.

eg: You can change your persistence layer to Hibernate and a HYPERSONIC PERSISTENT database by running the following Roo command.
`persistence setup --database HYPERSONIC_PERSISTENT --provider HIBERNATE `

If you are running on Hypersonic and Hibernate, you have to change the following annotations in your entity definitions.

`@RooJpaActiveRecord(identifierType = String.class, versionType = Long.class)` to `@RooJpaActiveRecord`


Update History
--------
**8 May 2014**
 - Updated Google AppEngine SDK version to 1.9.3 (released 28 April 2014)

**11 January 2014**
 - Refactored the code base and major version updates to libraries.
 - Updated Google AppEngine SDK version to 1.8.8 (released 19 November 2013)
 - Updated to Bootstrap v3.0.3 
 - Updated to Spring Roo version 1.2.5 and Spring version to 3.2.6 (latest GA)
 - Added official Google AppEngine Maven plugin
 - Roostrap celebrates 3 years of continuous updates!
 
**20 August 2013**
 - Added support for Bootstrap 3 (released 19 August 2013) 
 - With support for Bootstrap 3, now Roostrap is fully supported on mobile devices with a completely responsive layout.
 - RooStrap updated to Spring Roo 1.2.4
 - Notes: Woah, thanks for the amazing responses it's been a great year for Roostrap!
 
**22 March 2013**
 - Minor stylesheet order changes

**27 January 2013**
 - RooStrap demo running on Google AppEngine now available on http://roostrap.appspot.com

**26 January 2013**
 - Added support for Google AppEngine and a demonstration branch.
 - Added support for Google AppEngine Java SDK - 1.7.4 (Latest)
 - Added `maven-gae-plugin-repo` repository to `pom.xml`
 - Added `maven-gae-plugin` as a plugin to `pom.xml`
 
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
