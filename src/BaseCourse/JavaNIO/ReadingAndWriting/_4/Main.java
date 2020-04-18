package BaseCourse.JavaNIO.ReadingAndWriting._4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Main {
    public static void main(String[] args) {
        try(FileOutputStream binFile = new FileOutputStream("data.dat");
            FileChannel binChannel = binFile.getChannel()) {
//writing to buffer and flipping
            ByteBuffer buffer = ByteBuffer.allocate(100);
            byte[] outputBytes = "Hello World!".getBytes();
            byte[] outputBytes2 = "Nice to meet you".getBytes();
            buffer.put(outputBytes);
            int pos1 = outputBytes.length;
            buffer.putInt(245);
            int pos2 = pos1 + Integer.BYTES;
            buffer.putInt(-8348);
            int pos3 = pos2 + Integer.BYTES;
            buffer.putInt(1000);
            int pos4 = pos3 + Integer.BYTES;
            buffer.put(outputBytes2);

            buffer.flip();
            binChannel.write(buffer);

//reading using ByteBuffer
            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            FileChannel ch = ra.getChannel();
            ByteBuffer readBuffer = ByteBuffer.allocate(40);
            ch.read(readBuffer);
            readBuffer.flip();

            byte[] inputString = new byte[outputBytes.length];
            //filling array with data with get() method
            readBuffer.get(inputString);
            System.out.println("input String: " + new String(inputString));
            System.out.println(readBuffer.getInt());
            System.out.println(readBuffer.getInt());
            System.out.println(readBuffer.getInt());
            inputString = new byte[outputBytes2.length];
            readBuffer.get(inputString);
            System.out.println("input String 2: " + new String(inputString));


        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
