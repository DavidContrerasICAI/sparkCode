import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming._
import org.apache.spark.streaming.flume._
import org.apache.spark.streaming.flume.FlumeUtils._

object twitter{
	def main(args: Array[String]): Unit = {
	val conf = new SparkConf(true).setAppName("twitterStream")
	val ssc = new StreamingContext(conf, Seconds(1))
	
	val flumeStream = FlumeUtils.createStream(ssc, "localhost", 9999)

	flumeStream.print()
	
	
	ssc.start()
	ssc.awaitTermination()
	}
}
