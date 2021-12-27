package trevorgud.list.grocery;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;

import trevorgud.list.grocery.ListRenderer;
import trevorgud.list.grocery.models.InventoryList;
import trevorgud.list.grocery.models.ShoppingList;

public class App {
  public static void main(String[] args) {
    System.out.println("Ordered Shopping List v0.0.1");

    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new Jdk8Module());

    // Parse the inventory list from JSON file.
    Path invListPath = Path.of("/home/trevor/git/ordered-shopping/json/inventory-list.json");
    InventoryList invList = new InventoryList();
    try {
      String invListStr = Files.readString(invListPath);
      System.out.println(invListStr);
      invList = mapper.readValue(invListStr, InventoryList.class);
    } catch (IOException exception) {
      exception.printStackTrace();
    }


    // Parse the shopping list from JSON file.
    Path shopListPath = Path.of("/home/trevor/git/ordered-shopping/json/shopping-list.json");
    ShoppingList shopList = new ShoppingList();
    try {
      String shopListStr = Files.readString(shopListPath);
      System.out.println(shopListStr);
      shopList = mapper.readValue(shopListStr, ShoppingList.class);
    } catch (IOException exception) {
      exception.printStackTrace();
    }

    ListRenderer renderer = new ListRenderer(invList, shopList);
    renderer.renderConsole();
  }
}
