JEE6 web profile application skeleton, in the middle of a port to JEE7.

Unfortunately, it looks like JSF, CDI and GlassFish versions weren't all the upwards compatible,
as the conversation scope from Apache CODI just doesn't work with GlassFish 4 as it worked with
GlassFish 3. The CDI @ConversationScoped solution doesn't look like it can clean up after itself.

It doesn't look like the GlassFish 4.0 maven-embedded-glassfish-plugin works quite yet, as even
the vendor's employees have documented, in blog posts, that the workaround is to use the old version.

Quite a bit of work to get a simple web application up and running, not to mention keeping it there.

    export MAVEN_OPTS="-Xms512m -Xmx1024m -XX:PermSize=256m -XX:MaxPermSize=512m $MAVEN_OPTS"

    mvn-jrebel clean compile package embedded-glassfish:run
