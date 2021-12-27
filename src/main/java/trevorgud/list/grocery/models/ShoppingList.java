package trevorgud.list.grocery.models;

import java.util.ArrayList;
import java.util.Date;

public class ShoppingList {
  public Integer listId;
  public String name;
  public Date date;
  public ArrayList<ShoppingGroup> groups;
}
