package trevorgud.list.grocery;

import trevorgud.list.grocery.models.InventoryGroup;
import trevorgud.list.grocery.models.InventoryItem;
import trevorgud.list.grocery.models.InventoryList;
import trevorgud.list.grocery.models.ShoppingGroup;
import trevorgud.list.grocery.models.ShoppingItem;
import trevorgud.list.grocery.models.ShoppingItemQuantity;
import trevorgud.list.grocery.models.ShoppingList;

/* Class to render a shopping list using the order of items given by the inventory list.
 * Currently supports rendering text to the console (stdout).
 */
public class ListRenderer {
  public ListRenderer(InventoryList inventoryList, ShoppingList shoppingList) {
    this.inventoryList = inventoryList;
    this.shoppingList = shoppingList;
  }

  // Render the shopping list to the console (stdout).
  public void renderConsole() {
    for (InventoryGroup inventoryGroup : this.inventoryList.groups) {
      for (ShoppingGroup shoppingGroup : this.shoppingList.groups) {
        if (inventoryGroup.id == shoppingGroup.groupId) {
          System.out.println("Group: " + inventoryGroup.name);
          this.renderGroupConsole(inventoryGroup, shoppingGroup);
        }
      }
    }
  }

  // Render the shopping group.
  private void renderGroupConsole(InventoryGroup inventoryGroup, ShoppingGroup shoppingGroup) {
    for (InventoryItem inventoryItem : inventoryGroup.items) {
      for (ShoppingItem shoppingItem : shoppingGroup.items) {
        if (inventoryItem.id == shoppingItem.itemId) {
          System.out.println(
            this.itemString(
              inventoryItem.name,
              shoppingItem.quantity,
              shoppingItem.completed
            )
          );
        }
      }
    }
  }

  // Create a formatted string for a single shopping item.
  private String itemString(
    String name,
    ShoppingItemQuantity quantity,
    Boolean completed
  ) {
    return String.format(
      " - %s (%s) %s",
      name,
      this.quantityString(quantity),
      this.completedString(completed)
    );
  }

  // Create a formatted string for item completion.
  private String completedString(Boolean completed) {
    return completed ? "[X]" : "[ ]";
  }

  // Create a formatted string for item quantity.
  private String quantityString(ShoppingItemQuantity quantity) {
    // TODO: Figure out how to deserialize JSON to Optional correctly.
    // Should evaluate to empty Optional instead of null when no field found.
    if (quantity.count != null && quantity.count.isPresent()) {
      return "Count: " + String.valueOf(quantity.count.get());
    } else if (quantity.weightKg != null && quantity.weightKg.isPresent()) {
      return "Weight: " + String.valueOf(quantity.weightKg.get()) + "Kg";
    } else {
      return "unknown";
    }
  }

  // The inventory list to use when rendering.
  private InventoryList inventoryList;

  // The shopping list to render.
  private ShoppingList shoppingList;
}
