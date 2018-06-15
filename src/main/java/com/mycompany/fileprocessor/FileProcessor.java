package com.mycompany.fileprocessor;

import com.mycompany.fileprocessor.domain.service.RegisterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

public class FileProcessor {

    public static void main(String[] args) throws IOException, InterruptedException {
        RegisterService service = new RegisterService();
        WatchService watchService
                = FileSystems.getDefault().newWatchService();

        Path inputPath = Paths.get(
                System.getProperty("user.home")
                        .concat(File.separator)
                        .concat("data")
                        .concat(File.separator)
                        .concat("in"));
        Path outputPath = Paths.get(
                System.getProperty("user.home")
                        .concat(File.separator)
                        .concat("data")
                        .concat(File.separator)
                        .concat("out"));

        inputPath.register(
                watchService,
                StandardWatchEventKinds.ENTRY_CREATE
        );

        WatchKey key;
        while ((key = watchService.take()) != null) {
            for (WatchEvent<?> event : key.pollEvents()) {

                String filename = event.context().toString();

                if (".dat".equalsIgnoreCase(filename.substring(filename.length() - 4))) {

                    Path inputFilePath = inputPath.resolve((Path) event.context());
                    Path outputFilePath = outputPath.resolve(filename.replace(".dat", ".done.dat"));

                    System.out.println("Lendo arquivo de ".concat(inputFilePath.toString()));
                    List<String> lines = Files.readAllLines(inputFilePath);

                    System.out.println("processando...");
                    service.registerAll(lines);
                    
                    try (BufferedWriter writer = Files.newBufferedWriter(outputFilePath)) {
                        writer.write(service.getReportResult());
                        System.out.println("Resultado do processamento em ".concat(outputFilePath.toString()));
                    }
                }
            }
            key.reset();
        }

    }

}
