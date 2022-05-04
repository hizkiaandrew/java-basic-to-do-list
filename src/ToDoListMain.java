public class ToDoListMain {
    /**
     * First step make a business logic
     * 1. Make a Procedure to show list
     * 2. Make a Procedure to add to-do
     * 3. Make a Procedure to remove to-do
     * 4. All to-do is saved into an array of String with maximum size 10 list
     *
     * Second step implementation business logic & its testing method
     *
     *
     *
     */
    public static String[] model = new String[10];

    public static void main(String[] args) {
        testAdd();
    }

    /**
     * Show To Do List
     */
    public static void showList(){
        //Check if list is not empty and print all to-do from list
        for(var i = 0; i < model.length; i++){
            var todo = model[i];
            if(todo != null){
                System.out.println((i+1) + ". " + todo);
            }
        }
    }

    /**
     * Test if show list working correctly
     */
    public static void testShowList(){
        model[0] = "read";
        model[1] = "cook";
        showList();
    }

    /**
     * Add To Do to List
     */
    public static void add(String toDo){
        //Check list was full or not?
        var isFull = true;
        for(var i = 0; i < model.length; i++){
            if(model[i] == null){
                isFull = false;
                break;
            }
        }

        //If list was full, the size of array was resized by copying model and add them again.
        if(isFull == true){
            var temp = model;
            model = new String[model.length * 2];

            for(var i = 0; i < temp.length; i++){
                model[i] = temp[i];
            }
        }

        //Add string to last null position on array
        for(var i = 0; i<model.length; i++){
            if(model[i] == null){
                //Add String to list
                model[i] = toDo;
                break;
            }
        }
    }

    /**
     * Test if to do was added correctly
     * By add dummies data to list
     */
    public static void testAdd(){
        for(var i = 0; i<20; i++){
            add("Test Todo" + i);
        }

        showList();
    }

    /**
     * Remove To Do from list
     */
    public static boolean remove(int number){
        //check if number inputted exceed list length or not
        if((number-1) >= model.length){
            return false;
        }

        //check if the data on number inputted was empty or not
        if(model[number-1] == null) {
            return false;
        }else {
            //if not empty then remove the data
            model[number-1] = null;
            return true;
        }
    }

    /**
     * Testing if to do on number inputted was removed correctly
     */
    public static void testRemove(){
    }

    /**
     * Procedure to show view of list
     */
    public static void viewShowList(){

    }

    /**
     * Procedure to show view to add To-Do
     */
    public static void viewAddToDo(){

    }

    /**
     * Procedure to show view to remove To-Do
     */
    public static void viewRemoveToDo(){

    }
}
