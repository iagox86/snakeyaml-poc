import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import java.io.File;
import java.util.List;

public class MyTestClass implements ScriptEngineFactory {
  public MyTestClass() {
    try {
      /* Total number of processors or cores available to the JVM */
      System.out.println("Available processors (cores): " + Runtime.getRuntime().availableProcessors());

      /* Total amount of free memory available to the JVM */
      System.out.println("Free memory (bytes): " + Runtime.getRuntime().freeMemory());

      /* This will return Long.MAX_VALUE if there is no preset limit */
      long maxMemory = Runtime.getRuntime().maxMemory();
      /* Maximum amount of memory the JVM will attempt to use */
      System.out.println("Maximum memory (bytes): " + (maxMemory == Long.MAX_VALUE ? "no limit" : maxMemory));

      /* Total memory currently available to the JVM */
      System.out.println("Total memory available to JVM (bytes): " + Runtime.getRuntime().totalMemory());

      /* Get a list of all filesystem roots on this system */
      File[] roots = File.listRoots();

      /* For each filesystem root, print some info */
      for (File root : roots) {
        System.out.println("File system root: " + root.getAbsolutePath());
        System.out.println("Total space (bytes): " + root.getTotalSpace());
        System.out.println("Free space (bytes): " + root.getFreeSpace());
        System.out.println("Usable space (bytes): " + root.getUsableSpace());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.exit(0);
  }

  @Override public String getEngineName() { return null; }
  @Override public String getEngineVersion() { return null; }
  @Override public List<String> getExtensions() { return null; }
  @Override public List<String> getMimeTypes() { return null; }
  @Override public List<String> getNames() { return null; }
  @Override public String getLanguageName() { return null; }
  @Override public String getLanguageVersion() { return null; }
  @Override public Object getParameter(String key) { return null; }
  @Override public String getMethodCallSyntax(String obj, String m, String... args) { return null; }
  @Override public String getOutputStatement(String toDisplay) { return null; }
  @Override public String getProgram(String... statements) { return null; }
  @Override public ScriptEngine getScriptEngine() { return null; }
}
