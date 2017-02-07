import org.apache.spark.{SparkContext,SparkConf}
import com.datastax.spark.connector._

case class FoodToUserIndex(food: String, user: String)

object Cass {
  def main(args: Array[String]): Unit = {

	val conf = new SparkConf(true).set("spark.cassandra.connection.host", "192.168.82.69")

	val sc = new SparkContext(conf)
	

	val user_table = sc.cassandraTable("llave", "user")

	val food_index = user_table.map(r => new FoodToUserIndex(r.getString("favorite_food"), r.getString("name")))

	food_index.saveToCassandra("llave", "food_to_user_index")
  }
}

