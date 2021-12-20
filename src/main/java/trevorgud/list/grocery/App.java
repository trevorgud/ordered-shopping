package trevorgud.list.grocery;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;

import trevorgud.list.grocery.models.GroceryList;
import trevorgud.list.grocery.models.ListInstance;

public class App {
  public static void main(String[] args) {
    System.out.println("Hello World!");

    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new Jdk8Module());

    Path masterListPath = Path.of("/home/trevor/git/ordered-shopping/json/master-list.json");
    try {
      String masterListStr = Files.readString(masterListPath);
      System.out.println(masterListStr);
      GroceryList myList = mapper.readValue(masterListStr, GroceryList.class);
      System.out.println(myList.name);
    } catch (IOException exception) {
      exception.printStackTrace();
    }

    Path listInstancePath = Path.of("/home/trevor/git/ordered-shopping/json/list-instance.json");
    try {
      String listInstanceStr = Files.readString(listInstancePath);
      System.out.println(listInstanceStr);
      ListInstance listInstance = mapper.readValue(listInstanceStr, ListInstance.class);
      System.out.println(listInstance.listId);
    } catch (IOException exception) {
      exception.printStackTrace();
    }
  }
}
