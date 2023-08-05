# Tool Palette Feature

GLSP provides different ways to provide command actions in the modeling pane to add new elements. 

## The ToolPaletteItemProvider

The ToolPalette is a graphical element shown all nodes and edges the user could place into a model. If you do not specify a custom Tool PaletteItemProvider, GLSP will automatically create a default Tool Palette for you, listing all your nodes and edges defined in your server model.

<img src="../images/ToolPaletteItemProvider-01.png" />

The items will be sorted in alphanumeric order and grouped by 'Nodes' and 'Edges'.  Of course you can define your own ToolPaletteItemProvider, for example to group your different CreationActions in  a custom order. To do so you need to implement a `ToolPaletteItemProvider` and overwrite at least the method `getItems`. 

The following example shows how to implement a custom ToolPaletteItemProvider:

```java
public class BPMNToolPaletteItemProvider implements ToolPaletteItemProvider {

   @Inject
   protected OperationHandlerRegistry operationHandlerRegistry;
   private int counter;

   @Override
   public List<PaletteItem> getItems(final Map<String, String> args) {
      List<CreateOperationHandler> handlers = operationHandlerRegistry.getAll().stream()
         .filter(CreateOperationHandler.class::isInstance)
         .map(CreateOperationHandler.class::cast)
         .collect(Collectors.toList());
      counter = 0;

      // Create custom sorted palette with groups
      return Lists.newArrayList(
         PaletteItem.createPaletteGroup("task-group", "Tasks", createPaletteTaskItems(), "symbol-property", "A"),
         PaletteItem.createPaletteGroup("event-group", "Events", createPaletteEventItems(), "symbol-property", "B"),
   }

   /**
    * Create a palette Item Group with all Task elements
    *
    * @return
    */
   protected List<PaletteItem> createPaletteTaskItems() {

      List<PaletteItem> result = new ArrayList<>();
      result.add(new PaletteItem("manual-task", "Manual Task", new TriggerNodeCreationAction(ModelTypes.MANUAL_TASK)));
      result.add(new PaletteItem("service-task", "Service Task", new TriggerNodeCreationAction(ModelTypes.SERVICE_TASK)));
      result.add(new PaletteItem("send-task", "Send Task", new TriggerNodeCreationAction(ModelTypes.SERVICE_TASK)));

      return result;
   }

   /**
    * Create a palette Item Group with all Event elements
    *
    * @return
    */
   protected List<PaletteItem> createPaletteEventItems() {

      List<PaletteItem> result = new ArrayList<>();
      result.add(new PaletteItem("start-event", "Start Event", new TriggerNodeCreationAction(ModelTypes.START_EVENT)));
      result.add(new PaletteItem("end-event", "End Event", new TriggerNodeCreationAction(ModelTypes.END_EVENT)));

      return result;
   }
   ....

}
```
	
In this example we create three palette groups '*Tasks*' and '*Events*'. 
 
The method `PaletteItem.createPaletteGroup` expects a an unique ID, a label and the list of PaletteItem elements shown in this group. You can also provide a sorting hint for each group. For more information see also the implementation of [DefaultToolPaletteItemProvider](https://github.com/eclipse-glsp/glsp-server/blob/master/plugins/org.eclipse.glsp.server/src/org/eclipse/glsp/server/internal/toolpalette/DefaultToolPaletteItemProvider.java). 



### Binding

Finally you need to bind your custom ToolPaletteItemProvider in your server DiagramModule:


```java
   @Override
   protected Class<? extends ToolPaletteItemProvider> bindToolPaletteItemProvider() {
      return MyToolPaletteItemProvider.class;
   }
```

<img src="./images/ToolPaletteItemProvider-02.png" /> 

## The CommandPaletteActionProvider

Another Palette Feature is the CommandPalette. This command palette opens up on `Ctrl+Space` and shows actions in a specific context.

<img src="./images/CommandPaletteItemProvider-01.png" /> 
