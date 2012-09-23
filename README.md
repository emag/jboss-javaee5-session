jboss-javaee5-session
========================

What is it?
-----------

セッション管理を用いて、アクセスするたびにカウンタがインクリメントされます。  
ユースケースとしては、APサーバのセッションレプリケーション検証など。

System requirements
-------------------

+ Maven 3.0 or better
+ JavaEE5 Server (e.g. Tomcat6/JBoss5/etc.)
+ JDK6

Usage
------

### Build & Deploy ###
 
``` sh
$ cd /path/to/jboss-javaee5-session
$ mvn clean install package
$ cp target/jboss-javaee5-session-<version>.war $DEPLOY_DIR/jboss-javaee5-session.war
```

The application will be running at the following URL: <http://localhost:8080/jboss-javaee5-session/accesscounter>

### For wget ###

``` sh
$ wget --save-cookies cookies --keep-session-cookies http://localhost:8080/jboss-javaee5-session/accesscounter
$ wget --load-cookies cookies http://localhost:8080/jboss-javaee5-session/accesscounter
```