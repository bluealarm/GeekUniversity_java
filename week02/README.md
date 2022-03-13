# GC
javac -encoding UTF-8 -g GCLogAnalysis.java
java -XX:+PringGCDetails GCLogAnalysis

#压测
java -jar -Xmx1g -Xms1g gateway-server-0.0.1-SNAPSHOT.jar
sb -u http://localhost:8088/api/hello -c 20 -N 60

#总结
