import org.apache.spark.{SparkContext,SparkConf}
import com.datastax.spark.connector._
import org.apache.spark.sql.cassandra._
import org.apache.spark.sql.cassandra.CassandraSQLContext._

object sql {
	def main(args: Array[String]): Unit = {

		val conf = new SparkConf(true).set("spark.cassandra.connection.host", "192.168.82.69").setAppName("sparkSQL")

		val sc = new SparkContext(conf)

		val csc =new CassandraSQLContext(sc)

		csc.setKeyspace("ks_music")
		
		val result=csc.sql("SELECT * FROM albums WHERE performer='Hayden'")

		result.collect.foreach(println)
	
		

		csc.sql("INSERT INTO TABLE hayden SELECT title, country, year FROM albums WHERE albums.performer='Hayden'")
				
	}
}
