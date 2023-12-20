import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.InputStream;

class MySerialClass {
  private long id;
  public Object objectField;
  public String stringField;

  public MySerialClass() {
  }

  public MySerialClass(long id, Object test) {
    this.id = id;
    this.objectField = test;
    this.stringField = test.toString();
  }

  public String toString() {
    return id + " " + stringField.toString();
  }
}

public class App {
  public static void main(String[] args) throws Exception {
    MySerialClass data = null;

    if(args.length == 0) {
      data = new MySerialClass(1337, "Hello!");
    } else {
      InputStream inputStream = new FileInputStream(args[0]);
      Yaml yaml = new Yaml(new Constructor(MySerialClass.class));
      data = yaml.load(inputStream);
    }
    System.out.println("As string:");
    System.out.println(data);

    DumperOptions options = new DumperOptions();
    options.setIndent(2);
    options.setPrettyFlow(true);
    options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
    Yaml yaml = new Yaml(options);

    System.out.println();
    System.out.println("As YAML:");
    System.out.println(yaml.dump(data));
  }
}
