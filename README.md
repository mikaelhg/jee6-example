Java EE 6 web profile application skeleton.

Requires quite a bit of memory, even for a trivial app, compared to a similar Spring app.

    export MAVEN_OPTS="-Xms512m -Xmx1024m -XX:PermSize=256m -XX:MaxPermSize=512m $MAVEN_OPTS"
    mvn-jrebel clean compile package embedded-glassfish:run
