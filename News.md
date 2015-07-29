[Home](http://code.google.com/p/webster/) | [About](About.md) | [News](News.md)

  * 2011-02-26 - Fixed running with no port defaults to port 5000.

  * 2011-02-21 - The tests shipped with dumbster are working now, after i fixed them for my changes!  ` mvn package ` should be all you need.

  * 2011-02-21 - First day of coding, and first commit seems pretty solid with anecdotal testing.  Use at your own risk!  The tests that came from Dumbster are broken and I haven't written any of my own yet.  First order of business though.  When building alter the maven command to this until the tests are fixed: ` mvn -DskipTests=true package `.  When I have all the tests working, I'll upload a binary build, so you can download and deploy.