import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class PlagiarismChecker {
    private String sourceText;
    private String testText;
    private int nGramSize = 5; // Adjust the substring size as needed

    public PlagiarismChecker(String sourcePath, String testPath) throws IOException {
        this.sourceText = new String(Files.readAllBytes(Paths.get(sourcePath))).toLowerCase()
                .replaceAll("[^a-zA-Z0-9 ]", ""); // Remove special characters
        this.testText = new String(Files.readAllBytes(Paths.get(testPath))).toLowerCase()
                .replaceAll("[^a-zA-Z0-9 ]", "");
    }

    public void checkPlagiarism() {
        System.out.println("🔍 Checking plagiarism...");

        if (testText.length() < nGramSize) {
            System.out.println("❌ Test text is too short for n-gram comparison.");
            return;
        }

        KMPAlgorithm kmp = new KMPAlgorithm();
        int totalMatches = 0;
        int totalSubstrings = testText.length() - nGramSize + 1;

        for (int i = 0; i <= testText.length() - nGramSize; i++) {
            String testSubstring = testText.substring(i, i + nGramSize);
            int matchIndex = kmp.search(sourceText, testSubstring);
            if (matchIndex != -1) {
                totalMatches++; // Count only valid matches
            }
        }

        double plagiarismPercentage = ((double) totalMatches / totalSubstrings) * 100;
        System.out.println("✅ Plagiarism Detection Completed!");
        System.out.println("📊 Plagiarism Score: " + String.format("%.2f", plagiarismPercentage) + "%");
    }

    public static void main(String[] args) {
        try {
            PlagiarismChecker checker = new PlagiarismChecker("source.txt", "test.txt");
            checker.checkPlagiarism();
        } catch (IOException e) {
            System.out.println("Error reading files: " + e.getMessage());
        }
    }
}
