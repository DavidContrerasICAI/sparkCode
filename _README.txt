scalac -classpath spark-core_2.10-1.3.0.jar:/home/spark/spark-1.6.2-bin-hadoop2.6/lib/spark-assembly-1.6.2-hadoop2.6.0.jar wordcountscala/WordCount.scala

jar -cvf wordcount.jar wordcountscala/WordCount*.class spark-core_2.10-1.3.0.jar /home/spark/spark-1.6.2-bin-hadoop2.6/lib/spark-assembly-1.6.2-hadoo

../bin/spark-submit --class wordcountscala.WordCount --master local wordcount.jar

../bin/spark-submit --class wordcountscala.WordCount --master spark://hadoopMaster:7077 wordcount.jar

 ../bin/spark-submit --class wordcountscala.WordCount --master spark://hadoopMaster:7077 wordcount.jar hdfs://hadoopMaster:9000/scene_list.txt
