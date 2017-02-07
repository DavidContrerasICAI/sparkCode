// scalastyle:off println
package wordcountscala

import scala.math.random

import org.apache.spark._

object WordCount {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Word Count")
    val sc = new SparkContext(conf)

    // create a SparkContext
    //val sc = new SparkContext("local[*]", "WordCount")

    //crear un RDD con el contenido del archivo don-quijote.txt.gz
    
    //val docs = sc.textFile("wordcountscala/data/donquijote.txt")
    //val docs = sc.textFile("hdfs://hadoopMaster:9000/bigfile.txt")
    //val docs = sc.textFile("wordcountscala/data/bigfile.txt")
    
    val docs = sc.textFile(args(0))

    // Convertir el texto de cada linea en minusculas
    val lower = docs.map(line => line.toLowerCase)

    // Separa cada linea del texto por palabras (strings separadas por espacio)
    // aplana/achata los arrays del comando split
    val words = lower.flatMap(line => line.split("\\s+"))

    // Crea un tuple (palabra, frecuencia)
    // la frecuencia inicial de cada palabra es 1
    val counts = words.map(word => (word, 1))

    // Agrupa por palabra y suma las frecuencias
    val freq = counts.reduceByKey(_ + _)

    // Inverte la tupla para (frecuencia, palabra)
    val invFreq = freq.map(_.swap)

    // Tomas las 20 mayores y las imprime
    invFreq.top(20).foreach(println)

  }
}
// scalastyle:on println
