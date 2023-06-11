public class Main
{
    public static void main(String[] args) throws Exception
    {  
     /**  Παρακάτω υπάρχουν οι ενότητες έτοιμων παραδειγμάτων
      * Για να τις δοκιμάσετε απενεργοποιήστε την το σύμβολο σχολίου πάνω πάνω ( /* -> //* )  
      * Μην ξεχάσετε να το ξαναεπαναφέρετε ώστε να γίνει η ενότητα σχόλιο και να μην γίνει κουραστικό (κολλάει το bluej οπότε ελέγξετε αν το  μπλοκ έγινε σχόλιο επιτυχώς )
      * 
      * ΠΕΡΙΕΧΟΜΕΝΑ:
      * 
      *           γραμμή:  82
      * 1η Ενότητα: δοκιμή μεθόδων προσθήκης - αφαίρεσης αντικειμένων στο κατάστημα 
      * 
      *           γραμμή:  167
      * 2η Ενότητα: δοκιμή μεθόδων προσθήκης - αφαίρεσης αγοραστών στο κατάστημα 
      * 
      *           γραμμή:  216
      * 3η Ενότητα: σκοπος  ειναι να ολοκληρωθουν αγορες και να υπολογιστουν οι τιμες και τα μεταφορικα 
      * 
      *           γραμμή:  266
      * 4η Ενότητα: προσωμοίωση διαφόρων πραγματικών σεναρίων 
      * 
      *           γραμμή:  379
      * Τέλος ακολουθεί η μέθοδος: menu.hello() που ξεκινά το πρόγραμμα 
      * έχει δημιουργηθεί και ένας έξτρα αγοραστής σε περίπτωση  
      * που επιθυμείτε να συνδεθείτε με υπάρχων λογαριασμό
      * 
      * 
      * ΠΡΟΣΟΧΗ: Αν δεν τρέχει τίποτα ( εμφανίζονται μόνο 3εις γραμμές ) , κοιτάξτε αν έχει "μετατραπεί" επιτυχώς 
      * η ενότητα από σχόλιο σε κώδικα γιατί το bluej κολλάει (συνήθως με ένα απλό spacebar διορθώνεται)
      * 
      */   
               
    
       
                             /**eshop**/
        
       EShop Ebooking = new EShop("E-booking:)") ;
  
                        /**Owner**/
       
       Owner owner = new Owner("Sherlock Holmes","mystery@outlook.com" );
       
                /**menu*/
         
       Menu menu = new Menu(Ebooking,owner);
      
       /**items**/
       
       Pen pen = new Pen("Awesome Pen",1.27,"cool",25,1072578,"red",1.2);
       Pen pen1 = new Pen("Awesome Pen",1.27,"cool",25,1600,"red",1.2); // diff id, same name
       Pen pen2 = new Pen("Great Pen",1.3,"MEh..cool",38,1072787,"green",1.8);
       Pen pen3 = new Pen("Relaxing Pen",1.7,"U will enjoy writing for hous",32,12756,"purple",1.4);
       Pen pen4 = new Pen("Gray 5.0",1f,"Only for REAL Pros",135,1072578,"grey",1.5);
       
       Notebook notebook = new Notebook("Black&Yellow",1.75,"For the coolest",17,1315,4);
       Notebook notebook2 = new Notebook("Red-black",1.50,"Write in Passion",45,1072510,3);
       Notebook notebook3 = new Notebook("Greeny/Blue",2,"Imaginary",10,12890,5);
       
       Pencil pencil = new Pencil("Flawless",1500f,"The Ultimate Writing Experience",150,12335,0.06,"HB");
       Pencil pencil2 = new Pencil("The Smart Pencil",0.2,"Make ur Life Easier",989,99735,0.05,"H");
       Pencil pencil3 = new Pencil("Faster Than Light",0.6,"Use Your Time Wisely",77,1865,0.07,"B");  
       
       Paper paper = new Paper("Aquarela",1.30,"BE THE ARTIST",40,8089,40,100); 
       Paper paper2 = new Paper("Ultra-thin",1.40,"Use it everywhere!!",100,8659,30,200); 
       Paper paper3 = new Paper("Draw-Special",700,"Watch ur dreams awake",60,45968,50,150); 
       
                    /**buyers**/
             
       Buyer buyer = new Buyer("Bouskas","hBousk@upatras.gr",Ebooking);
       Buyer buyer1 = new Buyer("Kostas Bouskas","hBousk@upatras.gr",Ebooking);
          //ίδιο email
       Buyer buyer2 = new Buyer("Bouskas","hBousk@gmail.com",Ebooking); 
          // ίδιο όνομα
       Buyer buyer3 = new Buyer("Brownson","charles3@hotmail.com",Ebooking);
       Buyer buyer4 = new Buyer("Vettel","weltmeister@gmail.com",Ebooking);
     

       
       
       
     /**-=-=-=-=-=-=-==-=-=-=-  1η Ενοτητα   -=-==-=-=-=-=-==-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=  */  
     //Εδω δοκιμάζονται οι μέθοδοι addItem,removeItem() της EShop και η εξαίρεση UknownTypeException για μολυβια 
      /*  <-------------------------------------------------
    
       Pencil pencil4 = new Pencil("Cool 'Breath'",0.35f,"Smoother than Ice",134,1835,0.04,"L"); //there is no L type
      
           System.out.println("Προστιθεται νέο αντικείμενο");
       Ebooking.addItem(pen);
           System.out.println("**ItemsList size: "+Ebooking.itemsList.size() +", μόνο για επίδειξη"); 
           System.out.println("Προστιθεται ξανά το προηγούμενο αντικείμενο");
       Ebooking.addItem(pen);
           System.out.println("**ItemsList size: "+Ebooking.itemsList.size() +", μόνο για επίδειξη"); 
           System.out.println("Προστιθεται νέο αντικείμενο, με το ίδιο όνομα με το 1ο");
       Ebooking.addItem(pen1);
           System.out.println("**ItemsList size: "+Ebooking.itemsList.size() +", μόνο για επίδειξη"); 
           System.out.println("Προστιθεται νέο αντικείμενο");
       Ebooking.addItem(pen2);
           System.out.println("**ItemsList size: "+Ebooking.itemsList.size() +", μόνο για επίδειξη"); 
           System.out.println("Προστιθεται νέο  αντικείμενο, με το ίδιο id με το 1ο");   
       Ebooking.addItem(pen4);
           System.out.println("**ItemsList size: "+Ebooking.itemsList.size() +", μόνο για επίδειξη");
           System.out.println("Αφαιρείται το 1ο αντικείμενο");
       Ebooking.removeItem(pen);
           System.out.println("**ItemsList size: "+Ebooking.itemsList.size() +", μόνο για επίδειξη"); 
           System.out.println("Προστιθεται νέο  αντικείμενο");
       Ebooking.addItem(pen3);
           System.out.println("**ItemsList size: "+Ebooking.itemsList.size() +", μόνο για επίδειξη");
           System.out.println("Προστιθεται νέο  αντικείμενο");
       Ebooking.addItem(pen);
           System.out.println("**ItemsList size: "+Ebooking.itemsList.size() +", μόνο για επίδειξη");    
           System.out.println("Προστιθεται νέο αντικείμενο");
       Ebooking.addItem(notebook);
           System.out.println("**ItemsList size: "+Ebooking.itemsList.size() +", μόνο για επίδειξη"); 
           System.out.println("Προστιθεται νέο  αντικείμενο");
       Ebooking.addItem(notebook3);
           System.out.println("**ItemsList size: "+Ebooking.itemsList.size() +", μόνο για επίδειξη"); 
           System.out.println("Προστιθεται νέο  αντικείμενο");
       Ebooking.addItem(notebook2);
           System.out.println("**ItemsList size: "+Ebooking.itemsList.size() +", μόνο για επίδειξη"); 
           System.out.println("Προστιθεται νέο  αντικείμενο");
           
       Ebooking.addItem(pencil); 
           System.out.println("**ItemsList size: "+Ebooking.itemsList.size() +", μόνο για επίδειξη"); 
           System.out.println("Προστιθεται νέο  αντικείμενο");
       Ebooking.addItem(pencil2);
           System.out.println("**ItemsList size: "+Ebooking.itemsList.size() +", μόνο για επίδειξη"); 
           System.out.println("Προστιθεται νέο  αντικείμενο");
       Ebooking.addItem(pencil4);
           System.out.println("**ItemsList size: "+Ebooking.itemsList.size() +", μόνο για επίδειξη"); 
           System.out.println("Προστιθεται νέο  αντικείμενο");
           
       Ebooking.addItem(paper);
           System.out.println("**ItemsList size: "+Ebooking.itemsList.size() +", μόνο για επίδειξη"); 
           System.out.println("Προστιθεται νέο  αντικείμενο");
       Ebooking.addItem(paper2);
           System.out.println("**ItemsList size: "+Ebooking.itemsList.size() +", μόνο για επίδειξη"); 
           System.out.println("Προστιθεται νέο  αντικείμενο");
       Ebooking.addItem(paper3);
           System.out.println("**ItemsList size: "+Ebooking.itemsList.size() +", μόνο για επίδειξη"); 
           
      System.out.println("--------------------------------------");
      System.exit(0);    
      //*/
      
      /** =-=-=-=-=-==-=-=-=-=-= Τέλος 1ης Ενότητας -=-==-=-=-=-==-=-=-=-=-==-=-=-=-=-=-=-=-=-=-===---*/
       
      
      
      //Ξαναπροσθέτουμε τα αντικείμενα για να αποδεσμευτεί χωρίς πρόβλημα η 1η ενότητα
       Ebooking.addItem(pen1);
       Ebooking.addItem(pen2);
       Ebooking.addItem(pen3);  
       Ebooking.addItem(notebook);      
       Ebooking.addItem(notebook3);      
       Ebooking.addItem(notebook2);
       Ebooking.addItem(pencil);  
       Ebooking.addItem(pencil2);      
       Ebooking.addItem(pencil3);      
       Ebooking.addItem(paper);      
       Ebooking.addItem(paper2);     
       Ebooking.addItem(paper3);      
      
       
       
       
      /**-=-=-=-==-=-=-=-=-=-==-=-  2η Ενότητα -=-=-=-==-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=*/ 
      //Εδώ δοκιμάζονται οι μέθοδοι addBuyer() ,removeBuyer() και η εξαιρέση BuyerExistsAlreadyException()
    
         /*  <-------------------------
    
            System.out.println("Προστίθεται ο 1ος αγοραστής");
       Ebooking.addBuyer(buyer);
            System.out.println("**ΒuyersList size: "+Ebooking.buyersList.size() +" ,μόνο για επίδειξη");
            System.out.println("Προστίθεται και 2ος αγοραστής");
       Ebooking.addBuyer(buyer3);
            System.out.println("**ΒuyersList size: "+Ebooking.buyersList.size() +", μόνο για επίδειξη");
            System.out.println("O επόμενος αγοραστης έχει ίδιο email με τον πρώτο που προσθέσαμε");
       Ebooking.addBuyer(buyer1);
            System.out.println("**ΒuyersList size: "+Ebooking.buyersList.size() +" ,μόνο για επίδειξη");
            System.out.println("O επόμενος αγοραστης είναι ο ίδιος με τον 1ο που προσθέσαμε");
       Ebooking.addBuyer(buyer);
            System.out.println("**ΒuyersList size: "+Ebooking.buyersList.size() +", μόνο για επίδειξη");
            System.out.println("O επόμενος αγοραστης έχει ίδιο όνομα με τον πρώτο που προσθέσαμε");
       Ebooking.addBuyer(buyer2);
            System.out.println("**ΒuyersList size: "+Ebooking.buyersList.size() +", μόνο για επίδειξη");
            System.out.println("Αφαιρείται ο πρώτος"); 
       Ebooking.removeBuyer(buyer);
            System.out.println("**ΒuyersList size: "+Ebooking.buyersList.size() +", μόνο για επίδειξη");
            System.out.println("Ξανα προστίθεται ο πρώτος");
       Ebooking.addBuyer(buyer);
            System.out.println("**ΒuyersList size: "+Ebooking.buyersList.size() +", μόνο για επίδειξη");
            System.out.println("Προστίθεται τρίτος");
       Ebooking.addBuyer(buyer4);
             System.out.println("**ΒuyersList size: "+Ebooking.buyersList.size() +", μόνο για επίδειξη");
 
       System.out.println("--------------------------------------");    
       System.exit(0); 
      //*/
      
      
      /**-==-=-=-=-=-==-=-=-==- Τέλος 2ης Ενότητας  -=-=-=-=-=-=-=-=-=-==-=-=-=-==-=-=-=-==-=-=-=-=-==*/
       
      
      
      //προστίθονται οι αγοραστές για να συνεχίσει απρόσκοπτα το πρόγραμμά μας
      Ebooking.addBuyer(buyer1);
      Ebooking.addBuyer(buyer3);
      Ebooking.addBuyer(buyer4);
      
      
   

      
      
      /**-=-=-==-=-=-=-==-=-=-=-=  3η Ενότητα -=-=-=-=-==-=-=-=-=-==--==-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-*/
       /*  Τεστάρονται οι μέθοδοι placeOrder(),calculateNet(),calculateCourierCost() και πολλες αλλες */
          /*    <-------------------------------------------
         System.out.println("H επόμενη παραγγελία περιέχει 12 αντικείμενα notebook (στοκ: 17)");
      buyer1.placeOrder(notebook,12);
         System.out.println("Notebook Stock: " + notebook.getStock());
         System.out.println("H επόμενη παραγγελία ξεπερνά απευθείας το διαθέσιμο στοκ");
      buyer.placeOrder(paper,41);
          System.out.println("H επόμενη παραγγελία περιλαμβάνει 6 αντικείμενα notebook (στοκ: 5)");
      buyer3.placeOrder(notebook,6);
          System.out.println("H επόμενη παραγγελία περιέχει αρνητική ποσότητα");
      buyer.placeOrder(paper,-1);
                    System.out.println("-----------\nΣτο παρακάτω κομμάτι μην δώσετε λάθος αποτέλεσμα καθώς δεν υπάρχει μέσα στις");
                    System.out.println("μεθόδους δυνατοτητα επανάληψης και πρακτικά δεν θα εξεταστεί η λειτουργία τους\n -----------\n\n"); 
                    
          System.out.println("H επόμενη παραγγελία περιέχει μολύβι αξίας 1500 ευρω (150 ποντοι)(αποδεχτείτε την πληρωμή πατώντας y )\n");
      buyer3.placeOrder(pencil,2);
          System.out.println("Kατηγορία: " + buyer3.getBuyerCategory() );
      buyer3.shopcart.checkout(buyer3);
          System.out.println("\nH επόμενη παραγγελία αφορά τον ίδιο αγοραστή και γίνεται για να τεσταριστεί η μέθοδος που εμφανίζει τα μεταφορικα ");
          System.out.println("Πλέον ο αγοραστης αυτός ειναι GOLD οποτε περιμενουμε 0");
          System.out.println("***Αρχικό στοκ: " + paper2.getStock() );
      buyer3.placeOrder(paper2,4);
          System.out.println("Kατηγορία: " + buyer3.getBuyerCategory() );
      buyer3.shopcart.checkout(buyer3);
          System.out.println("***Στοκ μετά την αγορά: " + paper2.getStock() +"\n" );
                    
          System.out.println("H επόμενη παραγγελία αφορά άλλον αγοραστή και περιλαμβάνει αντικείμενα αξίας 700 ευρω");
          System.out.println("Ο συγκεκριμένος έχει ήδη κάτι στο καλάθι εκτός απο τα αντικείμενα αξιας 700 ευρω\n");
      buyer1.placeOrder(paper3,2);
          System.out.println("Kατηγορία: " + buyer.getBuyerCategory() ); 
      buyer1.shopcart.checkout(buyer1);
      System.out.println("\nH επόμενη παραγγελία αφορά τον ίδιο αγοραστή και γίνεται για να τεσταριστεί η μέθοδος που εμφανίζει τα μεταφορικα ");
          System.out.println("Πλέον ο αγοραστής είναι SILVER και η τιμή των μεταφορικων που στοιχήζουν λιγότερο από 3 ευρώ");
      buyer1.placeOrder(pen,2);
          System.out.println("Kατηγορία: " + buyer.getBuyerCategory() ); 
      buyer1.shopcart.checkout(buyer1);
          System.out.println("--------------------------------------");
      System.exit(0); 
      //*/
      
      /**-==-=-=-=-=-==-=-=-==- Τέλος 3ης Ενότητας  -=-=-=-=-=-=-=-=-=-==-=-=-=-==-=-=-=-==-=-=-=-=-==*/
      
      
     
     
      
      
     
           
     /**-==-=-=-=-=-==-=-=-==- 4η Ενότητα  -=-=-=-=-=-=-=-=-=-==-=-=-=-==-=-=-=-=-=-=-==-=-*/
      //**  δοκιμες των μεθοδων της menu για τον owner
     
              /*     <------------------                  
                                          
                               buyer3.placeOrder(notebook,14);
                               buyer3.placeOrder(pen1,4);   
                               menu.ownerHello(); 
             //*/  
             
        /* katastima      προτεινόμενες είσοδοι την μέθοδο ownerHello()
         *notebook
         *yes
         *1072510
         *y  
         *45 //το στοκ ειναι πλεον 90
         *notebook
         *yes
         *1072510 //90 ξανα στις πληροφορίες
         *n
         *notebook
         *menu
         * pelates //δηλαδη (  menu.checkStatus() )
         * Vettel //προτεινόμενες είσοδοι. o Vettel είναι ηδη αγοραστης
         *  y
         * pelates // ο vettel πλέον θα έχει διαγραφεί
         * Brownson // ο μονος με πραγματα στο καλαθι
         * n
         * menu
         * exit
         */
        
                                     /*   <----------------
                                      buyer4.placeOrder(notebook2,1);   
                                      buyer4.placeOrder(paper2,2);
                                      Buyer tester = new Buyer("teacher","upAM@upatras.gr",Ebooking);
                                      Ebooking.addBuyer(tester);
                                      tester.placeOrder(paper2,2);
                                      tester.placeOrder(notebook2,6);
                                      menu.buyerHello(buyer4); 
                                    //*/      
                                          
                                          
       /*         προτεινόμενες είσοδοι για την μεθοδο
        * kalathi 
        * menu
        *katastima
        *pen
        *12756 //λανθασμενος κωδικος (ήθελε yes ή menu)
        *pen
        *yes
        *12756
        *y
        *78
        *h
        *pen
        *yes
        *1600
        *y
        *3
        * menu
        * kalathi
        * change
        * Ultra-thin
        * 4   // παρατηρούμε πως μετά έχει αλλάξει η ποσότητα( 2 -> 4)
        * delete  
        * Ultra-thin
        * pay
        * y  
        * user
        * upAM@upatras.gr
        * kalathi
        * clear //βλέπουμε πως αδειάζει (Oops. Από ότι φαίνεται το καλάθι σας είναι άδειο...κλπ)
        * menu
        * exit
        **/
                                       
                            /*   <----------------  
                              menu.viewCart(buyer4);    
                           //*/
        
        /* προτεινόμενες είσοδοι
         * y (άδειο καλάθι)
         * paper 
         * 8089 //λαθος
         * paper
         * yes 
         * 8089
         * y
         * -1
         * paper
         * yes
         * 8089
         * y
         * 2
         * h
         * paper
         * yes
         * 8089
         * y // παρατηρούμε πως το διαθέσιμο στοκ είναι 38 (40 - 2 που παραγγείλαμε νωρίτερα)
         * 4
         * menu
         * kalathi
         * menu
         * exit
         */                                 
        
     /**-==-=-=-=-=-==-=-=-==- Τέλος 4ης Ενότητας  -=-=-=-=-=-=-=-=-=-==-=-=-=-==-=-=-=-==-=-*/
        
        
     
     
     
     /**==--=-=-=-=-=--  -------> The real program STARTS HERE <-------   --=-=-=-=-=-=--==**/
     
     
         //*  <--------------------
                          //menu starting operation 
                          
          Buyer tester = new Buyer("teacher","upAM@upatras.gr",Ebooking);
          Ebooking.addBuyer(tester);
          menu.hello(); 
       
     //*/
      
      
      
     System.out.println("--------------\n--------------\n--------------");
    }
}
