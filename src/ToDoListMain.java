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
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowList();
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
            //if not empty then remove the data and make rest of list up
            for(var i = number - 1; i < model.length; i++){
                if(i == model.length - 1) {
                    model[i] = null;
                }else{
                    model[i] = model[i+1];
                }
            }
            return true;
        }
    }

    /**
     * Testing if to do on number inputted was removed correctly
     */
    public static void testRemove(){
        add("Test1");
        add("Test2");
        add("Test3");

        var result = remove(20);
        System.out.println("Result : " + result);

        var result2 = remove(1);
        System.out.println("Result : " + result2);

        var result3 = remove(2);
        System.out.println("Result : " + result3);

        showList();
    }

    /**
     * Make Input function where user input a data
     * @return String data
     */
    public static String input(String command){
        System.out.print(command + " : ");
        return scanner.nextLine();
    }

    /**
     * Test input function
     */
    public static void testInput(){
        var info = input("Masukan Nama");
        System.out.println("Hi " + info);

        var info2 = input("Masukan tanggal lahir");
        System.out.println("Tanggal lahir : " + info2);
    }

    /**
     * Procedure to show view of list
     */
    public static void viewShowList(){
        loop : while(true){
            System.out.println("TO DO LIST");
            showList();

            System.out.println("==================");
            System.out.println("MENU");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("X. Keluar");

            var menu = input("Pilh Menu");

            switch (menu){
                case "1" -> {
                    viewAddToDo();
                }
                case "2" -> {
                    viewRemoveToDo();
                }
                case "X" -> {
                    System.out.println("Close");
                    break loop;
                }
                default -> System.out.println("Menu tidak ada \n");
            }
        }
    }

    /**
     * Testing view show list with menu after add some test data
     */
    public static void testViewShowList(){
        add("Test 1");
        add("Test 2");
        add("Test 3");
        add("Test 4");
        add("Test 5");

        viewShowList();
    }

    /**
     * Procedure to show view to add To-Do
     */
    public static void viewAddToDo(){
        System.out.println("===========================");
        System.out.println("ADD TO DO");
        var todo = input("Masukan To Do");
        var confirmation = input("Anda yakin? (1. Ya | 2. Tidak)");
        switch (confirmation){
            case "1" -> {
                //ya
                add(todo);
            }
            case "2" -> {
                //batal
                viewShowList();
            }
        }
    }

    /**
     * Testing view add Todo
     */
    public static void testViewAddToDo(){
        viewAddToDo();
        showList();
    }

    /**
     * Procedure to show view to remove To-Do
     */
    public static void viewRemoveToDo(){
        System.out.println("=================");
        System.out.println("HAPUS TO DO LIST");
        showList();

        var todo = input("Pilh To Do yang akan dihapus");
        var confirmation = input("Anda yakin? (1. Ya | 2. Tidak)");
        switch (confirmation){
            case "1" -> {
                //ya
                boolean result = remove(Integer.valueOf(todo));
                if(result){
                    System.out.println("Sukses menghapus To Do");
                }else{
                    System.out.println("Gagal menghapus To Do list ke-" + todo);
                }
            }
            case "2" -> {
                //batal
                viewShowList();
            }
        }
    }

    /**
     * Testing view remove to do list
     */
    public static void testViewRemoveToDo(){
        add("Test 1");
        add("Test 2");
        add("Test 3");

        viewRemoveToDo();
        showList();
    }
}
