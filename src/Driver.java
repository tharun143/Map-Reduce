// Tells Hadoop how to run your Map-Reduce job

public void run(String inputPath, String outputPath) throws Exception
{
  // The job WordCount contains MapClass and Reduce
  JobConf conf = new JobConf(WordCount.class);
  conf.setJobName("mywordcount");
  // The keys are words
  (strings) conf.setOutputKeyClass(Text.class);
  // The values are counts (ints)
  conf.setOutputValueClass(IntWritable.class);
  conf.setMapperClass(MapClass.class);
  conf.setReducerClass(ReduceClass.class);
  FileInputFormat.addInputPath(conf, newPath(inputPath));
  FileOutputFormat.setOutputPath(conf, new Path(outputPath));
  JobClient.runJob(conf);
}
