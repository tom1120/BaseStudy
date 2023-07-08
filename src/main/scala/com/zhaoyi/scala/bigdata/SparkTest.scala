package com.zhaoyi.scala.bigdata

import com.zhaoyi.scala.bigdata.SparkTest.{fsShell, fileSystem}
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, FsShell, Path}
import org.apache.spark.{SparkConf, SparkContext}




class SparkTest{
  def init():Unit={
    val properties=System.getProperties
    properties.setProperty("HADOOP_USER_NAME", "hdfs")
    val configuration=new Configuration(true)
    fileSystem=FileSystem.get(configuration)
    val path=new Path("/user/spark")
    fsShell=new FsShell()
    fsShell.setConf(configuration)
    fsShell.run(Array[String]("-chmod", "-R", "777", "/user/spark"))

  }

  def upload():Unit={
    val src = new Path("D:/hivedata/README.md")
    val dest = new Path("/user/spark/")
    fileSystem.copyFromLocalFile(false, true, src, dest)
    fsShell.run(Array[String]("-chmod", "-R", "777", "/user/spark"))
  }



}

object SparkTest {
  var fileSystem:FileSystem=null
  var fsShell:FsShell=null

  def main(args: Array[String]): Unit = {
    val sparkTest=new SparkTest
    sparkTest.init()
    sparkTest.upload()

    val logFile = "/user/spark/README.md" // 应该是你系统上的某些文件
    val conf = new SparkConf().setAppName("appNameTest").setMaster("yarn")
      .set("spark.driver.host","192.168.96.18")
      .set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
//    Neither spark.yarn.jars nor spark.yarn.archive is set, falling back to uploading libraries under SPARK_HOME.
    conf.setJars(List("E:\\publicgit\\BaseStudy\\out\\artifacts\\spark_test\\spark-test.jar"))
    val sc=new SparkContext(conf)
    val logData = sc.textFile(logFile, 2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println("Lines with a: %s, Lines with b: %s".format(numAs, numBs))

  }
}
