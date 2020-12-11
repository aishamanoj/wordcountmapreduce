import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.lang.String;
public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {


 @Override
 public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
     String line=value.toString();
     String[] dict=line.split("\n");
     int n=1;
     for (String word: dict){
         if (word.toLowerCase().contains("dec")){
             context.write(new Text("Dec"), new IntWritable(n));
         }
         if (word.toLowerCase().contains("java")){
            context.write(new Text("Java"), new IntWritable(n));
         }
        if (word.toLowerCase().contains("hackathon")){
            context.write(new Text("Hackathon"), new IntWritable(n));
         }
        if (word.toLowerCase().contains("chicago")){
            context.write(new Text("Chicago"), new IntWritable(n));
        }
     }