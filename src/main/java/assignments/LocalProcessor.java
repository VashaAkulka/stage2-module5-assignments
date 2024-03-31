package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private StringBuilder processorName;
    private Long period = 10_000_000_000_000L;
    protected StringBuilder processorVersion;
    private Integer valueOfCheap;
    private Scanner informationScanner;
    private List<String> stringArrayList;

    public LocalProcessor(String processorName, String processorVersion,
                          Integer valueOfCheap, List<String> stringArrayList) {
        this.processorName.append(processorName);
        this.processorVersion.append(processorVersion);
        this.valueOfCheap = valueOfCheap;
        this.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(List<String> stringList) {
        stringList.stream()
                .filter(Objects::nonNull)
                .map(Objects::hashCode)
                .forEach(System.out::println);
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(List<String> stringList) {
        return stringList.stream()
                .filter(Objects::nonNull)
                .peek(s -> processorName.append(s))
                .collect(Collectors.joining());
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) {
        try {
            this.informationScanner = new Scanner(file);
            while (this.informationScanner.hasNext()) {
                this.processorVersion.append(this.informationScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            this.informationScanner.close();
        }
    }
}