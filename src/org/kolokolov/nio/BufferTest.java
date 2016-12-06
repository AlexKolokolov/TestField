package org.kolokolov.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class BufferTest {
    public static void main(String[] args) {
        byte[] bytes = {97, 98, 99};
        
        ByteBuffer outputBuffer = ByteBuffer.allocate(16);
        ByteBuffer inputBuffer = ByteBuffer.allocate(16);
        
        try {
            Path path = Paths.get("./test/testNIO.txt");
            
            SeekableByteChannel channel = Files.newByteChannel(path, 
                    StandardOpenOption.CREATE, 
                    StandardOpenOption.WRITE,
                    StandardOpenOption.READ);
            
            outputBuffer.put(bytes);
            System.out.println("Output: " + Arrays.toString(outputBuffer.array()));
            
            outputBuffer.rewind();
            channel.write(outputBuffer);

            channel.position(3);
            outputBuffer.position(1);
            channel.write(outputBuffer);
            
            channel.position(5);
            outputBuffer.rewind();
            channel.write(outputBuffer);
            
            channel.position(0);
            channel.read(inputBuffer);
            
            System.out.println("Input: " + Arrays.toString(inputBuffer.array()));
        } catch (InvalidPathException | IOException e) {
            e.printStackTrace();
        }
    }
}
