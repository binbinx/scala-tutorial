import scala.collection.mutable._
import scala.util._
import java.awt.datatransfer._
//import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.JavaConverters._

object Chapter3 extends App{

  println("Problem 1")
  val size = Math.abs(Random.nextInt(100));
  val randomArray = for (i <- 0 until size) yield Random.nextInt(size)
  println(size + ":" + randomArray)

  println("Problem 2")
  def swapAdjacent(nums:ArrayBuffer[Int]) = {
    for (index <- 0 to nums.length-1 by 2 if index+1<=nums.length-1)
      {
        val temp = nums(index)
        nums(index) = nums(index+1)
        nums(index+1) = temp
      }
    nums
  }
  val array = ArrayBuffer(1, 2, 3, 4, 5, 6, 7)
  println(swapAdjacent(array))

  println("Problem 3")
  def swapAdjacentV2(nums:ArrayBuffer[Int]) = {
    for (index <- 0 until nums.length)
      yield if(index%2==0&&index+1<nums.length) nums(index+1) else if(index%2==1) nums(index-1) else nums(index)
  }
  println(swapAdjacentV2(ArrayBuffer(1, 2, 3, 4, 5, 6, 7)))

  println("Problem 4")
  def extractPositiveFromArray(nums:ArrayBuffer[Int]) =
  {
    val positiveNums = for (n <- nums if n>0) yield n
    val nonPositiveNums = for (n <- nums if n<=0) yield n
    positiveNums.insertAll(positiveNums.length, nonPositiveNums)
    positiveNums
  }
  println(extractPositiveFromArray(ArrayBuffer(1, -3, 0, 4, 3, -2, -8, 16)))

  println("Problem 5")
  def averageDouble(array:Array[Double]) = {
    if (array.length>0) array.sum/array.length
  }
  println(averageDouble(Array(1.0,2.0,3.0,100)))

  println("Problem 6")
  def reverseSort(array:Array[Int]) = {
    Sorting.quickSort(array)
    for (index<-0 until array.length/2) {var temp=array(index)
      array(index)=array(array.length-index-1)
      array(array.length-index-1)=temp}
  }
  var l0 = Array(1, 10, 3, 5, 0, 8)
  reverseSort(l0)
  println(l0.mkString(" "))

  println("Problem 7")
  def reverseSortV2(array:ArrayBuffer[Int]) = {
    array.sortWith(_>_)
  }
  println(reverseSortV2(ArrayBuffer(1, 10, 3, 5, 0, 8)))

  println("Problem 8")
  println(Array(1,2,3,3,0,0,7).distinct.mkString(" "))

  println("Problem 9")
  def removeNegativeExceptFirst(array:ArrayBuffer[Int]) =
  {
    val indices = for (index <- 0 until array.length if array(index)<0) yield index
    val indicesMod = indices.drop(1).reverse
    for (index <- indicesMod) array.remove(index)
    array
  }
  println(removeNegativeExceptFirst(ArrayBuffer(0, 3, 200, -23, -55, 68, 98, -160, 59, -3, 5)))

  println("Problem 10")
  def removeNegativeExceptFirstV2(array:ArrayBuffer[Int]) =
  {
    var nIndices = for(index <- 0 until array.length if (array(index))<0) yield index
    nIndices = nIndices.drop(1)
    var indicesToModify = ArrayBuffer[Int]()
    var indicesTarget = ArrayBuffer[Int]()
    var shift = 1
    for (i <- 0 until nIndices.length)
      {
        val len = indicesToModify.length
        if (i<nIndices.length-1)
        {
          indicesToModify.insertAll(indicesToModify.length, (nIndices(i)+1) to (nIndices(i+1)-1))
        }
        else
        {
          indicesToModify.insertAll(indicesToModify.length,(nIndices(i)+1) to array.length-1)
        }
        for (i <- len until indicesToModify.length) indicesTarget.append(indicesToModify(i) - shift)
        shift += 1
      }
    for (i <- 0 until indicesTarget.length) array(indicesTarget(i)) = array(indicesToModify(i))
    val dropLen = array.length - indicesTarget.last - 1
    array.dropRight(dropLen)
  }
  println(removeNegativeExceptFirstV2(ArrayBuffer(0, 3, 200, -23, -55, 68, 98, -160, 59, -3, 5)))

  println("Problem 11")
  println(java.util.TimeZone.getAvailableIDs
    .filter(_.startsWith("America/"))
    .map(_.replace("America/", ""))
    .sorted.mkString(" "))

  println("Problem 12")
  val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
  val imageFlavors:Buffer[String] = flavors.getNativesForFlavor(DataFlavor.imageFlavor).asScala
  val imageFlavorsList = imageFlavors.asJava
  println(imageFlavors)
  println(imageFlavorsList)
}
