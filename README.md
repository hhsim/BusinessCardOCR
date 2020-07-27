# BusinessCardOCR
# Requires Maven 3.5.4 and JDK 8 installed

1. Download codes from github


2. Build and install program


[hostname]$ mvn clean

[hostname]$ mvn install

**Produce 2 jar files: BusinessCardOCR-1.0-SNAPSHOT.jar and BusinessCardOCR-1.0-SNAPSHOT-jar-with-dependencies.jar


3. Run the program

[hostname]$ cd ~/BusinessCardOCR/target

[hostname]$ java -jar BusinessCardOCR-1.0-SNAPSHOT-jar-with-dependencies.jar -f ../src/test/resources/example1.txt

Example 1:

ASYMMETRIK LTD

Mike Smith

Senior Software Engineer

(410)555-1234

msmith@asymmetrik.com



==>



Name: Mike Smith

Phone: 4105551234

Email: msmith@asymmetrik.com



[hostname]$ java -jar BusinessCardOCR-1.0-SNAPSHOT-jar-with-dependencies.jar -f ../src/test/resources/example2.txt

Example 2:

Foobar Technologies

Analytic Developer

Lisa Haung

1234 Sentry Road

Columbia, MD 12345

Phone: 410-555-1234

Fax: 410-555-4321

lisa.haung@foobartech.com



==>


Name: Lisa Haung

Phone: 4105551234

Email: lisa.haung@foobartech.com




[hostname]$ java -jar BusinessCardOCR-1.0-SNAPSHOT-jar-with-dependencies.jar -f ../src/test/resources/example3.txt


Example 3:

Arthur Wilson

Software Engineer

Decision & Security Technologies

ABC Technologies

123 North 11th Street

Suite 229

Arlington, VA 22209

Tel: +1 (703) 555-1259

Fax: +1 (703) 555-1200

awilson@abctech.com


==>


Name: Arthur Wilson

Phone: 17035551259

Email: awilson@abctech.com
