
import java.io.IOException;

public class Main {
  public static void main(String[] args) {
    try {
      PlagiarismChecker checker = new PlagiarismChecker("input/source.txt", "input/test.txt");
      checker.checkPlagiarism();
    } catch (IOException e) {
      System.out.println("Error:" + e.getMessage());
    }
  }

}