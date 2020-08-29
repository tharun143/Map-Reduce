public static class MapClass extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable>
{
  private final static IntWritable one = new IntWritable(1);
  private Text word = new Text();
  
  public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter)
  {
    throws IOException
    {
      String line = value.toString();
      StringTokenizer itr = new StringTokenizer(line);
      while(itr.hasMoreTokens())
      {
        word.set(itr.nextToken());
        output.collect(word, one);
      }
    }
  }
}
